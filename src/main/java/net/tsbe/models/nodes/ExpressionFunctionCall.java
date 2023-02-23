package net.tsbe.models.nodes;

import net.tsbe.models.Expression;
import net.tsbe.models.Node;
import net.tsbe.models.SimpleScriptASTVisitable;
import net.tsbe.models.SimpleScriptASTVisitor;

import java.util.List;

public class ExpressionFunctionCall extends Expression {

    String id;
    List<Expression> parameters;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Expression> getParameters() {
        return parameters;
    }

    public void setParameters(List<Expression> parameters) {
        this.parameters = parameters;
    }

}
