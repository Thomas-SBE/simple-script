package net.tsbe.middle.lang;

import net.tsbe.middle.models.Command;
import net.tsbe.middle.models.MiddleLangVisitor;

public class JumpCommand extends Command {

    final private Label goToLabel;

    public JumpCommand(Label goToLabel) {
        this.goToLabel = goToLabel;
    }

    public Label getGoToLabel() {
        return goToLabel;
    }

    @Override
    public String toString() {
        return "goto " + goToLabel;
    }

    @Override
    public <T> T accept(MiddleLangVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
