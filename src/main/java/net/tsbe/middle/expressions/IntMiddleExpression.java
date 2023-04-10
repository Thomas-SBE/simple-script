package net.tsbe.middle.expressions;

import net.tsbe.generators.GeneratorFromIR;
import net.tsbe.middle.MIDDLE_VALUE_TYPE;
import net.tsbe.middle.models.GeneratorResult;
import net.tsbe.middle.models.MiddleExpression;
import net.tsbe.middle.models.MiddleVisitor;

public class IntMiddleExpression extends MiddleExpression {

    final private int value;

    public IntMiddleExpression(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "" + value;
    }

    @Override
    public GeneratorResult accept(GeneratorFromIR visitor) {
        return visitor.visit(this);
    }

    @Override
    public <T> T accept(MiddleVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public MIDDLE_VALUE_TYPE getType() {
        return MIDDLE_VALUE_TYPE.INT;
    }
}
