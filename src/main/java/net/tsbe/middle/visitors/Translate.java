package net.tsbe.middle.visitors;

import net.tsbe.middle.MemoryOffsetMapper;
import net.tsbe.middle.ReservedFrames;
import net.tsbe.middle.expressions.*;
import net.tsbe.middle.lang.*;
import net.tsbe.middle.models.*;
import net.tsbe.middle.MIDDLE_VALUE_TYPE;
import net.tsbe.middle.Register;
import net.tsbe.models.*;
import net.tsbe.models.Error;
import net.tsbe.models.enums.VALUE_TYPE;
import net.tsbe.models.nodes.*;
import net.tsbe.models.typechecking.MethodSignature;
import net.tsbe.models.typechecking.SymbolTable;
import net.tsbe.models.typechecking.TypeChecker;

import java.util.*;

public class Translate {
    private static List<Error> errors = new LinkedList<>();
    private static final TypeConverter typeConverter = new TypeConverter();

    //retourne la représentation intermédiaire du programme.
    public static Pair<Label, List<Pair<Frame, List<Command>>>> run(SymbolTable symbolTable, Program program) {
        TranslationVisitor translator = new TranslationVisitor(symbolTable);
        program.accept(translator);
        errors = translator.translation_errors;
        return new Pair<>(translator.mainLabel, translator.fragments);
    }

    public static List<Error> getErrors(){ return errors; }

    //transforme un type de l’Ast en type de la repr. int.
    private static MIDDLE_VALUE_TYPE ofType(ExpressionType type) {
        return type.accept(typeConverter);
    }

    private static MIDDLE_VALUE_TYPE ofType(VALUE_TYPE type) {
        switch (type){
            case INTEGER: return MIDDLE_VALUE_TYPE.INT;
            case BOOLEAN: return MIDDLE_VALUE_TYPE.BYTE;
            default: return MIDDLE_VALUE_TYPE.ADDRESS;
        }
    }
    private static class TypeConverter extends SimpleScriptBaseVisitor<MIDDLE_VALUE_TYPE> {
        @Override
        public MIDDLE_VALUE_TYPE visitExpressionType(ExpressionType ctx) {
            switch (ctx.getEnumType()){
                case INTEGER: return MIDDLE_VALUE_TYPE.INT;
                case BOOLEAN: return MIDDLE_VALUE_TYPE.BYTE;
                default: return MIDDLE_VALUE_TYPE.ADDRESS;
            }
        }
    }

    private static class TranslationVisitor extends OptimizedSimpleScriptBaseVisitor<Result> {

        private final SymbolTable symbolTable;
        private final TypeChecker typeChecker;

        private final Map<String, Frame> frames;
        private final Map<Pair<InstructionBlock, String>, Register> varToReg;
        //pour le lien entre noms de variables et registres.
        private final List<Pair<Frame, List<Command>>> fragments;
        //contiendra le code des fonctions, associé à leurs frames.
        private Frame mainFrame;
        private Frame currentFrame;
        private Label mainLabel;

        private List<String> reservedNamespacesUsed = new LinkedList<>();
        protected List<Error> translation_errors = new LinkedList<>();

        private Stack<InstructionBlock> blockStack = new Stack<>();

        Map<String, Integer> variableOffsets = new HashMap<>();

        public TranslationVisitor(SymbolTable symbolTable) {
            this.symbolTable = symbolTable;
            this.varToReg = new HashMap<>();
            this.typeChecker = new TypeChecker(symbolTable);
            this.fragments = new LinkedList<>();
            this.frames = new HashMap<>();
            this.currentFrame = null;
            this.mainLabel = null;
        }

        private Pair<InstructionBlock, String> inCurrentBlock(String variable) {
            return new Pair<>(typeChecker.getVisitedBlocks().peek(), variable);
        }

        private int getOrAllocateMemoryOffset(String varname){
            if(variableOffsets.containsKey(varname)) return variableOffsets.get(varname);
            Register register = registerLookup(varname);
            assert register != null : "Internal Error: no register associated with " + varname;
            int offset = MemoryOffsetMapper.allocate(register.getType());
            variableOffsets.put(varname, offset);
            return offset;
        }

        private int getOrAllocateMemoryOffset(String varname, Register register){
            if(variableOffsets.containsKey(varname)) return variableOffsets.get(varname);
            assert register != null : "Internal Error: no register associated with " + varname;
            int offset = MemoryOffsetMapper.allocate(register.getType());
            variableOffsets.put(varname, offset);
            return offset;
        }

