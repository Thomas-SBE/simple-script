package net.tsbe.models.nodes;

import net.tsbe.models.Expression;
import net.tsbe.models.Node;
import net.tsbe.models.SimpleScriptASTVisitable;
import net.tsbe.models.SimpleScriptASTVisitor;

public class ExpressionEmbedded extends Expression{

    Expression expression;

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

}
