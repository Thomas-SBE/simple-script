package net.tsbe.generators;

import net.tsbe.middle.Register;
import net.tsbe.middle.expressions.*;
import net.tsbe.middle.lang.*;
import net.tsbe.middle.models.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Mips32Generator implements GeneratorFromIR{

    Frame current_frame;

    @Override
    public List<String> generate(Pair<Label, List<Pair<Frame, List<Command>>>> context) {
        List<String> instructions = new ArrayList<>();
        // Add instruction to go to "main" body code.
        instructions.add("j " + context.getFirst());
        // Foreach "functions" in the code.
        for(Pair<Frame, List<Command>> frames : context.getSecond()){
            current_frame = frames.getFirst();
            instructions.add(frames.getFirst().getEntry() + ":");
            if(frames.getFirst().getEntry().toString().equals("main")){
                // Sets the Data segment pointer to point into correct address
                instructions.add("li $fp, 0x10000000");
            }

            // Store Status of function call
            int shift_amount = 1;
            for(int ar = 0; ar < frames.getFirst().getLocalVariablesRegisters().size(); ar++) shift_amount += 1;
            for(int ar = 0; ar < frames.getFirst().getParametersRegisters().size(); ar++) shift_amount += 1;
            instructions.add("addi $sp, $sp, -"+(shift_amount*4));
            instructions.add("sw $ra, 0($sp)");
            int shift_current = 4;
            for(Register reg: frames.getFirst().getLocalVariablesRegisters()) {
                instructions.add("sw $t"+reg.getRegisterId()+", "+shift_current+"($sp)");
                shift_current += 4;
            }
            for(Register reg: frames.getFirst().getParametersRegisters()) {
                instructions.add("sw $t"+reg.getRegisterId()+", "+shift_current+"($sp)");
                shift_current += 4;
            }

            int arg_count = 0;
            for(Register argr : frames.getFirst().getParametersRegisters()){
                instructions.add("move $t"+argr.getRegisterId()+", $s"+arg_count);
                arg_count++;
            }
            arg_count = 0;
            for(Register argr : frames.getFirst().getLocalVariablesRegisters()){
                instructions.add("move $t"+argr.getRegisterId()+", $s"+arg_count);
                arg_count++;
            }

            // If reserved function put arguments at correct location.
            if(frames.getFirst().isReservedFrame()){
                int temp_arg_index = 0;
                for(Register r : frames.getFirst().getParametersRegisters())
                    instructions.add("move $a"+(temp_arg_index++)+", $t"+r.getRegisterId());
            }

            // Foreach "line" of code.
            for(Command command : frames.getSecond()){
                instructions.addAll(command.accept(this).getLines());
            }
            instructions.addAll(frames.getFirst().getExit().accept(this).getLines());

            // Restore Status of function call
            instructions.add("lw $ra, 0($sp)");
            shift_current = 4;
            for(Register reg: frames.getFirst().getLocalVariablesRegisters()) {
                instructions.add("lw $t"+reg.getRegisterId()+", "+shift_current+"($sp)");
                shift_current += 4;
            }
            for(Register reg: frames.getFirst().getParametersRegisters()) {
                instructions.add("lw $t"+reg.getRegisterId()+", "+shift_current+"($sp)");
                shift_current += 4;
            }
            instructions.add("addi $sp, $sp, "+(shift_amount*4));

            if(!frames.getFirst().getEntry().toString().equals("main")){
                instructions.add("j $ra");
            }
        }
        instructions.add("li $v0, 10");
        instructions.add("syscall");
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

        //code.add("move $t"+ctx.getRegister().getRegisterId()+", $v0");
        if(ctx.getFrame().getResultRegister().isPresent())
            return new GeneratorResult(code, "$t"+ctx.getFrame().getResultRegister().get().getRegisterId());
        else
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
        List<String> code = new LinkedList<>();
        code.add("sw $t"+ctx.getRegister().getRegisterId()+", "+(ctx.getOffset() != 0 ? ctx.getOffset() : "")+"($fp)");
        return new GeneratorResult(code);
    }

    @Override
    public GeneratorResult visit(WriteMemoryWithOffsetCommand ctx) {
        List<String> code = new LinkedList<>();
        GeneratorResult r = ctx.getInnerOffset().accept(this);
        if(r.getLines() != null) code.addAll(r.getLines());
        if(r.getExp().startsWith("$")) {
            code.add("move $k0, $fp");
            if(ctx.getOffset() != 0)
                code.add("add $k0, $k0, "+(ctx.getOffset()*4));
            code.add("li $v1, 4");
            code.add("mult "+r.getExp()+", $v1");
            code.add("mflo $v0");
            code.add("add $k0, $k0, $v0");
            code.add("sw $t"+ctx.getRegister().getRegisterId()+", ($k0)");
        }
        else{
            int off = Integer.parseInt(r.getExp());
            code.add("sw $t"+ctx.getRegister().getRegisterId()+", "+(ctx.getOffset()+(off*4) != 0 ? ctx.getOffset()+(off*4) : "")+"($fp)");
        }
        return new GeneratorResult(code);
    }

    @Override
    public GeneratorResult visit(WriteRegisterCommand ctx) {
        List<String> code = new LinkedList<>();
        GeneratorResult r = ctx.getExpression().accept(this);
        if(r.getLines() != null)
            code.addAll(r.getLines());
        if(r.getExp() != null && r.getExp().startsWith("$"))
            if(ctx.getRegister() != null) code.add("move $t" + ctx.getRegister().getRegisterId() +", " + r.getExp());
            else code.add("move $v0, " + r.getExp());
        else
            if(ctx.getRegister() != null) code.add("li $t" + ctx.getRegister().getRegisterId() +", " + r.getExp());
            else code.add("li $v0, " + r.getExp());
        return new GeneratorResult(code);
    }

    @Override
    public GeneratorResult visit(JumpCommand ctx) {
        List<String> code = new LinkedList<>();
        code.add("j "+ ctx.getGoToLabel());
        return new GeneratorResult(code);
    }

    @Override
    public GeneratorResult visit(SystemCallCommand ctx) {
        List<String> code = new LinkedList<>();
        code.add("li $v0, " + ctx.getSyscallType().toCoded());
        code.add("syscall");
        return new GeneratorResult(code);
    }

    @Override
    public GeneratorResult visit(BinaryMiddleExpression ctx) {
        List<String> code = new LinkedList<>();
        GeneratorResult left = ctx.getLeft().accept(this);
        GeneratorResult right = ctx.getRight().accept(this);

        if(left.getLines() != null) code.addAll(left.getLines());
        if(!left.getExp().startsWith("$"))
        {
            code.add("li $k0, "+left.getExp());
        }else{
            code.add("move $k0, "+left.getExp());
        }
        if(right.getLines() != null) code.addAll(right.getLines());

        if(!right.getExp().startsWith("$")){
            code.add("li $k1, "+right.getExp());
        }else{
            code.add("move $k1, "+right.getExp());
        }
        String regleft = "$k0";
        String regright = "$k1";
        switch (ctx.getOp()){
            case ADD -> {
                code.add("add $v0, " + regleft + ", " + regright);
            }
            case SUBSTRACT -> {
                code.add("sub $v0, " + regleft + ", " + regright);
            }
            case MULTIPLY -> {
                code.add("mult " + regleft + ", " + regright);
                code.add("mflo $v0");
            }
            case DIVIDE -> {
                code.add("div " + regleft + ", " + regright);
                code.add("mflo $v0");
            }
            case EQUALS -> {
                code.add("seq $v0, " + regleft + ", " + regright);
            }
            case DIFFERENT -> {
                code.add("sne $v0, " + regleft + ", " + regright);
            }
            case SUPERIOR -> {
                code.add("sgt $v0, " + regleft + ", " + regright);
            }
            case SUP_OR_EQUALS -> {
                code.add("sge $v0, " + regleft + ", " + regright);
            }
            case LESS -> {
                code.add("slt $v0, " + regleft + ", " + regright);
            }
            case LESS_OR_EQUALS -> {
                code.add("sle $v0, " + regleft + ", " + regright);
            }
            case AND -> {
                code.add("and $v0, " + regleft + ", " + regright);
            }
            case OR -> {
                code.add("or $v0, " + regleft + ", " + regright);
            }
            default -> {
            }
        }
        return new GeneratorResult(code, "$v0");
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
        List<String> code = new LinkedList<>();
        code.add("lw $t"+ctx.getRegister().getRegisterId()+", "+(ctx.getOffset() != 0 ? ctx.getOffset() : "")+"($fp)");
        return new GeneratorResult(code, "$t" + ctx.getRegister().getRegisterId());
    }

    @Override
    public GeneratorResult visit(ReadMemoryWithOffsetMiddleExpression ctx) {
        List<String> code = new LinkedList<>();
        GeneratorResult res = ctx.getOffset().accept(this);
        if(res.getLines() != null) code.addAll(res.getLines());
        if(res.getExp().startsWith("$")){
            code.add("move $k0, $fp");
            if(ctx.getVariableOffset() != 0)
                code.add("addi $k0, $k0, "+(ctx.getVariableOffset()*4));
            code.add("li $v1, 4");
            code.add("mult "+res.getExp()+", $v1");
            code.add("mflo $v0");
            code.add("add $k0, $k0, $v0");
            code.add("lw $t"+ctx.getRegister().getRegisterId()+", ($k0)");
        }
        else{
            int off = Integer.parseInt(res.getExp());
            code.add("lw $t"+ctx.getRegister().getRegisterId()+", "+(ctx.getVariableOffset()+(off*4) != 0 ? ctx.getVariableOffset()+(off*4) : "")+"($fp)");
        }

        return new GeneratorResult(code, "$t" + ctx.getRegister().getRegisterId());
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
