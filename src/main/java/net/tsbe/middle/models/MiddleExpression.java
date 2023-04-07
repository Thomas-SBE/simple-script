package net.tsbe.middle.models;

import net.tsbe.middle.MIDDLE_VALUE_TYPE;

abstract public class MiddleExpression {

    public abstract <T> T accept(MiddleVisitor<T> visitor);
    public abstract MIDDLE_VALUE_TYPE getType();

}
