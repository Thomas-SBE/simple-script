package net.tsbe.models;

import net.tsbe.models.nodes.*;

public abstract class Instruction extends Node{

    @Override
    public Node accept(SimpleScriptASTVisitor<Node> visitor) {
        if(this instanceof InstructionBlock) return visitor.visitInstructionBlock((InstructionBlock) this);
        else if(this instanceof InstructionIf) return visitor.visitInstructionIf((InstructionIf) this);
        else if(this instanceof InstructionReturn) return visitor.visitInstructionReturn((InstructionReturn) this);
        else if(this instanceof InstructionVariableAssign) return visitor.visitInstructionVariableAssign((InstructionVariableAssign) this);
        else if(this instanceof InstructionVariableDeclaration) return visitor.visitInstructionVariableDeclaration((InstructionVariableDeclaration) this);
        else if(this instanceof InstructionWhile) return visitor.visitInstructionWhile((InstructionWhile) this);
        else{
            return null;
        }
    }
}
