package net.tsbe.models.nodes;

import net.tsbe.models.Instruction;
import net.tsbe.models.Node;
import net.tsbe.models.enums.VALUE_TYPE;

import java.util.List;

public class FunctionDeclaration extends Node {

    String id;
    List<FunctionParameter> parameters;
    ExpressionType type;

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

    public ExpressionType getType() {
        return type;
    }

    public void setType(ExpressionType type) {
        this.type = type;
    }

}
