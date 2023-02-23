package net.tsbe.models.nodes;

import net.tsbe.models.*;
import net.tsbe.models.enums.VALUE_TYPE;

import java.util.Optional;

public class InstructionVariableDeclaration extends Instruction{

    String id;
    VALUE_TYPE type;
    String typeValue;

    Expression expression;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public VALUE_TYPE getType() {
        return type;
    }

    public void setType(VALUE_TYPE type) {
        this.type = type;
    }

    public String getTypeValue() {
        return typeValue;
    }

    public void setTypeValue(String typeValue) {
        this.typeValue = typeValue;
    }

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

}
