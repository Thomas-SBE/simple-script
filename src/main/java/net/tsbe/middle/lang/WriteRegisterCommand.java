package net.tsbe.middle.lang;

import net.tsbe.middle.Register;
import net.tsbe.middle.models.Command;
import net.tsbe.middle.models.MiddleExpression;
import net.tsbe.middle.models.MiddleLangVisitor;

public class WriteRegisterCommand extends Command {

    final private Register register;
    final private MiddleExpression expression;

    public Register getRegister() {
        return register;
    }

    public WriteRegisterCommand(Register register, MiddleExpression expression) {
        this.register = register;
        this.expression = expression;
    }

    public MiddleExpression getExpression() {
        return expression;
    }

    @Override
    public String toString() {
        return register + " := " + expression;
    }

    @Override
    public <T> T accept(MiddleLangVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
