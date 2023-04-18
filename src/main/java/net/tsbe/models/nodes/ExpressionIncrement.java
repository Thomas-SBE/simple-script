package net.tsbe.models.nodes;

import net.tsbe.models.Expression;

public class ExpressionIncrement extends Expression {

    public enum TYPE {
        INCREMENTS {
            @Override
            public String toString() {
                return "++";
            }
        },
        DECREMENTS {
            @Override
            public String toString() {
                return "--";
            }
        }
    }

    String id;
    TYPE type_of_incrementation;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TYPE getType_of_incrementation() {
        return type_of_incrementation;
    }

    public void setType_of_incrementation(TYPE type_of_incrementation) {
        this.type_of_incrementation = type_of_incrementation;
    }
}
