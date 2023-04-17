package net.tsbe.middle.expressions;

import net.tsbe.generators.GeneratorFromIR;
import net.tsbe.middle.MIDDLE_VALUE_TYPE;
import net.tsbe.middle.Register;
import net.tsbe.middle.models.GeneratorResult;
import net.tsbe.middle.models.MiddleExpression;
import net.tsbe.middle.models.MiddleVisitor;

public class ReadMemoryMiddleExpression extends MiddleExpression {

    final private Register register;
    final private int offset;
    final private MIDDLE_VALUE_TYPE type;

    public ReadMemoryMiddleExpression(Register register, int offset, MIDDLE_VALUE_TYPE type) {
        this.register = register;
        this.offset = offset;
        this.type = type;
    }

    public Register getRegister() {
        return register;
    }

    public int getOffset() {
        return offset;
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
        return type;
    }

    @Override
    public String toString() {
        return register + "[" + offset + "]:" + type;
    }
}
