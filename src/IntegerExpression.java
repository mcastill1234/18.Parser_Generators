/** Immutable type representing an integer arithmetic expression. */
public interface IntegerExpression {
    // Data type definition (abbreviated IntExpr)
    //    IntExpr = Number(n:int) + Plus(left:IntExpr, right:IntExpr)

    /** @return the computed value of this expression */
    public int value();
}

