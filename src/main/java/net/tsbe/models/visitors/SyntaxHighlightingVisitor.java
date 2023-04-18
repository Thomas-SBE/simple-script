package net.tsbe.models.visitors;

import net.tsbe.models.Node;
import net.tsbe.models.SimpleScriptASTVisitor;
import net.tsbe.models.nodes.*;

import java.util.ArrayList;
import java.util.List;

public class SyntaxHighlightingVisitor implements SimpleScriptASTVisitor<Node> {


    String buffer = "";

    public List<String> fetch(){
        return List.of(buffer.split("\n"));
    }

    @Override
    public Node visitExpressionBinary(ExpressionBinary ctx) {
        ctx.getLeft().accept(this);
        buffer += " " + ctx.getOperator() + " ";
        ctx.getRight().accept(this);
        return null;
    }

    @Override
    public Node visitExpressionBoolean(ExpressionBoolean ctx) {
        buffer += "\u001b[35m" + (ctx.isValue() ? "true" : "false") + "\u001b[0m";
        return null;
    }

    @Override
    public Node visitExpressionEmbedded(ExpressionEmbedded ctx) {
        buffer += "(";
        ctx.getExpression().accept(this);
        buffer += ")";
        return null;
    }

    @Override
    public Node visitExpressionFunctionCall(ExpressionFunctionCall ctx) {
        buffer += "\u001b[33m" + ctx.getId() + "\u001b[0m(";
        ctx.getParameters().forEach(p -> {
            p.accept(this);
            if(p != ctx.getParameters().get(ctx.getParameters().size()-1)) buffer += ", ";
        });
        buffer += ")";
        return null;
    }

    @Override
    public Node visitExpressionIdentifier(ExpressionIdentifier ctx) {
        if(localVars.contains(ctx.getId())){
            buffer += "\u001b[37;4m" + ctx.getId() + "\u001b[0m";
        }else{
            buffer += ctx.getId();
        }
        return null;
    }

    @Override
    public Node visitExpressionIncrement(ExpressionIncrement ctx) {
        buffer += ctx.getId() + "\u001b[33m" + ctx.getType_of_incrementation() + "\u001b[0m";
        return null;
    }

    @Override
    public Node visitExpressionInteger(ExpressionInteger ctx) {
        buffer += "\u001b[35m" + ctx.getValue() + "\u001b[0m";
        return null;
    }

    @Override
    public Node visitExpressionUnary(ExpressionUnary ctx) {
        buffer += ctx.getOperator();
        ctx.getExpression().accept(this);
        return null;
    }

    @Override
    public Node visitExpressionType(ExpressionType ctx) {
        buffer += "\u001b[36m" + ctx.getRawType() + "\u001b[31m";
        return null;
    }

    List<String> localVars = new ArrayList<>();

    @Override
    public Node visitFunctionDeclaration(FunctionDeclaration ctx) {
        buffer += "\u001b[31mfunction \u001b[33;4m" + ctx.getId() + "\u001b[0m(";
        localVars.clear();
        ctx.getParameters().forEach(p -> {
            p.accept(this);
            if(p != ctx.getParameters().get(ctx.getParameters().size()-1)) buffer += ", ";
        });
        buffer += "): ";
        ctx.getType().accept(this);
        buffer += " => \u001b[0m";
        ctx.getBody().accept(this);
        localVars.clear();
        return null;
    }

    @Override
    public Node visitFunctionParameter(FunctionParameter ctx) {
        buffer += "\u001b[37;4m" + ctx.getId() + "\u001b[0m: ";
        ctx.getType().accept(this);
        buffer += "\u001b[0m";
        localVars.add(ctx.getId());
        return null;
    }

    int blockIndentationLevel = 0;

    @Override
    public Node visitInstructionBlock(InstructionBlock ctx) {
        buffer += "    ".repeat(blockIndentationLevel);
        buffer += "{\n";
        blockIndentationLevel++;
        ctx.getInstructions().forEach(i -> {
            buffer += "    ".repeat(blockIndentationLevel);
            i.accept(this);
            buffer += "\n";
        });
        blockIndentationLevel--;
        buffer += "    ".repeat(blockIndentationLevel);
        buffer += "}";
        return null;
    }

    @Override
    public Node visitInstructionIf(InstructionIf ctx) {
        buffer += "\u001b[31mif\u001b[0m (";
        ctx.getCondition().accept(this);
        buffer += ") \u001b[31m=>\u001b[0m ";
        ctx.getIfTrue().accept(this);
        if(ctx.getIfFalse() != null){
            buffer += " \u001b[31melse =>\u001b[0m ";
            ctx.getIfFalse().accept(this);
        }
        return null;
    }

    @Override
    public Node visitInstructionReturn(InstructionReturn ctx) {
        buffer += "\u001b[31mreturn\u001b[0m ";
        ctx.getExpression().accept(this);
        buffer += ";";
        return null;
    }

    @Override
    public Node visitInstructionVariableAssign(InstructionVariableAssign ctx) {
        buffer += ctx.getId() + " = ";
        ctx.getExpression().accept(this);
        buffer += ";";
        return null;
    }

    @Override
    public Node visitInstructionVariableDeclaration(InstructionVariableDeclaration ctx) {
        buffer += "\u001b[31mvar\u001b[0m " + ctx.getId() + ": ";
        ctx.getType().accept(this);
        buffer += "\u001b[0m";
        if(ctx.getExpression() != null){
            buffer += " = ";
            ctx.getExpression().accept(this);
        }
        buffer += ";";
        return null;
    }

    @Override
    public Node visitInstructionWhile(InstructionWhile ctx) {
        buffer += "\u001b[31mwhile\u001b[0m (";
        ctx.getCondition().accept(this);
        buffer += ") \u001b[31m=>\u001b[0m ";
        ctx.getIfTrue().accept(this);
        return null;
    }

    @Override
    public Node visitInstructionFunctionCall(InstructionFunctionCall ctx) {
        buffer += "\u001b[33m" + ctx.getId() + "\u001b[0m(";
        ctx.getParameters().forEach(p -> {
            p.accept(this);
            if(p != ctx.getParameters().get(ctx.getParameters().size()-1)) buffer += ", ";
        });
        buffer += ")";
        return null;
    }

    @Override
    public Node visitInstructionFor(InstructionFor ctx) {
        buffer += "\u001b[31mfor\u001b[0m (\u001b[31mvar\u001b[0m "+ctx.getVarId()+": ";
        ctx.getVarType().accept(this);
        buffer += " = ";
        ctx.getVarValue().accept(this);
        buffer += "; ";
        ctx.getComparaison().accept(this);
        buffer += "; ";
        ctx.getNext().accept(this);
        buffer += ") \u001b[31m=>\u001b[0m ";
        ctx.getBody().accept(this);
        return null;
    }

    @Override
    public Node visitProgram(Program ctx) {
        buffer = "";
        ctx.getChildrens().forEach(c -> {
            c.accept(this);
            buffer += "\n";
        });
        return null;
    }
}