        @Override
        public Result visitFunctionParameter(FunctionParameter ctx) {
            assert false : "Translate: internal error. This node should not be visited, please report";
            return null;
        }

        @Override
        public Result visitExpressionInteger(ExpressionInteger ctx) {
            return new Result(new IntMiddleExpression(ctx.getValue()));
        }

        @Override
        public Result visitExpressionBoolean(ExpressionBoolean ctx) {
            return new Result(new ByteMiddleExpression((byte) (ctx.isValue() ? 1 : 0)));
        }

        @Override
        public Result visitExpressionEmbedded(ExpressionEmbedded ctx) {
            return null;
        }

        private Register registerLookup(String name) {
            //retourne le registre associé au nom de variable 'name'
            //erreur si registre non trouvé
            //
            //Attention, comme pour l’analyse de type, la recherche
            //parcourt l’historique des blocs jusqu’à trouver un
            //résultat non nul dans l’association varToReg
            //
            //…
            Set<Pair<InstructionBlock, String>> keyset = varToReg.keySet();
            for(InstructionBlock b : blockStack){
                for(Pair<InstructionBlock, String> ks : keyset){
                    if(ks.getFirst().equals(b) && ks.getSecond().equals(name)){
                        return varToReg.get(ks);
                    }
                }
            }
            return null;
        }

        @Override
        public Result visitExpressionIdentifier(ExpressionIdentifier ctx) {
            Register reg = registerLookup(ctx.getId());
            return new Result(new ReadMemoryMiddleExpression(reg, getOrAllocateMemoryOffset(ctx.getId()), reg.getType()));
        }

        @Override
        public Result visitExpressionIncrement(ExpressionIncrement ctx) {
            return null;
        }

        @Override
        public Result visitExpressionBinary(ExpressionBinary ctx) {
            Result l = ctx.getLeft().accept(this);
            Result r = ctx.getRight().accept(this);
            MiddleExpression le = l.getExpression();
            MiddleExpression re = r.getExpression();
            BinaryMiddleExpression bin = new BinaryMiddleExpression(le, re, ctx.getOperation());
            List<Command> code = new LinkedList<>(l.getCode());
            code.addAll(r.getCode());
            return new Result(bin, code);
        }

        @Override
        public Result visitExpressionUnary(ExpressionUnary ctx) {
            Result r = ctx.getExpression().accept(this);
            MiddleExpression u = r.getExpression();
            UnaryMiddleExpression un = new UnaryMiddleExpression(u, ctx.getOperation());
            return new Result(un, r.getCode());
        }

        @Override
        public Result visitExpressionType(ExpressionType ctx) {
            return null;
        }

        @Override
        public Result visitInstructionVariableAssign(InstructionVariableAssign ctx) {
            Result result = ctx.getExpression().accept(this);
            List<Command> code = new LinkedList<>(result.getCode());
            String id = ctx.getId();
            Register register = registerLookup(id);
            assert register != null : "Internal Error: no register associated with " + id;
            code.add(new WriteRegisterCommand(register, result.getExpression()));
            code.add(new WriteMemoryCommand(register, getOrAllocateMemoryOffset(id), result.getExpression(), register.getType()));
            return new Result(code);
        }

        @Override
        public Result visitInstructionReturn(InstructionReturn ctx) {
            Result result = ctx.getExpression().accept(this);
            Register returnReg = currentFrame.getResultRegister().get();
            Command writeToReturnReg = new WriteRegisterCommand(returnReg, result.getExpression());
            Command writeToReturnMem = new WriteMemoryCommand(returnReg, getOrAllocateMemoryOffset("returnOfFrame"+currentFrame.getEntry(), returnReg), result.getExpression(), returnReg.getType());
            Command gotoExit = new JumpCommand(currentFrame.getExit());
            List<Command> code = new LinkedList<>(result.getCode());
            code.add(writeToReturnReg);
            code.add(writeToReturnMem);
            code.add(gotoExit);
            return new Result(code);
        }

        private Pair<List<MiddleExpression>,List<Command>> translateExpressions(List<Expression> exps) {
            List<Command> code = new LinkedList<>();
            List<MiddleExpression> expressions = new LinkedList<>();
            for (Expression expression : exps) {
                Result result = expression.accept(this);
                expressions.add(result.getExpression());
                code.addAll(result.getCode());
            }
            return new Pair<>(expressions, code);
        }

        private Result makeFunCall(MIDDLE_VALUE_TYPE type, Frame frame, List<MiddleExpression> arguments, List<Command> code) {
            Register reg = new Register(type);
            currentFrame.addLocalVariable(reg);
            Command call = new FunctionCallCommand(reg, frame, arguments);
            code.add(call);
            if(frame.getResultRegister().isPresent())
                return new Result(new ReadRegisterMiddleExpression(frame.getResultRegister().get()), code);
            else
                return new Result(new ReadRegisterMiddleExpression(reg), code);
        }

