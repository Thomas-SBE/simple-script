package net.tsbe.models;

import net.tsbe.models.nodes.FunctionDeclaration;
import net.tsbe.models.nodes.FunctionParameter;
import net.tsbe.models.nodes.Program;

public abstract class Node implements SimpleScriptASTVisitable{

    private Position _position;

    public Position getPosition() {
        return _position;
    }
    public void setPosition(Position p) { _position = p; }

    @Override
    public <T> T accept(SimpleScriptASTVisitor<T> visitor) {
        if(this instanceof Program) return visitor.visitProgram((Program) this);
        else if(this instanceof FunctionParameter) return visitor.visitFunctionParameter((FunctionParameter) this);
        else if(this instanceof FunctionDeclaration) return visitor.visitFunctionDeclaration((FunctionDeclaration) this);
        else {
            return null;
        }
    }
}
