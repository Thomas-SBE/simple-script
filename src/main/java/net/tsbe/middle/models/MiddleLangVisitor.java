package net.tsbe.middle.models;

import net.tsbe.middle.lang.*;

public interface MiddleLangVisitor<T> {

    T visit(Label command);
    T visit(ConditionalJumpCommand command);
    T visit(FunctionCallCommand command);
    T visit(SystemCallCommand command);
    T visit(JumpCommand command);
    T visit(WriteMemoryCommand command);
    T visit(WriteRegisterCommand command);

}
