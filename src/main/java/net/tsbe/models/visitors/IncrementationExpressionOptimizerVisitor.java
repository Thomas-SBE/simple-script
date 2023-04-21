package net.tsbe.models.visitors;

import net.tsbe.middle.models.Pair;
import net.tsbe.models.Expression;
import net.tsbe.models.Instruction;
import net.tsbe.models.Node;
import net.tsbe.models.SimpleScriptBaseVisitor;
import net.tsbe.models.enums.BINARY_OPERATOR;
import net.tsbe.models.nodes.*;

import java.util.LinkedList;
import java.util.List;

public class IncrementationExpressionOptimizerVisitor extends SimpleScriptBaseVisitor<Node> {

    List<Node> appendIncrementations = new LinkedList<>();

    boolean inFunction = false;

    @Override
    public Node visitExpressionIncrement(ExpressionIncrement ctx) {
        ExpressionIdentifier id = new ExpressionIdentifier();
        id.setId(ctx.getId());
        id.setPosition(ctx.getPosition());
        InstructionVariableAssign assign = new InstructionVariableAssign();
        assign.setId(ctx.getId());
        ExpressionBinary bn = new ExpressionBinary();
        bn.setLeft(id);
        ExpressionInteger integer = new ExpressionInteger();
        integer.setValue(1);
        integer.setPosition(ctx.getPosition());
        bn.setRight(integer);
        bn.setOperation(ctx.getType_of_incrementation() == ExpressionIncrement.TYPE.INCREMENTS ? BINARY_OPERATOR.ADD : BINARY_OPERATOR.SUBSTRACT);
        bn.setOperator(ctx.getType_of_incrementation() == ExpressionIncrement.TYPE.INCREMENTS ? "+" : "-");
        assign.setExpression(bn);
        appendIncrementations.add(assign);
        if(inFunction)
            return bn;
        else
            return id;
    }

    @Override
    public Node visitExpressionEmbedded(ExpressionEmbedded ctx) {
        ctx.setExpression((Expression) ctx.getExpression().accept(this));
        return ctx;
    }

    @Override
    public Node visitInstructionVariableDeclaration(InstructionVariableDeclaration ctx) {
        ctx.setExpression((Expression) ctx.getExpression().accept(this));
        return ctx;
    }

    @Override
    public Node visitExpressionType(ExpressionType ctx) {
        return ctx;
    }

    @Override
    public Node visitInstructionVariableArrayDeclaration(InstructionVariableArrayDeclaration ctx) {
        for(int i = 0; i < ctx.getValues().size(); i++){
            ctx.getValues().set(i, (Expression) ctx.getValues().get(0).accept(this));
        }
        return ctx;
    }

    @Override
    public Node visitExpressionIdentifierArray(ExpressionIdentifierArray ctx) {
        return ctx;
    }

    @Override
    public Node visitInstructionVariableArrayAssign(InstructionVariableArrayAssign ctx) {
        ctx.setIndex((Expression) ctx.getIndex().accept(this));
        ctx.setValue((Expression) ctx.getValue().accept(this));
        return ctx;
    }

    @Override
    public Node visitInstructionBlock(InstructionBlock ctx) {
        int index = 0;
        List<Pair<Integer, Node>> replacements = new LinkedList<>();
        for(Node i : ctx.getInstructions()){
            i.accept(this);
            if(!appendIncrementations.isEmpty()){
                for(Node n : appendIncrementations)
                    replacements.add(new Pair<>(index+1, n));
                appendIncrementations.clear();
            }
            index++;
        }
        for(int x = 0; x < replacements.size(); x++){
            Pair<Integer, Node> curr = replacements.get(x);
            ctx.getInstructions().add(curr.getFirst().intValue() + x, (Instruction) curr.getSecond());
        }
        return ctx;
    }

    @Override
    public Node visitInstructionWhile(InstructionWhile ctx) {
        ctx.setCondition((Expression) ctx.getCondition().accept(this));
        if(!appendIncrementations.isEmpty()){
            if(!(ctx.getIfTrue() instanceof InstructionBlock)){
                InstructionBlock block = new InstructionBlock();
                block.setPosition(ctx.getIfTrue().getPosition());
                block.setInstructions(List.of(ctx.getIfTrue()));
                ctx.setIfTrue(block);
            }
            for(Node n : appendIncrementations){
                ((InstructionBlock) ctx.getIfTrue()).getInstructions().add(0, (Instruction) n);
            }
            appendIncrementations.clear();
        }
        ctx.setIfTrue((Instruction) ctx.getIfTrue().accept(this));
        return ctx;
    }

