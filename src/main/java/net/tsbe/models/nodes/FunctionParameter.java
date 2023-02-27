package net.tsbe.models.nodes;

import net.tsbe.models.Node;
import net.tsbe.models.enums.VALUE_TYPE;

public class FunctionParameter extends Node{

    String id;
    String typeValue;
    VALUE_TYPE type;

    public String getTypeValue() {
        return typeValue;
    }

    public void setTypeValue(String typeValue) {
        this.typeValue = typeValue;
    }

    public VALUE_TYPE getType() {
        return type;
    }

    public void setType(VALUE_TYPE type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
