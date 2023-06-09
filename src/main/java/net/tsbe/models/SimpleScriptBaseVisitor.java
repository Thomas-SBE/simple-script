package net.tsbe.models;

import net.tsbe.models.nodes.*;

public class SimpleScriptBaseVisitor<T> implements SimpleScriptASTVisitor<T>{

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
    public T visitExpressionIdentifierArray(ExpressionIdentifierArray ctx) {
        ctx.getIndex().accept(this);
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
        if(ctx.getExpression() != null) ctx.getExpression().accept(this);
        return null;
    }

    @Override
    public T visitInstructionVariableAssign(InstructionVariableAssign ctx) {
        ctx.getExpression().accept(this);
        return null;
    }

    @Override
    public T visitInstructionVariableArrayAssign(InstructionVariableArrayAssign ctx) {
        ctx.getIndex().accept(this);
        ctx.getValue().accept(this);
        return null;
    }

    @Override
    public T visitInstructionVariableDeclaration(InstructionVariableDeclaration ctx) {
        if(ctx.getExpression() != null) ctx.getExpression().accept(this);
        return null;
    }

    @Override
    public T visitInstructionVariableArrayDeclaration(InstructionVariableArrayDeclaration ctx) {
        ctx.getType().accept(this);
        for(Expression e : ctx.getValues()) ctx.accept(this);
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
        ctx.getVarValue().accept(this);
        ctx.getComparaison().accept(this);
        ctx.getNext().accept(this);
        ctx.getBody().accept(this);
        return null;
    }

    @Override
    public T visitProgram(Program ctx) {
        ctx.getChildrens().forEach(c -> c.accept(this));
        return null;
    }
    
}
