package net.tsbe.middle.lang;

import net.tsbe.middle.models.Command;
import net.tsbe.middle.models.MiddleLangVisitor;

public abstract class Label extends Command {

    public static Label named(String name){ return new NamedLabel(name); }
    public static Label auto(){ return new GeneratedLabel(); }

    @Override
    public <T> T accept(MiddleLangVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
