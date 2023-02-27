package net.tsbe.models.nodes;

import net.tsbe.models.Expression;
import net.tsbe.models.enums.UNARY_OPERATOR;

public class ExpressionUnary extends Expression{

    UNARY_OPERATOR operation;
    String operator;
    Expression expression;

    public UNARY_OPERATOR getOperation() {
        return operation;
    }

    public void setOperation(UNARY_OPERATOR operation) {
        this.operation = operation;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

}
