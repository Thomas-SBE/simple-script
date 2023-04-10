package net.tsbe.middle.expressions;

import net.tsbe.generators.GeneratorFromIR;
import net.tsbe.middle.MIDDLE_VALUE_TYPE;
import net.tsbe.middle.models.GeneratorResult;
import net.tsbe.middle.models.MiddleExpression;
import net.tsbe.middle.models.MiddleVisitor;

public class ByteMiddleExpression extends MiddleExpression {

    final private byte value;

    public ByteMiddleExpression(byte value) {
        this.value = value;
    }

    public byte getValue() {
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
        return MIDDLE_VALUE_TYPE.BYTE;
    }
}
