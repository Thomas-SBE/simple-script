package net.tsbe.middle.expressions;

import net.tsbe.middle.MIDDLE_VALUE_TYPE;
import net.tsbe.middle.Register;
import net.tsbe.middle.models.MiddleExpression;
import net.tsbe.middle.models.MiddleVisitor;

public class ReadMemoryMiddleExpression extends MiddleExpression {

    final private Register register;
    final private MiddleExpression offset;
    final private MIDDLE_VALUE_TYPE type;

    public ReadMemoryMiddleExpression(Register register, MiddleExpression offset, MIDDLE_VALUE_TYPE type) {
        this.register = register;
        this.offset = offset;
        this.type = type;
    }

    public Register getRegister() {
        return register;
    }

    public MiddleExpression getOffset() {
        return offset;
    }

    @Override
    public <T> T accept(MiddleVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public MIDDLE_VALUE_TYPE getType() {
        return type;
    }

    @Override
    public String toString() {
        return register + "[" + offset + "]:" + type;
    }
}
