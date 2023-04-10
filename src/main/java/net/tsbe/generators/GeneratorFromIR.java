package net.tsbe.generators;

import net.tsbe.middle.expressions.*;
import net.tsbe.middle.lang.*;
import net.tsbe.middle.models.*;

import java.util.List;

public interface GeneratorFromIR {

    List<String> generate(Pair<Label, List<Pair<Frame, List<Command>>>> context);

    GeneratorResult visit(ConditionalJumpCommand ctx);
    GeneratorResult visit(FunctionCallCommand ctx);
    GeneratorResult visit(Label ctx);
    GeneratorResult visit(WriteMemoryCommand ctx);
    GeneratorResult visit(WriteRegisterCommand ctx);
    GeneratorResult visit(JumpCommand ctx);

    GeneratorResult visit(BinaryMiddleExpression ctx);
    GeneratorResult visit(ByteMiddleExpression ctx);
    GeneratorResult visit(IntMiddleExpression ctx);
    GeneratorResult visit(ReadRegisterMiddleExpression ctx);
    GeneratorResult visit(ReadMemoryMiddleExpression ctx);
    GeneratorResult visit(UnaryMiddleExpression ctx);

    GeneratorResult visit(Symbol ctx);

}
