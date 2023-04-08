package net.tsbe.middle.models;

import java.util.LinkedList;
import java.util.List;

public class Result {

    private MiddleExpression expression;
    private List<Command> code;

    public MiddleExpression getExpression() {
        return expression;
    }

    public List<Command> getCode() {
        return code;
    }

    public Result(MiddleExpression expression, List<Command> code) {
        this.expression = expression;
        this.code = code;
    }

    public Result(MiddleExpression expression){
        this(expression, new LinkedList<>());
    }

    public Result(List<Command> code){
        this(null, code);
    }
}
