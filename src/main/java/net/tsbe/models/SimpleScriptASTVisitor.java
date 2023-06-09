package net.tsbe.models;

import net.tsbe.models.nodes.*;

public interface SimpleScriptASTVisitor<T>{

    T visitExpressionBinary(ExpressionBinary ctx);
    T visitExpressionBoolean(ExpressionBoolean ctx);
    T visitExpressionEmbedded(ExpressionEmbedded ctx);
    T visitExpressionFunctionCall(ExpressionFunctionCall ctx);
    T visitExpressionIdentifier(ExpressionIdentifier ctx);
    T visitExpressionIdentifierArray(ExpressionIdentifierArray ctx);
    T visitExpressionIncrement(ExpressionIncrement ctx);
    T visitExpressionInteger(ExpressionInteger ctx);
    T visitExpressionUnary(ExpressionUnary ctx);
    T visitExpressionType(ExpressionType ctx);
    T visitFunctionDeclaration(FunctionDeclaration ctx);
    T visitFunctionParameter(FunctionParameter ctx);
    T visitInstructionBlock(InstructionBlock ctx);
    T visitInstructionIf(InstructionIf ctx);
    T visitInstructionReturn(InstructionReturn ctx);
    T visitInstructionVariableAssign(InstructionVariableAssign ctx);
    T visitInstructionVariableArrayAssign(InstructionVariableArrayAssign ctx);
    T visitInstructionVariableDeclaration(InstructionVariableDeclaration ctx);
    T visitInstructionVariableArrayDeclaration(InstructionVariableArrayDeclaration ctx);
    T visitInstructionWhile(InstructionWhile ctx);
    T visitInstructionFunctionCall(InstructionFunctionCall ctx);
    T visitInstructionFor(InstructionFor ctx);
    T visitProgram(Program ctx);

}
