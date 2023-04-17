package net.tsbe.middle;

import net.tsbe.middle.models.MiddleExpression;

public interface RegisterOffset {

    Register getRegister();
    int getOffset();
    MIDDLE_VALUE_TYPE getType();

}
