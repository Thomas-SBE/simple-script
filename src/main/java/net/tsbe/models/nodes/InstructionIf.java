package net.tsbe.models.nodes;

import net.tsbe.models.*;

public class InstructionIf extends Instruction{

    Expression condition;
    Instruction ifTrue;
    Instruction ifFalse;

    public Expression getCondition() {
        return condition;
    }

    public void setCondition(Expression condition) {
        this.condition = condition;
    }

    public Instruction getIfTrue() {
        return ifTrue;
    }

    public void setIfTrue(Instruction ifTrue) {
        this.ifTrue = ifTrue;
    }

    public Instruction getIfFalse() {
        return ifFalse;
    }

    public void setIfFalse(Instruction ifFalse) {
        this.ifFalse = ifFalse;
    }

}
