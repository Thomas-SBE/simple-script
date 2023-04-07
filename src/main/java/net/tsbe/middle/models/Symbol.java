package net.tsbe.middle.models;

import net.tsbe.middle.MIDDLE_VALUE_TYPE;

public class Symbol extends MiddleExpression {

    final private String symbol;
    final private MIDDLE_VALUE_TYPE type;

    public Symbol(String symbol) {
        this.symbol = symbol;
        type = MIDDLE_VALUE_TYPE.INT;
    }

    public Symbol(String symbol, MIDDLE_VALUE_TYPE type) {
        this.symbol = symbol;
        this.type = type;
    }

    @Override
    public <T> T accept(MiddleVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public MIDDLE_VALUE_TYPE getType() {
        return type;
    }

    @Override
    public String toString() {
        return symbol;
    }

    public static final Symbol INT_SIZE = new Symbol("INT_SIZE");
    public static final Symbol BYTE_SIZE = new Symbol("BYTE_SIZE");
    public static final Symbol ADDRESS_SIZE = new Symbol("ADDRESS_SIZE");
}
