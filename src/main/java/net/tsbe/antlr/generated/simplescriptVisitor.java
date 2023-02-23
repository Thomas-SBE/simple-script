package net.tsbe.antlr.generated;// Generated from java-escape by ANTLR 4.11.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link simplescriptParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface simplescriptVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link simplescriptParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(simplescriptParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link simplescriptParser#boolean}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolean(simplescriptParser.BooleanContext ctx);
	/**
	 * Visit a parse tree produced by {@link simplescriptParser#unary_operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnary_operator(simplescriptParser.Unary_operatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link simplescriptParser#binary_operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinary_operator(simplescriptParser.Binary_operatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link simplescriptParser#comparator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparator(simplescriptParser.ComparatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link simplescriptParser#function_parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_parameter(simplescriptParser.Function_parameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link simplescriptParser#function_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_declaration(simplescriptParser.Function_declarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expressionIdentifier}
	 * labeled alternative in {@link simplescriptParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionIdentifier(simplescriptParser.ExpressionIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expressionBoolean}
	 * labeled alternative in {@link simplescriptParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionBoolean(simplescriptParser.ExpressionBooleanContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expressionCompare}
	 * labeled alternative in {@link simplescriptParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionCompare(simplescriptParser.ExpressionCompareContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expressionUnary}
	 * labeled alternative in {@link simplescriptParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionUnary(simplescriptParser.ExpressionUnaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expressionFunctionCall}
	 * labeled alternative in {@link simplescriptParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionFunctionCall(simplescriptParser.ExpressionFunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expressionBinary}
	 * labeled alternative in {@link simplescriptParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionBinary(simplescriptParser.ExpressionBinaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expressionInt}
	 * labeled alternative in {@link simplescriptParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionInt(simplescriptParser.ExpressionIntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expressionEmbedded}
	 * labeled alternative in {@link simplescriptParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionEmbedded(simplescriptParser.ExpressionEmbeddedContext ctx);
	/**
	 * Visit a parse tree produced by the {@code instructionReturn}
	 * labeled alternative in {@link simplescriptParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstructionReturn(simplescriptParser.InstructionReturnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code instructionVariableDeclaration}
	 * labeled alternative in {@link simplescriptParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstructionVariableDeclaration(simplescriptParser.InstructionVariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code instructionVariableAssign}
	 * labeled alternative in {@link simplescriptParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstructionVariableAssign(simplescriptParser.InstructionVariableAssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code instructionIf}
	 * labeled alternative in {@link simplescriptParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstructionIf(simplescriptParser.InstructionIfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code instructionWhile}
	 * labeled alternative in {@link simplescriptParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstructionWhile(simplescriptParser.InstructionWhileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code instructionBlock}
	 * labeled alternative in {@link simplescriptParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstructionBlock(simplescriptParser.InstructionBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link simplescriptParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(simplescriptParser.ProgramContext ctx);
}