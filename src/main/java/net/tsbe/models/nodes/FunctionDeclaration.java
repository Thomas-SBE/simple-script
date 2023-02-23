package net.tsbe.models.nodes;

import net.tsbe.models.Instruction;
import net.tsbe.models.Node;
import net.tsbe.models.SimpleScriptASTVisitable;
import net.tsbe.models.SimpleScriptASTVisitor;
import net.tsbe.models.enums.VALUE_TYPE;

import java.util.List;

public class FunctionDeclaration extends Node {

    String id;
    List<FunctionParameter> parameters;
    String typeValue;
    VALUE_TYPE type;

    public Instruction getBody() {
        return body;
    }

    public void setBody(Instruction body) {
        this.body = body;
    }

    Instruction body;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<FunctionParameter> getParameters() {
        return parameters;
    }

    public void setParameters(List<FunctionParameter> parameters) {
        this.parameters = parameters;
    }

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

}