        @Override
        public Result visitExpressionFunctionCall(ExpressionFunctionCall ctx) {
            String functionName = ctx.getId();

            Pair<List<MiddleExpression>, List<Command>> translation = translateExpressions(ctx.getParameters());
            List<Command> code = translation.getSecond();
            List<MiddleExpression> args = translation.getFirst();
            if(ReservedFrames.isReservedFunctionName(functionName)){
                Frame fun = null;
                MIDDLE_VALUE_TYPE returnType = MIDDLE_VALUE_TYPE.VOID;
                switch (functionName){
                    case "print":
                        if(args.get(0).getType().equals(MIDDLE_VALUE_TYPE.INT)){
                            fun = ReservedFrames.PRINT_INT;
                            reservedNamespacesUsed.add("PRINT_INT");
                        }
                        else{
                            fun = ReservedFrames.PRINT_BYTE;
                            reservedNamespacesUsed.add("PRINT_BYTE");
                        }
                        break;
                    default:
                        translation_errors.add(new Error(ctx.getPosition(), "Found a reserved function name, but could not link it.", ctx));
                        return null;
                }
                fun.setReservedFrame(true);
                return makeFunCall(returnType, fun, args, code);
            }
            MethodSignature signature = symbolTable.methodLookup(functionName);
            assert !(signature==null) : "Internal Error: function name not in symbol table: " + functionName;
            MIDDLE_VALUE_TYPE retType = ofType(signature.getReturnType());
            Frame frame = frames.get(functionName);
            Result r = makeFunCall(retType, frame, args, code);
            return r;
        }

        @Override
        public Result visitInstructionIf(InstructionIf ctx) {
            Result cond = ctx.getCondition().accept(this);
            Result ifTrue = ctx.getIfTrue().accept(this);
            Result ifFalse = ctx.getIfFalse().accept(this);
            Label ifTrueLabel = Label.auto();
            Label ifFalseLabel = Label.auto();
            Label endOfIf = Label.auto();
            List<Command> code = new LinkedList<>();
            code.addAll(cond.getCode());
            code.add(new ConditionalJumpCommand(cond.getExpression(), ifTrueLabel, ifFalseLabel));
            code.add(ifTrueLabel);
            code.addAll(ifTrue.getCode());
            code.add(new JumpCommand(endOfIf));
            code.add(ifFalseLabel);
            code.addAll(ifFalse.getCode());
            code.add(endOfIf);
            return new Result(code);
        }

        @Override
        public Result visitInstructionWhile(InstructionWhile ctx) {
            Result cond = ctx.getCondition().accept(this);
            Label startOfWhile = Label.auto();
            Label startOfBody = Label.auto();
            Label endOfWhile = Label.auto();
            Result body = ctx.getIfTrue().accept(this);
            List<Command> code = new LinkedList<>();
            code.add(startOfWhile);
            code.add(new ConditionalJumpCommand(cond.getExpression(), startOfBody, endOfWhile));
            code.add(startOfBody);
            code.addAll(body.getCode());
            code.add(new JumpCommand(startOfWhile));
            code.add(endOfWhile);
            return new Result(code);
        }

        @Override
        public Result visitInstructionFunctionCall(InstructionFunctionCall ctx) {
            String functionName = ctx.getId();

            Pair<List<MiddleExpression>, List<Command>> translation = translateExpressions(ctx.getParameters());
            List<Command> code = translation.getSecond();
            List<MiddleExpression> args = translation.getFirst();
            if(ReservedFrames.isReservedFunctionName(functionName)){
                Frame fun = null;
                MIDDLE_VALUE_TYPE returnType = MIDDLE_VALUE_TYPE.VOID;
                switch (functionName){
                    case "print":
                        if(args.get(0).getType().equals(MIDDLE_VALUE_TYPE.INT)){
                            fun = ReservedFrames.PRINT_INT;
                            reservedNamespacesUsed.add("PRINT_INT");
                        }
                        else{
                            fun = ReservedFrames.PRINT_BYTE;
                            reservedNamespacesUsed.add("PRINT_BYTE");
                        }
                        break;
                    default:
                        translation_errors.add(new Error(ctx.getPosition(), "Found a reserved function name, but could not link it.", ctx));
                        return null;
                }
                fun.setReservedFrame(true);
                return makeFunCall(returnType, fun, args, code);
            }
            MethodSignature signature = symbolTable.methodLookup(functionName);
            assert !(signature==null) : "Internal Error: function name not in symbol table: " + functionName;
            MIDDLE_VALUE_TYPE retType = ofType(signature.getReturnType());
            Frame frame = frames.get(functionName);
            Result r = makeFunCall(retType, frame, args, code);
            return r;
        }

