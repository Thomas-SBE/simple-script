package net.tsbe.models.nodes;

import net.tsbe.models.*;

public class InstructionWhile extends Instruction {

    Expression condition;
    Instruction ifTrue;

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

}
