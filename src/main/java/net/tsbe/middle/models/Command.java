package net.tsbe.middle.models;

abstract public class Command {
    public abstract <T> T accept(MiddleLangVisitor<T> visitor);
}
