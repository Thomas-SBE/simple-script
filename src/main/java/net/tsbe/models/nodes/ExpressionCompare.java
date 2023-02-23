package net.tsbe.models.nodes;

import net.tsbe.models.Expression;
import net.tsbe.models.enums.COMPARATOR;

public class ExpressionCompare extends Expression {

    COMPARATOR comparator;
    String comparatorValue;
    Expression left;
    Expression right;

    public COMPARATOR getComparator() {
        return comparator;
    }

    public void setComparator(COMPARATOR comparator) {
        this.comparator = comparator;
    }

    public String getComparatorValue() {
        return comparatorValue;
    }

    public void setComparatorValue(String comparatorValue) {
        this.comparatorValue = comparatorValue;
    }

    public Expression getLeft() {
        return left;
    }

    public void setLeft(Expression left) {
        this.left = left;
    }

    public Expression getRight() {
        return right;
    }

    public void setRight(Expression right) {
        this.right = right;
    }

}
