package net.tsbe.models.nodes;

import net.tsbe.models.Expression;
import net.tsbe.models.enums.VALUE_TYPE;

public class ExpressionType extends Expression {

    private VALUE_TYPE type;
    private String rawType;

    public ExpressionType(VALUE_TYPE type, String rawType) {
        this.type = type;
        this.rawType = rawType;
    }

    public void setEnumType(VALUE_TYPE type) {
        this.type = type;
    }

    public void setRawType(String rawType) {
        this.rawType = rawType;
    }

    public VALUE_TYPE getEnumType() {
        return type;
    }

    public String getRawType() {
        return rawType;
    }
}
