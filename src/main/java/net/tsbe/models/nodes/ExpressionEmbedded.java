package net.tsbe.models.nodes;

import net.tsbe.models.Expression;

public class ExpressionEmbedded extends Expression{

    Expression expression;

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

}
