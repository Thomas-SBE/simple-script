package net.tsbe.models.nodes;

import net.tsbe.models.Expression;

public class ExpressionInteger extends Expression {

    int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
