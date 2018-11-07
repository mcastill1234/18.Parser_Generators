// Generated from /Users/mariocastillo/IdeaProjects/6.005 Software Construction/18.Parser_Generators/src/IntegerExpression.g4 by ANTLR 4.7

package gen;
// Do not edit this .java file! Edit the grammar in IntegerExpression.g4 and re-run Antlr.

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link IntegerExpressionParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface IntegerExpressionVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link IntegerExpressionParser#root}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRoot(IntegerExpressionParser.RootContext ctx);
	/**
	 * Visit a parse tree produced by {@link IntegerExpressionParser#sum}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSum(IntegerExpressionParser.SumContext ctx);
	/**
	 * Visit a parse tree produced by {@link IntegerExpressionParser#primitive}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitive(IntegerExpressionParser.PrimitiveContext ctx);
}