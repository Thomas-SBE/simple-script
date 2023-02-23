package net.tsbe.models.nodes;

import net.tsbe.models.*;

public class InstructionReturn extends Instruction {

    Expression expression;

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

}
