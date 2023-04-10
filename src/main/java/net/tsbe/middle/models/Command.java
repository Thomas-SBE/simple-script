package net.tsbe.middle.models;

import net.tsbe.generators.GeneratorFromIR;

abstract public class Command {

    public abstract GeneratorResult accept(GeneratorFromIR visitor);
    public abstract <T> T accept(MiddleLangVisitor<T> visitor);
}
