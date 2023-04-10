package net.tsbe.middle.lang;

import net.tsbe.generators.GeneratorFromIR;
import net.tsbe.middle.models.Command;
import net.tsbe.middle.models.GeneratorResult;
import net.tsbe.middle.models.MiddleLangVisitor;

public abstract class Label extends Command {

    public static Label named(String name){ return new NamedLabel(name); }
    public static Label auto(){ return new GeneratedLabel(); }

    @Override
    public GeneratorResult accept(GeneratorFromIR visitor) {
        return visitor.visit(this);
    }

    @Override
    public <T> T accept(MiddleLangVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
