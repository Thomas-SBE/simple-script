package net.tsbe.models;

import net.tsbe.models.nodes.*;

public interface SimpleScriptASTVisitor<T>{

    T visitExpressionBinary(ExpressionBinary ctx);
    T visitExpressionBoolean(ExpressionBoolean ctx);
    T visitExpressionCompare(ExpressionCompare ctx);
    T visitExpressionEmbedded(ExpressionEmbedded ctx);
    T visitExpressionFunctionCall(ExpressionFunctionCall ctx);
    T visitExpressionIdentifier(ExpressionIdentifier ctx);
    T visitExpressionInteger(ExpressionInteger ctx);
    T visitExpressionUnary(ExpressionUnary ctx);
    T visitFunctionDeclaration(FunctionDeclaration ctx);
    T visitFunctionParameter(FunctionParameter ctx);
    T visitInstructionBlock(InstructionBlock ctx);
    T visitInstructionIf(InstructionIf ctx);
    T visitInstructionReturn(InstructionReturn ctx);
    T visitInstructionVariableAssign(InstructionVariableAssign ctx);
    T visitInstructionVariableDeclaration(InstructionVariableDeclaration ctx);
    T visitInstructionWhile(InstructionWhile ctx);
    T visitProgram(Program ctx);

}
