package net.tsbe.middle.models;

import net.tsbe.middle.expressions.*;

public interface MiddleVisitor<T> {

    T visit(BinaryMiddleExpression exp);
    T visit(ByteMiddleExpression exp);
    T visit(IntMiddleExpression exp);
    T visit(ReadMemoryMiddleExpression exp);
    T visit(ReadRegisterMiddleExpression exp);
    T visit(ReadMemoryWithOffsetMiddleExpression exp);
    T visit(UnaryMiddleExpression exp);
    T visit(Symbol exp);

}
