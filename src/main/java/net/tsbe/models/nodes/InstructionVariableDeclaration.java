package net.tsbe.models.nodes;

import net.tsbe.models.*;
import net.tsbe.models.enums.VALUE_TYPE;


public class InstructionVariableDeclaration extends Instruction{

    String id;
    ExpressionType type;

    Expression expression;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ExpressionType getType() {
        return type;
    }

    public void setType(ExpressionType type) {
        this.type = type;
    }

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

}
