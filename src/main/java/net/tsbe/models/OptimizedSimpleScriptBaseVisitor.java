package net.tsbe.models;

import net.tsbe.models.nodes.*;
import net.tsbe.utils.CompilatorDisplayer;

public class OptimizedSimpleScriptBaseVisitor<T> implements SimpleScriptASTVisitor<T>{

    @Override
    public T visitExpressionBinary(ExpressionBinary ctx) {
        ctx.getLeft().accept(this);
        ctx.getRight().accept(this);
        return null;
    }

    @Override
    public T visitExpressionBoolean(ExpressionBoolean ctx) {
        return null;
    }

    @Override
    public T visitExpressionEmbedded(ExpressionEmbedded ctx) {
        ctx.getExpression().accept(this);
        return null;
    }

    @Override
    public T visitExpressionFunctionCall(ExpressionFunctionCall ctx) {
        ctx.getParameters().forEach(p -> p.accept(this));
        return null;
    }

    @Override
    public T visitExpressionIdentifier(ExpressionIdentifier ctx) {
        return null;
    }

    @Override
    public T visitExpressionIncrement(ExpressionIncrement ctx) {
        return null;
    }

    @Override
    public T visitExpressionInteger(ExpressionInteger ctx) {
        return null;
    }

    @Override
    public T visitExpressionUnary(ExpressionUnary ctx) {
        ctx.getExpression().accept(this);
        return null;
    }

    @Override
    public T visitExpressionType(ExpressionType ctx) {
        return null;
    }

    @Override
    public T visitFunctionDeclaration(FunctionDeclaration ctx) {
        ctx.getParameters().forEach(p -> p.accept(this));
        ctx.getBody().accept(this);
        return null;
    }

    @Override
    public T visitFunctionParameter(FunctionParameter ctx) {
        return null;
    }

    @Override
    public T visitInstructionBlock(InstructionBlock ctx) {
        ctx.getInstructions().forEach(i -> i.accept(this));
        return null;
    }

    @Override
    public T visitInstructionIf(InstructionIf ctx) {
        ctx.getCondition().accept(this);
        ctx.getIfTrue().accept(this);
        if(ctx.getIfFalse() != null) ctx.getIfFalse().accept(this);
        return null;
    }

    @Override
    public T visitInstructionReturn(InstructionReturn ctx) {
        ctx.getExpression().accept(this);
        return null;
    }

    @Override
    public T visitInstructionVariableAssign(InstructionVariableAssign ctx) {
        ctx.getExpression().accept(this);
        return null;
    }

    @Override
    public T visitInstructionVariableDeclaration(InstructionVariableDeclaration ctx) {
        if(ctx.getExpression() != null) ctx.getExpression().accept(this);
        return null;
    }

    @Override
    public T visitInstructionWhile(InstructionWhile ctx) {
        ctx.getCondition().accept(this);
        ctx.getIfTrue().accept(this);
        return null;
    }

    @Override
    public T visitInstructionFunctionCall(InstructionFunctionCall ctx) {
        ctx.getParameters().forEach(p -> p.accept(this));
        return null;
    }

    @Override
    public T visitInstructionFor(InstructionFor ctx) {
        CompilatorDisplayer.showGenericErrorMessage(CompilatorDisplayer.ERROR_CROSS_ICON + " UNREACHABLE STATEMENT", "Bad implementation of the AST structure, FOR loops should not exist at this stage.", true, true);
        System.exit(1);
        return null;
    }

    @Override
    public T visitProgram(Program ctx) {
        ctx.getChildrens().forEach(c -> c.accept(this));
        return null;
    }
    
}
