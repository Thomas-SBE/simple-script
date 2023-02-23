package net.tsbe.models;

public interface SimpleScriptASTVisitable<T> {

    T accept(SimpleScriptASTVisitor<T> visitor);

}
