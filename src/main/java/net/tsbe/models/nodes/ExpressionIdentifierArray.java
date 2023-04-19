package net.tsbe.models.nodes;

import net.tsbe.models.Expression;

public class ExpressionIdentifierArray extends Expression {

    String id;
    Expression index;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Expression getIndex() {
        return index;
    }

    public void setIndex(Expression index) {
        this.index = index;
    }
}
