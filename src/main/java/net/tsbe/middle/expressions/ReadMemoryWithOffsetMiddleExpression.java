package net.tsbe.middle.expressions;

import net.tsbe.generators.GeneratorFromIR;
import net.tsbe.middle.MIDDLE_VALUE_TYPE;
import net.tsbe.middle.Register;
import net.tsbe.middle.models.GeneratorResult;
import net.tsbe.middle.models.MiddleExpression;
import net.tsbe.middle.models.MiddleVisitor;

public class ReadMemoryWithOffsetMiddleExpression extends MiddleExpression {

    final private Register register;
    final private int variableOffset;
    final private MIDDLE_VALUE_TYPE type;
    final MiddleExpression offset;

    public ReadMemoryWithOffsetMiddleExpression(Register register, int variableOffset, MIDDLE_VALUE_TYPE type, MiddleExpression offset) {
        this.register = register;
        this.variableOffset = variableOffset;
        this.type = type;
        this.offset = offset;
    }

    public Register getRegister() {
        return register;
    }

    public int getVariableOffset() {
        return variableOffset;
    }

    public MiddleExpression getOffset() {
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
}
