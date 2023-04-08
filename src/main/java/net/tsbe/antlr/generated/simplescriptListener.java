// Generated from C:/Users/thoma/Desktop/simple-script-language/language\simplescript.g4 by ANTLR 4.12.0
package net.tsbe.antlr.generated;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link simplescriptParser}.
 */
public interface simplescriptListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link simplescriptParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(simplescriptParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link simplescriptParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(simplescriptParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link simplescriptParser#boolean}.
	 * @param ctx the parse tree
	 */
	void enterBoolean(simplescriptParser.BooleanContext ctx);
	/**
	 * Exit a parse tree produced by {@link simplescriptParser#boolean}.
	 * @param ctx the parse tree
	 */
	void exitBoolean(simplescriptParser.BooleanContext ctx);
	/**
	 * Enter a parse tree produced by {@link simplescriptParser#unary_operator}.
	 * @param ctx the parse tree
	 */
	void enterUnary_operator(simplescriptParser.Unary_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link simplescriptParser#unary_operator}.
	 * @param ctx the parse tree
	 */
	void exitUnary_operator(simplescriptParser.Unary_operatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link simplescriptParser#binary_operator}.
	 * @param ctx the parse tree
	 */
	void enterBinary_operator(simplescriptParser.Binary_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link simplescriptParser#binary_operator}.
	 * @param ctx the parse tree
	 */
	void exitBinary_operator(simplescriptParser.Binary_operatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link simplescriptParser#increments_operator}.
	 * @param ctx the parse tree
	 */
	void enterIncrements_operator(simplescriptParser.Increments_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link simplescriptParser#increments_operator}.
	 * @param ctx the parse tree
	 */
	void exitIncrements_operator(simplescriptParser.Increments_operatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link simplescriptParser#function_parameter}.
	 * @param ctx the parse tree
	 */
	void enterFunction_parameter(simplescriptParser.Function_parameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link simplescriptParser#function_parameter}.
	 * @param ctx the parse tree
	 */
	void exitFunction_parameter(simplescriptParser.Function_parameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link simplescriptParser#function_declaration}.
	 * @param ctx the parse tree
	 */
	void enterFunction_declaration(simplescriptParser.Function_declarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link simplescriptParser#function_declaration}.
	 * @param ctx the parse tree
	 */
	void exitFunction_declaration(simplescriptParser.Function_declarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expressionIdentifier}
	 * labeled alternative in {@link simplescriptParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionIdentifier(simplescriptParser.ExpressionIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expressionIdentifier}
	 * labeled alternative in {@link simplescriptParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionIdentifier(simplescriptParser.ExpressionIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expressionBoolean}
	 * labeled alternative in {@link simplescriptParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionBoolean(simplescriptParser.ExpressionBooleanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expressionBoolean}
	 * labeled alternative in {@link simplescriptParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionBoolean(simplescriptParser.ExpressionBooleanContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expressionUnary}
	 * labeled alternative in {@link simplescriptParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionUnary(simplescriptParser.ExpressionUnaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expressionUnary}
	 * labeled alternative in {@link simplescriptParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionUnary(simplescriptParser.ExpressionUnaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expressionFunctionCall}
	 * labeled alternative in {@link simplescriptParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionFunctionCall(simplescriptParser.ExpressionFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expressionFunctionCall}
	 * labeled alternative in {@link simplescriptParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionFunctionCall(simplescriptParser.ExpressionFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expressionBinary}
	 * labeled alternative in {@link simplescriptParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionBinary(simplescriptParser.ExpressionBinaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expressionBinary}
	 * labeled alternative in {@link simplescriptParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionBinary(simplescriptParser.ExpressionBinaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expressionInt}
	 * labeled alternative in {@link simplescriptParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionInt(simplescriptParser.ExpressionIntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expressionInt}
	 * labeled alternative in {@link simplescriptParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionInt(simplescriptParser.ExpressionIntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expressionEmbedded}
	 * labeled alternative in {@link simplescriptParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionEmbedded(simplescriptParser.ExpressionEmbeddedContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expressionEmbedded}
	 * labeled alternative in {@link simplescriptParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionEmbedded(simplescriptParser.ExpressionEmbeddedContext ctx);
	/**
	 * Enter a parse tree produced by the {@code instructionReturn}
	 * labeled alternative in {@link simplescriptParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterInstructionReturn(simplescriptParser.InstructionReturnContext ctx);
	/**
	 * Exit a parse tree produced by the {@code instructionReturn}
	 * labeled alternative in {@link simplescriptParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitInstructionReturn(simplescriptParser.InstructionReturnContext ctx);
	/**
	 * Enter a parse tree produced by the {@code instructionVariableDeclaration}
	 * labeled alternative in {@link simplescriptParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterInstructionVariableDeclaration(simplescriptParser.InstructionVariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code instructionVariableDeclaration}
	 * labeled alternative in {@link simplescriptParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitInstructionVariableDeclaration(simplescriptParser.InstructionVariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code instructionVariableAssign}
	 * labeled alternative in {@link simplescriptParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterInstructionVariableAssign(simplescriptParser.InstructionVariableAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code instructionVariableAssign}
	 * labeled alternative in {@link simplescriptParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitInstructionVariableAssign(simplescriptParser.InstructionVariableAssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code instructionIf}
	 * labeled alternative in {@link simplescriptParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterInstructionIf(simplescriptParser.InstructionIfContext ctx);
	/**
	 * Exit a parse tree produced by the {@code instructionIf}
	 * labeled alternative in {@link simplescriptParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitInstructionIf(simplescriptParser.InstructionIfContext ctx);
	/**
	 * Enter a parse tree produced by the {@code instructionWhile}
	 * labeled alternative in {@link simplescriptParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterInstructionWhile(simplescriptParser.InstructionWhileContext ctx);
	/**
	 * Exit a parse tree produced by the {@code instructionWhile}
	 * labeled alternative in {@link simplescriptParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitInstructionWhile(simplescriptParser.InstructionWhileContext ctx);
	/**
	 * Enter a parse tree produced by the {@code instructionBlock}
	 * labeled alternative in {@link simplescriptParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterInstructionBlock(simplescriptParser.InstructionBlockContext ctx);
	/**
	 * Exit a parse tree produced by the {@code instructionBlock}
	 * labeled alternative in {@link simplescriptParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitInstructionBlock(simplescriptParser.InstructionBlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code instructionIncrementation}
	 * labeled alternative in {@link simplescriptParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterInstructionIncrementation(simplescriptParser.InstructionIncrementationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code instructionIncrementation}
	 * labeled alternative in {@link simplescriptParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitInstructionIncrementation(simplescriptParser.InstructionIncrementationContext ctx);
	/**
	 * Enter a parse tree produced by {@link simplescriptParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(simplescriptParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link simplescriptParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(simplescriptParser.ProgramContext ctx);
}