        @Override
        public Result visitInstructionVariableDeclaration(InstructionVariableDeclaration ctx) {
            Register reg = new Register(ofType(ctx.getType()));
            varToReg.put(new Pair<>(blockStack.peek(), ctx.getId()), reg);
            currentFrame.addLocalVariable(reg);
            List<Command> code = new LinkedList<>();
            if(ctx.getExpression() != null){
                Result result = ctx.getExpression().accept(this);
                code.add(new WriteRegisterCommand(reg, result.getExpression()));
                code.add(new WriteMemoryCommand(reg, getOrAllocateMemoryOffset(ctx.getId()), result.getExpression(), reg.getType()));
                return new Result(code);
            }
            return null;
        }

        @Override
        public Result visitInstructionBlock(InstructionBlock ctx) {
            blockStack.add(ctx);
            List<Command> code = new LinkedList<>();
            for(Instruction i : ctx.getInstructions()){
                code.addAll(i.accept(this).getCode());
            }
            blockStack.pop();
            return new Result(code);
        }

        @Override
        public Result visitFunctionDeclaration(FunctionDeclaration ctx) {
            String key = ctx.getId();
            if(ReservedFrames.isReservedFunctionName(key)){
                translation_errors.add(new Error(ctx.getPosition(), "Declaration of function with name "+key+". But this name is reserved by the compiler.", ctx));
                return null;
            }
            Frame frame = frames.get(key);
            currentFrame = frame;
            Result body = ctx.getBody().accept(this);
            fragments.add(new Pair<>(frame, body.getCode()));
            currentFrame = mainFrame;
            return null;
        }

        @Override
        public Result visitProgram(Program ctx) {
            ctx.accept(typeChecker);
            FramesBuilder framesBuilder = new FramesBuilder();
            ctx.accept(framesBuilder);
            blockStack.add(symbolTable.getrBlock());
            Label start = Label.named("main");
            Label end = Label.named("eof");
            mainFrame = new Frame(start, end, new LinkedList<>());
            currentFrame = mainFrame;
            List<Command> mainScriptCode = new LinkedList<>();
            for(Node n : ctx.getChildrens()){
                if(n instanceof FunctionDeclaration){
                    n.accept(this);
                }else{
                    Result r = n.accept(this);
                    if(r != null)
                        mainScriptCode.addAll(r.getCode());
                }
            }
            for(String reservedFunctionUsed: reservedNamespacesUsed){
                fragments.add(new Pair<>(ReservedFrames.getFrameFromCodedName(reservedFunctionUsed), ReservedFrames.getCodeFromCodedName(reservedFunctionUsed)));
            }
            fragments.add(new Pair<>(mainFrame, mainScriptCode));
            mainLabel = start;
            return null;
        }

        private class FramesBuilder extends SimpleScriptBaseVisitor<Void> {
            //on crée ici les frames nécessaires, pour toutes les
            //fonctions définies dans le programme.
            @Override
            public Void visitFunctionDeclaration(FunctionDeclaration function) {
                //ici, on remplit la map 'frames', sans rien retourner.
                //
                //On crée une liste de registre correspondant à la liste
                //des paramètres de la fonction
                List<Register> parameters = new LinkedList<>();
                for(FunctionParameter argument : function.getParameters()) {//parcours des paramètres
                    //créer un registre adapté et l’ajouter à la map
                    //'varToReg', ainsi qu’à la liste de registres
                    //initialisée plus haut, pour le frame.
                    //
                    //…
                    Register r = new Register(ofType(argument.getType()));
                    varToReg.put(new Pair<>((InstructionBlock) function.getBody(), argument.getId()), r);
                    parameters.add(r);
                }
                Frame frame;
                //on n’oublie pas, avant de créer le frame, de convertir le
                //type de l’AST en type de la rep. int.
                //…
                frame = new Frame(Label.auto(), Label.auto(), parameters, Optional.of(new Register(ofType(function.getType()))));

                frames.put(function.getId(), frame);
                return null;
            }

            @Override
            public Void visitProgram(Program ctx) {
                for(Node n : ctx.getChildrens())
                    if(n instanceof FunctionDeclaration)
                        n.accept(this);
                return null;
            }
        }
    }
}
