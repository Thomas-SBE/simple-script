package net.tsbe.models.typechecking;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import net.tsbe.models.Error;
import net.tsbe.models.Instruction;
import net.tsbe.models.OptimizedSimpleScriptBaseVisitor;
import net.tsbe.models.SimpleScriptBaseVisitor;
import net.tsbe.models.nodes.*;
import net.tsbe.utils.CompilatorDisplayer;

public class SymbolTableBuilder extends OptimizedSimpleScriptBaseVisitor<Void> {
    
    private final SymbolTable table;
    private Stack<InstructionBlock> visitedBlocks;
    private InstructionBlock rootBlock;

    private List<Error> errors = new ArrayList<>();

    public SymbolTableBuilder(){
        table = new SymbolTable();
        visitedBlocks = new Stack<>();
    }

    public void check(){
        if(errors.size() > 0){
            for(Error e : errors){
                CompilatorDisplayer.showGenericErrorMessage(CompilatorDisplayer.ERROR_CROSS_ICON + " SYMBOL TABLE", String.format("[LINE: %d, OFFSET: %d] - %s", e.position.getLineNumber(), e.position.getLineOffset(), e.message), false, true);
            }
            CompilatorDisplayer.showGenericErrorMessage(CompilatorDisplayer.ERROR_CROSS_ICON + " SYMBOL TABLE", "Could not continue compiler process with " + CompilatorDisplayer.COLOR_ERROR + errors.size() + " symbol errors" + CompilatorDisplayer.COLOR_RESET + " !", true, true);
            System.exit(1);
        }
    }

    public SymbolTable getSymbolTable(){
        for(Error e : errors){
            CompilatorDisplayer.showGenericErrorMessage(CompilatorDisplayer.ERROR_CROSS_ICON, "[Line: "+e.position.getLineNumber()+", OFFSET: "+e.position.getLineOffset()+"] "+e.message, false, false);
        }
        return table;
    }

    @Override
    public Void visitInstructionBlock(InstructionBlock ctx) {
        table.localTable(ctx);
        visitedBlocks.add(ctx);
        super.visitInstructionBlock(ctx);
        visitedBlocks.pop();
        return null;
    }

    @Override
    public Void visitInstructionVariableDeclaration(InstructionVariableDeclaration ctx) {
        if(table.variableLookup(ctx.getId(), visitedBlocks) == null){
            table.addLocalVariable(visitedBlocks.peek(), ctx.getId(), ctx.getType().getEnumType());
            return null;
        }

        errors.add(new Error(ctx.getPosition(), "Variable [" + ctx.getId() + "] already declared !", ctx));

        return null;
    }

    @Override
    public Void visitFunctionDeclaration(FunctionDeclaration ctx) {
        Instruction body;
        if(!(ctx.getBody() instanceof InstructionBlock)){
            body = new InstructionBlock();
            List<Instruction> lsinstr = new ArrayList<>();
            lsinstr.add(ctx.getBody());
            ((InstructionBlock)body).setInstructions(lsinstr);
            ctx.setBody(body);
        }else{
            body = ctx.getBody();
        }

        table.addMethod(ctx.getId(), MethodSignature.signatureOf(ctx));

        visitedBlocks.add((InstructionBlock)body);

        table.localTable((InstructionBlock) body);

        for(FunctionParameter p : ctx.getParameters()){
            table.addLocalVariable(visitedBlocks.peek(), p.getId(), p.getType().getEnumType());
        }

        body.accept(this);

        return null;
    }

    @Override
    public Void visitInstructionVariableArrayDeclaration(InstructionVariableArrayDeclaration ctx) {
        if(table.variableLookup(ctx.getId(), visitedBlocks) == null){
            table.addLocalVariable(visitedBlocks.peek(), ctx.getId(), ctx.getType().getEnumType());
            return null;
        }

        errors.add(new Error(ctx.getPosition(), "Variable [" + ctx.getId() + "] already declared !", ctx));

        return null;
    }

    @Override
    public Void visitProgram(Program ctx) {
        rootBlock = new InstructionBlock();
        table.localTable(rootBlock);
        table.setrBlock(rootBlock);
        visitedBlocks.add(rootBlock);
        super.visitProgram(ctx);
        return null;
    }

}
