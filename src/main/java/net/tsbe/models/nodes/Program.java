package net.tsbe.models.nodes;

import net.tsbe.models.Node;
import net.tsbe.models.SimpleScriptASTVisitable;
import net.tsbe.models.SimpleScriptASTVisitor;

import java.util.List;

public class Program extends Node {

    List<Node> childrens;

    public List<Node> getChildrens() {
        return childrens;
    }

    public void setChildrens(List<Node> childrens) {
        this.childrens = childrens;
    }

}
