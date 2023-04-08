package net.tsbe.middle.visitors;

import net.tsbe.middle.MIDDLE_VALUE_TYPE;
import net.tsbe.models.SimpleScriptBaseVisitor;
import net.tsbe.models.nodes.ExpressionType;
import net.tsbe.utils.CompilatorDisplayer;

public class TypeToMiddleTypeConverter extends SimpleScriptBaseVisitor<MIDDLE_VALUE_TYPE> {

    @Override
    public MIDDLE_VALUE_TYPE visitExpressionType(ExpressionType ctx) {
        switch (ctx.getEnumType()){
            case INTEGER: return MIDDLE_VALUE_TYPE.INT;
            case BOOLEAN: return MIDDLE_VALUE_TYPE.BYTE;
            default: return MIDDLE_VALUE_TYPE.ADDRESS;
        }
    }
}
