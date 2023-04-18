package net.tsbe.models.nodes;

import net.tsbe.middle.MIDDLE_VALUE_TYPE;
import net.tsbe.models.Expression;
import net.tsbe.models.Instruction;
import net.tsbe.models.enums.VALUE_TYPE;

public class InstructionFor extends Instruction {

    String varId;
    ExpressionType varType;
    Expression varValue;
    Expression comparaison;
    Instruction next;

    Instruction body;

    public String getVarId() {
        return varId;
    }

    public void setVarId(String varId) {
        this.varId = varId;
    }

    public ExpressionType getVarType() {
        return varType;
    }

    public void setVarType(ExpressionType varType) {
        this.varType = varType;
    }

    public Expression getVarValue() {
        return varValue;
    }

    public void setVarValue(Expression varValue) {
        this.varValue = varValue;
    }

    public Expression getComparaison() {
        return comparaison;
    }

    public void setComparaison(Expression comparaison) {
        this.comparaison = comparaison;
    }

    public Instruction getNext() {
        return next;
    }

    public void setNext(Instruction next) {
        this.next = next;
    }

    public Instruction getBody() {
        return body;
    }

    public void setBody(Instruction body) {
        this.body = body;
    }
}
