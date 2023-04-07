package net.tsbe.middle.expressions;

import net.tsbe.middle.MIDDLE_VALUE_TYPE;
import net.tsbe.middle.models.MiddleExpression;
import net.tsbe.middle.models.MiddleVisitor;
import net.tsbe.models.enums.UNARY_OPERATOR;

public class UnaryMiddleExpression extends MiddleExpression {

    final private MiddleExpression exp;
    final private UNARY_OPERATOR op;

    public MiddleExpression getExp() {
        return exp;
    }

    public UNARY_OPERATOR getOp() {
        return op;
    }

    public UnaryMiddleExpression(MiddleExpression exp, UNARY_OPERATOR op) {
        this.exp = exp;
        this.op = op;
    }

    @Override
    public <T> T accept(MiddleVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public MIDDLE_VALUE_TYPE getType() {
        return switch (op){
            case NOT -> MIDDLE_VALUE_TYPE.BYTE;
            case PLUS, MINUS -> MIDDLE_VALUE_TYPE.INT;
            default -> MIDDLE_VALUE_TYPE.BYTE;
        };
    }

    @Override
    public String toString() {
        return op + "(" + exp + ")";
    }
}
