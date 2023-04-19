package net.tsbe.models.nodes;

import net.tsbe.models.Expression;
import net.tsbe.models.Instruction;

import java.util.List;

public class InstructionVariableArrayDeclaration extends Instruction {

    String id;
    ExpressionType type;
    int size;
    List<Expression> values;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ExpressionType getType() {
        return type;
    }

    public void setType(ExpressionType type) {
        this.type = type;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<Expression> getValues() {
        return values;
    }

    public void setValues(List<Expression> values) {
        this.values = values;
    }
}
