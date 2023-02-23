package net.tsbe.models.nodes;

import net.tsbe.models.Expression;
import net.tsbe.models.enums.BINARY_OPERATOR;

public class ExpressionBinary extends Expression {

    BINARY_OPERATOR operation;
    String operator;
    Expression left;
    Expression right;

    public BINARY_OPERATOR getOperation() {
        return operation;
    }

    public void setOperation(BINARY_OPERATOR operation) {
        this.operation = operation;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Expression getLeft() {
        return left;
    }

    public void setLeft(Expression left) {
        this.left = left;
    }

    public Expression getRight() {
        return right;
    }

    public void setRight(Expression right) {
        this.right = right;
    }
}
