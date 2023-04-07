package net.tsbe.middle.expressions;

import net.tsbe.middle.MIDDLE_VALUE_TYPE;
import net.tsbe.middle.models.MiddleExpression;
import net.tsbe.middle.models.MiddleVisitor;
import net.tsbe.models.enums.BINARY_OPERATOR;

public class BinaryMiddleExpression extends MiddleExpression {

    final private MiddleExpression left;
    final private MiddleExpression right;
    final private BINARY_OPERATOR op;

    public BinaryMiddleExpression(MiddleExpression left, MiddleExpression right, BINARY_OPERATOR op) {
        this.left = left;
        this.right = right;
        this.op = op;
    }

    @Override
    public <T> T accept(MiddleVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public MIDDLE_VALUE_TYPE getType() {
        return switch (op) {
            case ADD, SUBSTRACT, MULTIPLY, DIVIDE -> MIDDLE_VALUE_TYPE.INT;
            default -> MIDDLE_VALUE_TYPE.BYTE;
        };
    }

    @Override
    public String toString() {
        return "(" + left + " " + op + " " + right + ")";
    }
}
