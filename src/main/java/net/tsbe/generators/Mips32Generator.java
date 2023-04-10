package net.tsbe.generators;

import net.tsbe.middle.Register;
import net.tsbe.middle.expressions.*;
import net.tsbe.middle.lang.*;
import net.tsbe.middle.models.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Mips32Generator implements GeneratorFromIR{

    @Override
    public List<String> generate(Pair<Label, List<Pair<Frame, List<Command>>>> context) {
        List<String> instructions = new ArrayList<>();
        // Add instruction to go to "main" body code.
        instructions.add("j " + context.getFirst());
        // Foreach "functions" in the code.
        for(Pair<Frame, List<Command>> frames : context.getSecond()){
            instructions.add(frames.getFirst().getEntry() + ":");
            int arg_count = 0;
            for(Register argr : frames.getFirst().getParametersRegisters()){
                instructions.add("move $t"+argr.getRegisterId()+", $s"+arg_count);
                arg_count++;
            }
            // Foreach "line" of code.
            for(Command command : frames.getSecond()){
                instructions.addAll(command.accept(this).getLines());
            }
            instructions.addAll(frames.getFirst().getExit().accept(this).getLines());
            if(frames.getFirst().getResultRegister().isPresent())
                instructions.add("move $v0, $t"+frames.getFirst().getResultRegister().get().getRegisterId());
            if(!frames.getFirst().getEntry().toString().equals("main")){
                instructions.add("j $ra");
            }
        }
        return instructions;
    }

    @Override
    public GeneratorResult visit(ConditionalJumpCommand ctx) {
        List<String> code = new LinkedList<>();
        GeneratorResult r = ctx.getCondition().accept(this);
        code.addAll(r.getLines());
        code.add("beq $v0, 1, "+ctx.getTrueLabel());
        code.add("j "+ctx.getFalseLabel());
        GeneratorResult res = new GeneratorResult(code);
        return res;
    }

    @Override
    public GeneratorResult visit(FunctionCallCommand ctx) {
        List<String> code = new LinkedList<>();
        int arg_count = 0;
        for(MiddleExpression arg : ctx.getFunctionArguments()){
            GeneratorResult r = arg.accept(this);
            if(r.getLines() != null)
                code.addAll(r.getLines());
            if(r.getExp() != null && r.getExp().startsWith("$"))
                code.add("move $s"+arg_count+", " + r.getExp());
            else{
                code.add("li $s"+arg_count+", " + r.getExp());
            }
            arg_count++;
        }
        code.add("jal "+ctx.getFrame().getEntry());
        code.add("move $t"+ctx.getRegister().getRegisterId()+", $v0");
        return new GeneratorResult(code);
    }

    @Override
    public GeneratorResult visit(Label ctx) {
        List<String> code = new LinkedList<>();
        code.add(ctx + ":");
        return new GeneratorResult(code);
    }

    @Override
    public GeneratorResult visit(WriteMemoryCommand ctx) {
        return null;
    }

    @Override
    public GeneratorResult visit(WriteRegisterCommand ctx) {
        List<String> code = new LinkedList<>();
        GeneratorResult r = ctx.getExpression().accept(this);
        if(r.getLines() != null)
            code.addAll(r.getLines());
        if(r.getExp() != null && r.getExp().startsWith("$"))
            code.add("move $t" + ctx.getRegister().getRegisterId() +", " + r.getExp());
        else
            code.add("li $t" + ctx.getRegister().getRegisterId() +", " + r.getExp());
        return new GeneratorResult(code);
    }

    @Override
    public GeneratorResult visit(JumpCommand ctx) {
        List<String> code = new LinkedList<>();
        code.add("j "+ ctx.getGoToLabel());
        return new GeneratorResult(code);
    }

    @Override
    public GeneratorResult visit(BinaryMiddleExpression ctx) {
        List<String> code = new LinkedList<>();
        GeneratorResult left = ctx.getLeft().accept(this);
        GeneratorResult right = ctx.getRight().accept(this);
        String regleft = left.getExp();
        String regright = right.getExp();
        if(!left.getExp().startsWith("$"))
        {
            code.add("li $v0, "+left.getExp());
            regleft = "$v0";
        }
        if(!right.getExp().startsWith("$")){
            code.add("li $v1, "+right.getExp());
            regright = "$v1";
        }
        switch (ctx.getOp()){
            case ADD -> {
                code.add("add $v0, " + regleft + ", " + regright);
                return new GeneratorResult(code, "$v0");
            }
            case SUBSTRACT -> {
                code.add("sub $v0, " + regleft + ", " + regright);
                return new GeneratorResult(code, "$v0");
            }
            case MULTIPLY -> {
                code.add("mult " + regleft + ", " + regright);
                code.add("mflo $v0");
                return new GeneratorResult(code, "$v0");
            }
            case DIVIDE -> {
                code.add("div " + regleft + ", " + regright);
                code.add("mflo $v0");
                return new GeneratorResult(code, "$v0");
            }
            case EQUALS -> {
                code.add("seq $v0, " + regleft + ", " + regright);
                return new GeneratorResult(code, "$v0");
            }
            case DIFFERENT -> {
                code.add("sne $v0, " + regleft + ", " + regright);
                return new GeneratorResult(code, "$v0");
            }
            case SUPERIOR -> {
                code.add("sgt $v0, " + regleft + ", " + regright);
                return new GeneratorResult(code, "$v0");
            }
            case SUP_OR_EQUALS -> {
                code.add("sge $v0, " + regleft + ", " + regright);
                return new GeneratorResult(code, "$v0");
            }
            case LESS -> {
                code.add("slt $v0, " + regleft + ", " + regright);
                return new GeneratorResult(code, "$v0");
            }
            case LESS_OR_EQUALS -> {
                code.add("sle $v0, " + regleft + ", " + regright);
                return new GeneratorResult(code, "$v0");
            }
            case AND -> {
                code.add("and $v0, " + regleft + ", " + regright);
                return new GeneratorResult(code, "$v0");
            }
            case OR -> {
                code.add("or $v0, " + regleft + ", " + regright);
                return new GeneratorResult(code, "$v0");
            }
            default -> {
                return null;
            }
        }
    }

    @Override
    public GeneratorResult visit(ByteMiddleExpression ctx) {
        return new GeneratorResult(ctx.getValue() + "");
    }

    @Override
    public GeneratorResult visit(IntMiddleExpression ctx) {
        return new GeneratorResult(ctx.getValue() + "");
    }

    @Override
    public GeneratorResult visit(ReadRegisterMiddleExpression ctx) {
        return new GeneratorResult("$t" + ctx.getRegister().getRegisterId());
    }

    @Override
    public GeneratorResult visit(ReadMemoryMiddleExpression ctx) {
        return null;
    }

    @Override
    public GeneratorResult visit(UnaryMiddleExpression ctx) {
        GeneratorResult r = ctx.getExp().accept(this);
        List<String> code = new LinkedList<>();
        if(r.getLines() != null)
            code.addAll(r.getLines());
        switch (ctx.getOp()){
            case NOT -> {
                if(r.getExp().startsWith("$")){
                    code.add("not $v0, " + r.getExp());
                }else{
                    code.add("li $v1," + r.getExp());
                    code.add("not $v0, $v1");
                }
            }
            case MINUS -> {
                code.add("li $v1, -1");
                if(r.getExp().startsWith("$"))
                    code.add("mult " + r.getExp() + ", $v1");
                else {
                    code.add("li $v0, " + r.getExp());
                    code.add("mult $v0, $v1");
                }
                code.add("mflo $v0");
            }
            default -> {}
        }
        return new GeneratorResult(code, "$v0");
    }

    @Override
    public GeneratorResult visit(Symbol ctx) {
        return null;
    }


}
