package net.tsbe.middle.lang;

import net.tsbe.middle.Register;
import net.tsbe.middle.models.Command;
import net.tsbe.middle.models.Frame;
import net.tsbe.middle.models.MiddleExpression;
import net.tsbe.middle.models.MiddleLangVisitor;

import java.util.List;

public class FunctionCallCommand extends Command {

    final private Register register;
    final private Frame frame;
    final private List<MiddleExpression> functionArguments;

    public Register getRegister() {
        return register;
    }

    public Frame getFrame() {
        return frame;
    }

    public List<MiddleExpression> getFunctionArguments() {
        return functionArguments;
    }

    public FunctionCallCommand(Register register, Frame frame, List<MiddleExpression> functionArguments) {
        this.register = register;
        this.frame = frame;
        this.functionArguments = functionArguments;
    }

    @Override
    public String toString() {
        return register + " := call " + frame.getEntry().toString() + functionArguments;
    }

    @Override
    public <T> T accept(MiddleLangVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
