package net.tsbe.middle.lang;

import net.tsbe.generators.GeneratorFromIR;
import net.tsbe.middle.Register;
import net.tsbe.middle.models.*;

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
    public GeneratorResult accept(GeneratorFromIR visitor) {
        return visitor.visit(this);
    }

    @Override
    public <T> T accept(MiddleLangVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
