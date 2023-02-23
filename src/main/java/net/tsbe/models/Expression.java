package net.tsbe.models;

import net.tsbe.models.nodes.*;

public abstract class Expression extends Node implements SimpleScriptASTVisitable<Node>{

    @Override()
    public Node accept(SimpleScriptASTVisitor<Node> visitor) {
        if(this instanceof ExpressionBinary) return visitor.visitExpressionBinary((ExpressionBinary) this);
        else if(this instanceof ExpressionBoolean) return visitor.visitExpressionBoolean((ExpressionBoolean) this);
        else if(this instanceof ExpressionCompare) return visitor.visitExpressionCompare((ExpressionCompare) this);
        else if(this instanceof ExpressionEmbedded) return visitor.visitExpressionEmbedded((ExpressionEmbedded) this);
        else if(this instanceof ExpressionFunctionCall) return visitor.visitExpressionFunctionCall((ExpressionFunctionCall) this);
        else if(this instanceof ExpressionIdentifier) return visitor.visitExpressionIdentifier((ExpressionIdentifier) this);
        else if(this instanceof ExpressionInteger) return visitor.visitExpressionInteger((ExpressionInteger) this);
        else if(this instanceof ExpressionUnary) return visitor.visitExpressionUnary((ExpressionUnary) this);
        else{
            return null;
        }
    }
}
