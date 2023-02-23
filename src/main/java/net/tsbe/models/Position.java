package net.tsbe.models;

import org.antlr.v4.runtime.ParserRuleContext;

public class Position {

    private int lineNumber;
    private int lineOffset;

    private Position(int line, int offset){ lineNumber = line; lineOffset = offset; }

    public static Position getRulePosition(ParserRuleContext rule){ return new Position(rule.start.getLine(), rule.start.getCharPositionInLine()); }

    public int getLineNumber() {
        return lineNumber;
    }

    public int getLineOffset() {
        return lineOffset;
    }
}
