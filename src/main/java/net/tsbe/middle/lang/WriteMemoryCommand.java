package net.tsbe.middle.lang;

import net.tsbe.generators.GeneratorFromIR;
import net.tsbe.middle.MIDDLE_VALUE_TYPE;
import net.tsbe.middle.Register;
import net.tsbe.middle.RegisterOffset;
import net.tsbe.middle.models.Command;
import net.tsbe.middle.models.GeneratorResult;
import net.tsbe.middle.models.MiddleExpression;
import net.tsbe.middle.models.MiddleLangVisitor;

public class WriteMemoryCommand extends Command implements RegisterOffset {

    final private Register register;
    final private int offset;
    final private MiddleExpression expression;
    final private MIDDLE_VALUE_TYPE type;

    @Override
    public Register getRegister() {
        return register;
    }

    @Override
    public int getOffset() {
        return offset;
    }

    @Override
    public MIDDLE_VALUE_TYPE getType() {
        return type;
    }

    public WriteMemoryCommand(Register register, int offset, MiddleExpression expression, MIDDLE_VALUE_TYPE type) {
        this.register = register;
        this.offset = offset;
        this.expression = expression;
        this.type = type;
    }

    @Override
    public String toString() {
        return register + "[" + offset + "] : " + type + " := " + expression;
    }

    @Override
    public GeneratorResult accept(GeneratorFromIR visitor) {
        return visitor.visit(this);
    }

    @Override
    public <T> T accept(MiddleLangVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
