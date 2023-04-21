package net.tsbe.models.visitors;

import net.tsbe.middle.models.Pair;
import net.tsbe.models.*;
import net.tsbe.models.nodes.*;
import net.tsbe.utils.CompilatorDisplayer;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class ForLoopsOptimizerVisitor extends SimpleScriptBaseVisitor<List<Node>> {

    @Override
    public List<Node> visitInstructionFor(InstructionFor ctx) {
        List<Node> nodes = new LinkedList<>();
        InstructionVariableDeclaration variableDeclaration = new InstructionVariableDeclaration();
        variableDeclaration.setId(ctx.getVarId());
        variableDeclaration.setType(ctx.getVarType());
        variableDeclaration.setExpression(ctx.getVarValue());
        variableDeclaration.setPosition(ctx.getPosition());
        InstructionWhile whil = new InstructionWhile();
        whil.setCondition(ctx.getComparaison());
        whil.setPosition(ctx.getPosition());
        Instruction nextBeforeFor = ctx.getNext();
        if(!(nextBeforeFor instanceof InstructionVariableAssign)){
            CompilatorDisplayer.showGenericErrorMessage(CompilatorDisplayer.ERROR_CROSS_ICON + " INCORRECT INSTRUCTION", "The last clause of for loop should be a variable assigment, either incrementation or assignment.", true, true);
            System.exit(1);
        }
        if(ctx.getBody() instanceof InstructionBlock){
            ((InstructionBlock) ctx.getBody()).getInstructions().add(ctx.getNext());
            ctx.getBody().accept(this);
        }else{
            InstructionBlock b = new InstructionBlock();
            List<Instruction> bli = new LinkedList<>();
            bli.add(ctx.getBody());
            bli.add(ctx.getNext());
            b.setInstructions(bli);
            b.setPosition(ctx.getPosition());
            ctx.setBody(b);
            b.accept(this);
        }
        whil.setIfTrue(ctx.getBody());
        nodes.add(variableDeclaration);
        nodes.add(whil);
        return nodes;
    }

    @Override
    public List<Node> visitInstructionBlock(InstructionBlock ctx) {
        List<Pair<Integer, List<Node>>> replaceWith = new LinkedList<>();
        int index = 0;
        for(Instruction n : ctx.getInstructions()){
            if(n instanceof InstructionFor){
                replaceWith.add(new Pair<>(index, n.accept(this)));
            }
            index++;
        }
        for(Pair<Integer, List<Node>> kv : replaceWith){
            ctx.getInstructions().remove(kv.getFirst().intValue());
            ctx.getInstructions().addAll(kv.getFirst(), kv.getSecond().stream().map(e -> (Instruction) e).collect(Collectors.toList()));
        }
        return null;
    }

    @Override
    public List<Node> visitProgram(Program ctx) {
        // Basic replacements
        List<Pair<Integer, List<Node>>> replaceWith = new LinkedList<>();
        int index = 0;
        for(Node n : ctx.getChildrens()){
            if(n instanceof InstructionFor){
                replaceWith.add(new Pair<>(index, n.accept(this)));
            }else if(n instanceof InstructionBlock){
                n.accept(this);
            }
            index++;
        }
        for(Pair<Integer, List<Node>> kv : replaceWith){
            ctx.getChildrens().remove(kv.getFirst().intValue());
            ctx.getChildrens().addAll(kv.getFirst(), kv.getSecond());
        }

        return null;
    }
}
