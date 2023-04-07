package net.tsbe.middle;

import net.tsbe.middle.models.MiddleExpression;

public interface RegisterOffset {

    Register getRegister();
    MiddleExpression getOffset();
    MIDDLE_VALUE_TYPE getType();

}
