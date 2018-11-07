// Generated from /Users/mariocastillo/IdeaProjects/6.005 Software Construction/18.Parser_Generators/src/IntegerExpression.g4 by ANTLR 4.7

package gen;
// Do not edit this .java file! Edit the grammar in IntegerExpression.g4 and re-run Antlr.

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link IntegerExpressionParser}.
 */
public interface IntegerExpressionListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link IntegerExpressionParser#root}.
	 * @param ctx the parse tree
	 */
	void enterRoot(IntegerExpressionParser.RootContext ctx);
	/**
	 * Exit a parse tree produced by {@link IntegerExpressionParser#root}.
	 * @param ctx the parse tree
	 */
	void exitRoot(IntegerExpressionParser.RootContext ctx);
	/**
	 * Enter a parse tree produced by {@link IntegerExpressionParser#sum}.
	 * @param ctx the parse tree
	 */
	void enterSum(IntegerExpressionParser.SumContext ctx);
	/**
	 * Exit a parse tree produced by {@link IntegerExpressionParser#sum}.
	 * @param ctx the parse tree
	 */
	void exitSum(IntegerExpressionParser.SumContext ctx);
	/**
	 * Enter a parse tree produced by {@link IntegerExpressionParser#primitive}.
	 * @param ctx the parse tree
	 */
	void enterPrimitive(IntegerExpressionParser.PrimitiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link IntegerExpressionParser#primitive}.
	 * @param ctx the parse tree
	 */
	void exitPrimitive(IntegerExpressionParser.PrimitiveContext ctx);
}