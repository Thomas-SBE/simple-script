package net.tsbe.models.nodes;

import net.tsbe.models.Expression;
import net.tsbe.models.Node;
import net.tsbe.models.SimpleScriptASTVisitable;
import net.tsbe.models.SimpleScriptASTVisitor;

public class ExpressionIdentifier extends Expression{

    String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
