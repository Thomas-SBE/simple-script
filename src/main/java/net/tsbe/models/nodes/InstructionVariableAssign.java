package net.tsbe.models.nodes;

import net.tsbe.models.*;

public class InstructionVariableAssign extends Instruction{

    String id;
    Expression expression;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

}
