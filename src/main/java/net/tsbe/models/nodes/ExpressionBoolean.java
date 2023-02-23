package net.tsbe.models.nodes;

import net.tsbe.models.Expression;
import net.tsbe.models.Node;
import net.tsbe.models.SimpleScriptASTVisitable;
import net.tsbe.models.SimpleScriptASTVisitor;

public class ExpressionBoolean extends Expression {

    boolean value;

    public boolean isValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

}
