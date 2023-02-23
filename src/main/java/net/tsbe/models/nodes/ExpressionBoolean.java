package net.tsbe.models.nodes;

import net.tsbe.models.Expression;

public class ExpressionBoolean extends Expression {

    boolean value;

    public boolean isValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

}
