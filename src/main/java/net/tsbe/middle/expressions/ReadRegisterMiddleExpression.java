package net.tsbe.middle.expressions;

import net.tsbe.middle.MIDDLE_VALUE_TYPE;
import net.tsbe.middle.Register;
import net.tsbe.middle.models.MiddleExpression;
import net.tsbe.middle.models.MiddleVisitor;

public class ReadRegisterMiddleExpression extends MiddleExpression {

    final private Register register;

    public ReadRegisterMiddleExpression(Register register) {
        this.register = register;
    }

    @Override
    public <T> T accept(MiddleVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Register getRegister() {
        return register;
    }

    @Override
    public String toString() {
        return register.toString();
    }

    @Override
    public MIDDLE_VALUE_TYPE getType() {
        return register.getType();
    }
}
