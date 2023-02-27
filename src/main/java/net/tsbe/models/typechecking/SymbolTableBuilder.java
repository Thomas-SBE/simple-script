package net.tsbe.models.typechecking;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import net.tsbe.models.Error;
import net.tsbe.models.Instruction;
import net.tsbe.models.SimpleScriptBaseVisitor;
import net.tsbe.models.nodes.FunctionDeclaration;
import net.tsbe.models.nodes.FunctionParameter;
import net.tsbe.models.nodes.InstructionBlock;
import net.tsbe.models.nodes.InstructionVariableDeclaration;
import net.tsbe.models.nodes.Program;
import net.tsbe.utils.CompilatorDisplayer;

public class SymbolTableBuilder extends SimpleScriptBaseVisitor<Void>{
    
    private final SymbolTable table;
    private Stack<InstructionBlock> visitedBlocks;
    private InstructionBlock rootBlock;

    private List<Error> errors = new ArrayList<>();

    public SymbolTableBuilder(){
        table = new SymbolTable();
        visitedBlocks = new Stack<>();
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
            table.addLocalVariable(visitedBlocks.peek(), ctx.getId(), ctx.getType());
            return null;
        }

        errors.add(new Error(ctx.getPosition(), "Variable " + ctx.getId() + " already declared !", ctx));

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
            table.addLocalVariable(visitedBlocks.peek(), p.getId(), p.getType());
        }

        body.accept(this);

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
