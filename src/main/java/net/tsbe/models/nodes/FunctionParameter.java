package net.tsbe.models.nodes;

import net.tsbe.models.Node;
import net.tsbe.models.enums.VALUE_TYPE;

public class FunctionParameter extends Node{

    String id;

    ExpressionType type;

    public ExpressionType getType() {
        return type;
    }

    public void setType(ExpressionType type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
