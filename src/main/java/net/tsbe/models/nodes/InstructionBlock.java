package net.tsbe.models.nodes;

import net.tsbe.models.Instruction;
import net.tsbe.models.Node;
import net.tsbe.models.SimpleScriptASTVisitable;
import net.tsbe.models.SimpleScriptASTVisitor;

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
