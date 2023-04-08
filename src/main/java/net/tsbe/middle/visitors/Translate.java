package net.tsbe.middle.visitors;

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
    public static final List<Error> errors = new LinkedList<>();
    private static final TypeConverter typeConverter = new TypeConverter();

    //retourne la représentation intermédiaire du programme.
    public static Pair<Label, List<Pair<Frame, List<Command>>>> run(SymbolTable symbolTable, Program program) {
        TranslationVisitor translator = new TranslationVisitor(symbolTable);
        program.accept(translator);
        return new Pair<>(translator.mainLabel, translator.fragments);
    }

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

    private static class TranslationVisitor implements SimpleScriptASTVisitor<Result> {

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

        private Stack<InstructionBlock> blockStack = new Stack<>();

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

        @Override
        public Result visitFunctionParameter(FunctionParameter ctx) {
            assert false : "Translate: internal error. This node should not be visited, please report";
            return null;
        }

        /*@Override
        public Result visit(StatPrint s){
            //impressions d’entiers uniquement
            Expression e=s.getExpression();
            List<Expression> argList = new ArrayList<>(); argList.add(e);
            Frame frame = PredefinedFrames.PRINT_INT;

            Pair<List<ir.expr.Expression>,List<Command>> translation =
                    translateExpressions(argList);

            List<Command> code = translation.getSnd();
            List<ir.expr.Expression> args = translation.getFst();
            //si on n’a pas de type void,
            //on laisse un int en retour par défaut
            Type type = new TypePrim(null,TypePrim.Prim.INT);
            Result result = makeFunCall(type,frame,args,code);


            return result;
        }*/

        @Override
        public Result visitExpressionInteger(ExpressionInteger ctx) {
            return new Result(new IntMiddleExpression(ctx.getValue()));
        }

        @Override
        public Result visitExpressionBoolean(ExpressionBoolean ctx) {
            return new Result(new ByteMiddleExpression((byte) (ctx.isValue() ? 1 : 0)));
        }

        @Override
        public Result visitExpressionCompare(ExpressionCompare ctx) {
            MiddleExpression l = ctx.getLeft().accept(this).getExpression();
            MiddleExpression r = ctx.getRight().accept(this).getExpression();
            BinaryMiddleExpression bin = new BinaryMiddleExpression(l, r, ctx.getComparator());
            return new Result(bin);
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
            for(InstructionBlock b : blockStack){
                if(varToReg.containsKey(new Pair<>(b, name))){
                    return varToReg.get(new Pair<>(b, name));
                }
            }
            return null;
        }

        @Override
        public Result visitExpressionIdentifier(ExpressionIdentifier ctx) {
            Register reg = registerLookup(ctx.getId());
            return new Result(new ReadRegisterMiddleExpression(reg));
        }

        @Override
        public Result visitExpressionBinary(ExpressionBinary ctx) {
            MiddleExpression l = ctx.getLeft().accept(this).getExpression();
            MiddleExpression r = ctx.getRight().accept(this).getExpression();
            BinaryMiddleExpression bin = new BinaryMiddleExpression(l, r, ctx.getOperation());
            return new Result(bin);
        }

        @Override
        public Result visitExpressionUnary(ExpressionUnary ctx) {
            MiddleExpression u = ctx.getExpression().accept(this).getExpression();
            UnaryMiddleExpression un = new UnaryMiddleExpression(u, ctx.getOperation());
            return new Result(un);
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
            return new Result(code);
        }

        @Override
        public Result visitInstructionReturn(InstructionReturn ctx) {
            Result result = ctx.getExpression().accept(this);
            Register returnReg = currentFrame.getResultRegister().get();
            Command writeToReturnReg = new WriteRegisterCommand(returnReg, result.getExpression());
            Command gotoExit = new JumpCommand(currentFrame.getExit());
            List<Command> code = new LinkedList<>(result.getCode());
            code.add(writeToReturnReg);
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
            return new Result(new ReadRegisterMiddleExpression(reg), code);
        }

        @Override
        public Result visitExpressionFunctionCall(ExpressionFunctionCall ctx) {
            String functionName = ctx.getId();
            Pair<List<MiddleExpression>, List<Command>> translation = translateExpressions(ctx.getParameters());
            List<Command> code = translation.getSecond();
            List<MiddleExpression> args = translation.getFirst();
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
        public Result visitInstructionVariableDeclaration(InstructionVariableDeclaration ctx) {
            Register reg = new Register(ofType(ctx.getType()));
            varToReg.put(new Pair<>(blockStack.peek(), ctx.getId()), reg);
            currentFrame.addLocalVariable(reg);
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
            Label start = Label.named("START_OF_SCRIPT_LABEL");
            Label end = Label.named("END_OF_SCRIPT_LABEL");
            mainFrame = new Frame(start, end, new LinkedList<>());
            currentFrame = mainFrame;
            List<Command> mainScriptCode = new LinkedList<>();
            for(Node n : ctx.getChildrens()){
                if(n instanceof FunctionDeclaration){
                    n.accept(this);
                }else{
                    Result r = n.accept(this);
                    mainScriptCode.addAll(r.getCode());
                }
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
                if (function.getId().equals("main"))
                    mainLabel = frame.getEntry();
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
