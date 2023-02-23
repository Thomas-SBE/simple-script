package net.tsbe.models.nodes;

import net.tsbe.models.Instruction;

import java.util.List;

public class InstructionBlock extends Instruction{

    List<Instruction> instructions;

    public List<Instruction> getInstructions() {
        return instructions;
    }

    public void setInstructions(List<Instruction> instructions) {
        this.instructions = instructions;
    }

}
