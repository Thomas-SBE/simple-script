package net.tsbe.models.nodes;

import net.tsbe.models.Expression;
import net.tsbe.models.Instruction;

public class InstructionVariableArrayAssign extends Instruction {

    String id;
    Expression index;
    Expression value;

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

    public Expression getValue() {
        return value;
    }

    public void setValue(Expression value) {
        this.value = value;
    }
}
