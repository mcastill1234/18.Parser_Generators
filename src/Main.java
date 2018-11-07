/**
 * Based on sp16-ex18-parser-generators from Reading 18: Parser Generators - 6.005 Software Construction.
 * I extended the BaseListener instead of implementing the Listener directly to reduce the code and implement
 * only the required methods. I also used a lexer, parser, tree, walker generation as described in The Definitive
 * ANTLR Reference.
 */

import java.util.Stack;
import java.util.List;

import gen.IntegerExpressionBaseListener;
import gen.IntegerExpressionLexer;
import gen.IntegerExpressionParser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class Main {

    public static void main(String[] args) throws Exception {
        String input = "54+(2+89)";
        CharStream stream = new ANTLRInputStream(input);
        IntegerExpressionLexer lexer = new IntegerExpressionLexer(stream);
        TokenStream tokens = new CommonTokenStream(lexer);
        IntegerExpressionParser parser = new IntegerExpressionParser(tokens);
        ParseTree tree = parser.root();
        MakeIntegerExpression exprMaker = new MakeIntegerExpression();
        ParseTreeWalker Walker = new ParseTreeWalker();
        Walker.walk(exprMaker, tree);
        IntegerExpression expr = exprMaker.getExpression();
        int value = expr.value();
        System.out.println(input + "=" + expr + "=" + value);
    }

    /** Make a IntegerExpression value from a parse tree */
    public static class MakeIntegerExpression extends IntegerExpressionBaseListener {
        private Stack<IntegerExpression> stack = new Stack<>();
        // Invariant: stack contains the IntegerExpression value of each parse
        // subtree that has been fully-walked so far, but whose parents has not yet
        // been exited by the walk. The stack is ordered by recency of visit, so that
        // the top of the stack is the IntegerExpression for the most recently walked
        // subtree.
        //
        // At the start of the walk, the stack is empty, because no subtrees have
        // been fully walked.
        //
        // Whenever a node is exited be the walk, the IntegerExpression values of its
        // children are on top of the stack, in order with the last child on top. To
        // preserve the invariant, we must pop those child IntegerExpression values
        // from the stack, and push back an IntegerExpression value representing the entire
        // subtree under the node.
        //
        // At the end of the walk, after all subtrees have been walked and the
        // root has been exited, only the entire tree satisfies the invariant's
        // "fully walked but parent not yet exited" property, so the top of the stack
        // is the IntegerExpression of the entire parse tree.

        /**
         * Returns the expression constructed by this listener object.
         * Requires that this listener has completely walked over an IntegerExpression
         * parse tree using parseTreeWalker.
         * @return IntegerExpression for the parse tree that was walked
         */
        public IntegerExpression getExpression() {
            return stack.get(0);
        }

        @Override
        public void exitSum(IntegerExpressionParser.SumContext ctx) {
            // matched the primitive ('+' primitive)* rule
            List<IntegerExpressionParser.PrimitiveContext> addends = ctx.primitive();
            assert stack.size() >= addends.size();

            // the pattern above always has at least 1 child;
            // pop the last child
            assert addends.size() > 0;
            IntegerExpression sum = stack.pop();

            // pop the older children, one by one, and add them on
            for (int i = 1; i < addends.size(); ++i) {
                sum = new Plus(stack.pop(), sum);
            }

            // the result is this subtree's IntegerExpression
            stack.push(sum);
        }

        @Override
        public void exitPrimitive(IntegerExpressionParser.PrimitiveContext ctx) {
            if (ctx.NUMBER() != null) {
                // matched the NUMBER alternative
                int n = Integer.valueOf(ctx.NUMBER().getText());
                IntegerExpression number = new Number(n);
                stack.push(number);
            }
            else {
                // matched the '(' sum ')' alternative
                // do nothing, because sum's value is already on the stack
            }
        }
    }
}
