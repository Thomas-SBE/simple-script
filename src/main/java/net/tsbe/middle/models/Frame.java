package net.tsbe.middle.models;

import net.tsbe.middle.Register;
import net.tsbe.middle.lang.Label;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class Frame {

    final private Label entry;
    final private Label exit;
    final private List<Register> parametersRegisters;
    final private List<Boolean> parametersPassedByReference;
    final private Optional<Register> resultRegister;
    final private List<Register> localVariablesRegisters;
    private int size;

    private boolean isReservedFrame = false;

    public Label getEntry() {
        return entry;
    }

    public Label getExit() {
        return exit;
    }

    public List<Register> getParametersRegisters() {
        return parametersRegisters;
    }

    public List<Boolean> getParametersPassedByReference() {
        return parametersPassedByReference;
    }

    public Optional<Register> getResultRegister() {
        return resultRegister;
    }

    public List<Register> getLocalVariablesRegisters() {
        return localVariablesRegisters;
    }

    public int getSize() {
        return size;
    }

    public void addLocalVariable(Register register){
        this.localVariablesRegisters.add(register);
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Frame(Label entry, Label exit, List<Register> parametersRegisters, List<Boolean> parametersPassedByReference, Optional<Register> resultRegister, int size) {
        this.entry = entry;
        this.exit = exit;
        this.parametersRegisters = parametersRegisters;
        this.parametersPassedByReference = parametersPassedByReference;
        this.resultRegister = resultRegister;
        this.size = size;
        this.localVariablesRegisters = new LinkedList<>();
    }

    public Frame reserved(){
        this.isReservedFrame = true;
        return this;
    }

    @Override
    public String toString() {
        return "Frame{" +
                "\n entryPoint=" + entry +
                ",\n exitPoint=" + exit +
                ",\n parameters=" + parametersRegisters +
                ",\n passedByRef=" + parametersPassedByReference +
                ",\n result=" + resultRegister +
                ",\n locals=" + localVariablesRegisters +
                ",\n size=" + size +
                "\n}";
    }

    public Frame(Label entry, Label exit, List<Register> parametersRegisters, List<Boolean> parametersPassedByReference, Optional<Register> resultRegister) {
        this(entry, exit, parametersRegisters, parametersPassedByReference, resultRegister, 0);
    }

    public Frame(Label entry, Label exit, List<Register> parametersRegisters, Optional<Register> resultRegister) {
        this(entry, exit, parametersRegisters, new ArrayList<>(), resultRegister, 0);
    }

    public Frame(Label entry, Label exit, List<Register> parametersRegisters, List<Boolean> parametersPassedByReference) {
        this(entry, exit, parametersRegisters, parametersPassedByReference, Optional.empty(), 0);
    }

    public Frame(Label entry, Label exit, List<Register> parametersRegisters) {
        this(entry, exit, parametersRegisters, new ArrayList<>(), Optional.empty(), 0);
    }

    public boolean isReservedFrame() {
        return isReservedFrame;
    }

    public void setReservedFrame(boolean reservedFrame) {
        isReservedFrame = reservedFrame;
    }
}