    @Override
    public Node visitExpressionBinary(ExpressionBinary ctx) {
        ctx.setLeft((Expression) ctx.getLeft().accept(this));
        ctx.setRight((Expression) ctx.getRight().accept(this));
        return ctx;
    }

    @Override
    public Node visitExpressionBoolean(ExpressionBoolean ctx) {
        return ctx;
    }

    @Override
    public Node visitExpressionFunctionCall(ExpressionFunctionCall ctx) {
        inFunction = true;
        for(int i = 0; i < ctx.getParameters().size(); i++){
            ctx.getParameters().set(i, (Expression) ctx.getParameters().get(i).accept(this));
        }
        inFunction = false;
        return ctx;
    }

    @Override
    public Node visitExpressionIdentifier(ExpressionIdentifier ctx) {
        return ctx;
    }

    @Override
    public Node visitExpressionInteger(ExpressionInteger ctx) {
        return ctx;
    }

    @Override
    public Node visitExpressionUnary(ExpressionUnary ctx) {
        ctx.setExpression((Expression) ctx.getExpression().accept(this));
        return ctx;
    }

    @Override
    public Node visitFunctionDeclaration(FunctionDeclaration ctx) {
        return ctx;
    }

    @Override
    public Node visitFunctionParameter(FunctionParameter ctx) {
        return ctx;
    }

    @Override
    public Node visitInstructionFunctionCall(InstructionFunctionCall ctx) {
        inFunction = true;
        for(int i = 0; i < ctx.getParameters().size(); i++)
            ctx.getParameters().set(i, (Expression) ctx.getParameters().get(i).accept(this));
        inFunction = false;
        return ctx;
    }

    @Override
    public Node visitInstructionIf(InstructionIf ctx) {
        ctx.setCondition((Expression) ctx.getCondition().accept(this));
        if(!appendIncrementations.isEmpty()){
            if(!(ctx.getIfTrue() instanceof InstructionBlock)){
                InstructionBlock block = new InstructionBlock();
                block.setPosition(ctx.getIfTrue().getPosition());
                List<Instruction> ls = new LinkedList<>();
                ls.add(ctx.getIfTrue());
                block.setInstructions(ls);
                ctx.setIfTrue(block);
            }
            if(ctx.getIfFalse() != null){
                if(!(ctx.getIfFalse() instanceof InstructionBlock)){
                    InstructionBlock block = new InstructionBlock();
                    block.setPosition(ctx.getIfFalse().getPosition());
                    List<Instruction> ls = new LinkedList<>();
                    ls.add(ctx.getIfFalse());
                    block.setInstructions(ls);
                    ctx.setIfTrue(block);
                }
            }
            for(Node n : appendIncrementations){
                ((InstructionBlock) ctx.getIfTrue()).getInstructions().add(0, (Instruction) n);
                if(ctx.getIfFalse() != null){
                    ((InstructionBlock) ctx.getIfFalse()).getInstructions().add(0, (Instruction) n);
                }
            }
            appendIncrementations.clear();
        }
        ctx.setIfTrue((Instruction) ctx.getIfTrue().accept(this));
        if(ctx.getIfFalse() != null) ctx.setIfFalse((Instruction) ctx.getIfFalse().accept(this));
        return ctx;
    }

    @Override
    public Node visitInstructionReturn(InstructionReturn ctx) {
        ctx.setExpression((Expression) ctx.getExpression().accept(this));
        return ctx;
    }

    @Override
    public Node visitInstructionVariableAssign(InstructionVariableAssign ctx) {
        ctx.setExpression((Expression) ctx.getExpression().accept(this));
        return ctx;
    }

    @Override
    public Node visitProgram(Program ctx) {
        int index = 0;
        List<Pair<Integer, Node>> replacements = new LinkedList<>();
        for(Node i : ctx.getChildrens()){
            i.accept(this);
            if(!appendIncrementations.isEmpty()){
                for(Node n : appendIncrementations)
                    replacements.add(new Pair<>(index+1, n));
                appendIncrementations.clear();
            }
            index++;
        }
        for(int x = 0; x < replacements.size(); x++){
            Pair<Integer, Node> curr = replacements.get(x);
            ctx.getChildrens().add(curr.getFirst().intValue() + x, curr.getSecond());
        }
        return ctx;
    }
}
