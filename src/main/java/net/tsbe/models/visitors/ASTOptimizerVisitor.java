package net.tsbe.models.visitors;

import net.tsbe.middle.models.Pair;
import net.tsbe.models.Instruction;
import net.tsbe.models.Node;
import net.tsbe.models.Position;
import net.tsbe.models.SimpleScriptBaseVisitor;
import net.tsbe.models.nodes.*;
import net.tsbe.utils.CompilatorDisplayer;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ASTOptimizerVisitor extends SimpleScriptBaseVisitor<List<Node>> {

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
        }else{
            InstructionBlock b = new InstructionBlock();
            List<Instruction> bli = new LinkedList<>();
            bli.add(ctx.getBody());
            bli.add(ctx.getNext());
            b.setInstructions(bli);
            b.setPosition(ctx.getPosition());
            ctx.setBody(b);
        }
        whil.setIfTrue(ctx.getBody());
        nodes.add(variableDeclaration);
        nodes.add(whil);
        return nodes;
    }

    @Override
    public List<Node> visitProgram(Program ctx) {
        List<Pair<Integer, List<Node>>> replaceWith = new LinkedList<>();
        int index = 0;
        for(Node n : ctx.getChildrens()){
            if(n instanceof InstructionFor){
                replaceWith.add(new Pair<>(index, n.accept(this)));
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
