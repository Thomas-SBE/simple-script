package net.tsbe.middle.lang;

import net.tsbe.middle.models.Command;
import net.tsbe.middle.models.MiddleExpression;
import net.tsbe.middle.models.MiddleLangVisitor;

public class ConditionalJumpCommand extends Command {

    final private MiddleExpression condition;
    final private Label trueLabel;
    final private Label falseLabel;

    public MiddleExpression getCondition() {
        return condition;
    }

    public Label getTrueLabel() {
        return trueLabel;
    }

    public Label getFalseLabel() {
        return falseLabel;
    }

    public ConditionalJumpCommand(MiddleExpression condition, Label trueLabel, Label falseLabel) {
        this.condition = condition;
        this.trueLabel = trueLabel;
        this.falseLabel = falseLabel;
    }

    @Override
    public String toString() {
        return "CJump("+condition+" ? " + trueLabel + " : " + falseLabel + ")";
    }

    @Override
    public <T> T accept(MiddleLangVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
