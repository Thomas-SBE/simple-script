package net.tsbe.utils;

import net.tsbe.models.Expression;
import net.tsbe.models.Instruction;
import net.tsbe.models.Node;
import net.tsbe.models.Position;
import net.tsbe.models.enums.BINARY_OPERATOR;
import net.tsbe.models.enums.UNARY_OPERATOR;
import net.tsbe.models.enums.VALUE_TYPE;
import net.tsbe.models.nodes.*;
import net.tsbe.antlr.generated.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class ASTGeneratorVisitor extends simplescriptBaseVisitor<Node> {

    @Override
    public Node visitExpressionInt(simplescriptParser.ExpressionIntContext ctx) {
        ExpressionInteger e = new ExpressionInteger();
        e.setValue(Integer.parseInt(ctx.INT().getText()));
        e.setPosition(Position.getRulePosition(ctx));
        return e;
    }

    @Override
    public Node visitExpressionBoolean(simplescriptParser.ExpressionBooleanContext ctx) {
        ExpressionBoolean e = new ExpressionBoolean();
        e.setValue(ctx.boolean_().getText().equals("true"));
        e.setPosition(Position.getRulePosition(ctx));
        return e;
    }

    @Override
    public Node visitExpressionBinary(simplescriptParser.ExpressionBinaryContext ctx) {
        ExpressionBinary e = new ExpressionBinary();
        e.setOperator(ctx.binary_operator().getText());
        switch (e.getOperator()){
            case "+" -> e.setOperation(BINARY_OPERATOR.ADD);
            case "-" -> e.setOperation(BINARY_OPERATOR.SUBSTRACT);
            case "/" -> e.setOperation(BINARY_OPERATOR.DIVIDE);
            case "*" -> e.setOperation(BINARY_OPERATOR.MULTIPLY);
            case "==" -> e.setOperation(BINARY_OPERATOR.EQUALS);
            case "!=" -> e.setOperation(BINARY_OPERATOR.DIFFERENT);
            case ">" -> e.setOperation(BINARY_OPERATOR.SUPERIOR);
            case ">=" -> e.setOperation(BINARY_OPERATOR.SUP_OR_EQUALS);
            case "<" -> e.setOperation(BINARY_OPERATOR.LESS);
            case "<=" -> e.setOperation(BINARY_OPERATOR.LESS_OR_EQUALS);
            case "||" -> e.setOperation(BINARY_OPERATOR.OR);
            case "&&" -> e.setOperation(BINARY_OPERATOR.AND);
        }
        e.setLeft((Expression) ctx.expression(0).accept(this));
        e.setRight((Expression) ctx.expression(1).accept(this));
        e.setPosition(Position.getRulePosition(ctx));
        return e;
    }

    @Override
    public Node visitExpressionUnary(simplescriptParser.ExpressionUnaryContext ctx) {
        ExpressionUnary e = new ExpressionUnary();
        e.setOperator(ctx.unary_operator().getText());
        switch (e.getOperator()){
            case "!" -> e.setOperation(UNARY_OPERATOR.NOT);
            case "-" -> e.setOperation(UNARY_OPERATOR.MINUS);
            case "+" -> e.setOperation(UNARY_OPERATOR.PLUS);
        }
        e.setExpression((Expression) ctx.expression().accept(this));
        e.setPosition(Position.getRulePosition(ctx));
        return e;
    }

    @Override
    public Node visitType(simplescriptParser.TypeContext ctx) {
        VALUE_TYPE type = VALUE_TYPE.OTHER;
        switch (ctx.getText()){
            case "bool": type = VALUE_TYPE.BOOLEAN; break;
            case "int": type = VALUE_TYPE.INTEGER; break;
            case "void": type = VALUE_TYPE.VOID; break;
            default: type = VALUE_TYPE.OTHER;
        }
        ExpressionType t = new ExpressionType(type, ctx.getText());
        t.setPosition(Position.getRulePosition(ctx));
        return t;
    }

    @Override
    public Node visitExpressionEmbedded(simplescriptParser.ExpressionEmbeddedContext ctx) {
        ExpressionEmbedded e = new ExpressionEmbedded();
        e.setExpression((Expression) ctx.expression().accept(this));
        e.setPosition(Position.getRulePosition(ctx));
        return e;
    }

    @Override
    public Node visitInstructionIncrementation(simplescriptParser.InstructionIncrementationContext ctx) {
        InstructionVariableAssign a = new InstructionVariableAssign();
        ExpressionBinary b = new ExpressionBinary();
        ExpressionIdentifier id = new ExpressionIdentifier();
        id.setId(ctx.ID().getText());
        b.setLeft(id);
        ExpressionInteger i = new ExpressionInteger();
        i.setValue(1);
        b.setRight(i);
        switch (ctx.increments_operator().getText()){
            case "++" -> { b.setOperation(BINARY_OPERATOR.ADD); b.setOperator("+"); }
            case "--" -> { b.setOperation(BINARY_OPERATOR.SUBSTRACT); b.setOperator("-"); }
        }
        a.setExpression(b);
        a.setId(id.getId());
        return a;
    }

    @Override
    public Node visitExpressionIncrementation(simplescriptParser.ExpressionIncrementationContext ctx) {
        ExpressionIncrement i = new ExpressionIncrement();
        i.setId(ctx.ID().getText());
        switch (ctx.increments_operator().getText()){
            case "++": i.setType_of_incrementation(ExpressionIncrement.TYPE.INCREMENTS);
            case "--": i.setType_of_incrementation(ExpressionIncrement.TYPE.DECREMENTS);
        }
        return i;
    }

    @Override
    public Node visitInstructionFunctionCall(simplescriptParser.InstructionFunctionCallContext ctx) {
        InstructionFunctionCall e = new InstructionFunctionCall();
        e.setId(ctx.ID().getText());
        List<Expression> parameters = new ArrayList<>();
        ctx.expression().forEach(expression -> parameters.add((Expression) expression.accept(this)));
        e.setParameters(parameters);
        e.setPosition(Position.getRulePosition(ctx));
        return e;
    }

    @Override
    public Node visitExpressionFunctionCall(simplescriptParser.ExpressionFunctionCallContext ctx) {
        ExpressionFunctionCall e = new ExpressionFunctionCall();
        e.setId(ctx.ID().getText());
        List<Expression> parameters = new ArrayList<>();
        ctx.expression().forEach(expression -> parameters.add((Expression) expression.accept(this)));
        e.setParameters(parameters);
        e.setPosition(Position.getRulePosition(ctx));
        return e;
    }

    @Override
    public Node visitExpressionIdentifier(simplescriptParser.ExpressionIdentifierContext ctx) {
        ExpressionIdentifier e = new ExpressionIdentifier();
        e.setId(ctx.ID().getText());
        e.setPosition(Position.getRulePosition(ctx));
        return e;
    }

    @Override
    public Node visitExpressionIdentifierArray(simplescriptParser.ExpressionIdentifierArrayContext ctx) {
        ExpressionIdentifierArray e = new ExpressionIdentifierArray();
        e.setId(ctx.ID().getText());
        e.setIndex((Expression) ctx.expression().accept(this));
        e.setPosition(Position.getRulePosition(ctx));
        return e;
    }

    @Override
    public Node visitInstructionReturn(simplescriptParser.InstructionReturnContext ctx) {
        InstructionReturn i = new InstructionReturn();
        if(ctx.expression() != null)
            i.setExpression((Expression) ctx.expression().accept(this));
        else
            i.setExpression(null);
        i.setPosition(Position.getRulePosition(ctx));
        return i;
    }

    @Override
    public Node visitInstructionVariableDeclaration(simplescriptParser.InstructionVariableDeclarationContext ctx) {
        InstructionVariableDeclaration i = new InstructionVariableDeclaration();
        i.setId(ctx.ID().getText());
        i.setType((ExpressionType) ctx.type().accept(this));
        if(ctx.expression() != null) i.setExpression((Expression) ctx.expression().accept(this));
        i.setPosition(Position.getRulePosition(ctx));
        return i;
    }

    @Override
    public Node visitInstructionVariableArrayDeclaration(simplescriptParser.InstructionVariableArrayDeclarationContext ctx) {
        InstructionVariableArrayDeclaration i = new InstructionVariableArrayDeclaration();
        i.setId(ctx.ID().getText());
        i.setType((ExpressionType) ctx.type().accept(this));
        i.setSize(Integer.parseInt(ctx.INT().getText()));
        List<Expression> values = new LinkedList<>();
        for(simplescriptParser.ExpressionContext e : ctx.expression()){
                values.add((Expression) e.accept(this));
        }
        i.setValues(values);
        i.setPosition(Position.getRulePosition(ctx));
        return i;
    }

    @Override
    public Node visitInstructionVariableAssign(simplescriptParser.InstructionVariableAssignContext ctx) {
        InstructionVariableAssign i = new InstructionVariableAssign();
        i.setId(ctx.ID().getText());
        i.setExpression((Expression) ctx.expression().accept(this));
        i.setPosition(Position.getRulePosition(ctx));
        return i;
    }

    @Override
    public Node visitInstructionVariableArrayAssign(simplescriptParser.InstructionVariableArrayAssignContext ctx) {
        InstructionVariableArrayAssign i = new InstructionVariableArrayAssign();
        i.setId(ctx.ID().getText());
        i.setIndex((Expression) ctx.expression(0).accept(this));
        i.setValue((Expression) ctx.expression(1).accept(this));
        i.setPosition(Position.getRulePosition(ctx));
        return i;
    }

    @Override
    public Node visitInstructionIf(simplescriptParser.InstructionIfContext ctx) {
        InstructionIf i = new InstructionIf();
        i.setCondition((Expression) ctx.expression().accept(this));
        i.setIfTrue((Instruction) ctx.instruction(0).accept(this));
        if(ctx.instruction().size() >= 2)
            i.setIfFalse((Instruction) ctx.instruction(1).accept(this));
        i.setPosition(Position.getRulePosition(ctx));
        return i;
    }

    @Override
    public Node visitInstructionWhile(simplescriptParser.InstructionWhileContext ctx) {
        InstructionWhile i = new InstructionWhile();
        i.setCondition((Expression) ctx.expression().accept(this));
        i.setIfTrue((Instruction) ctx.instruction().accept(this));
        i.setPosition(Position.getRulePosition(ctx));
        return i;
    }

    @Override
    public Node visitInstructionFor(simplescriptParser.InstructionForContext ctx) {
        InstructionFor i = new InstructionFor();
        i.setBody((Instruction) ctx.instruction(1).accept(this));
        i.setVarId(ctx.ID().getText());
        i.setVarType((ExpressionType) ctx.type().accept(this));
        Expression comparaison = (Expression) ctx.expression(1).accept(this);
        i.setComparaison(comparaison);
        i.setVarValue((Expression) ctx.expression(0).accept(this));
        i.setNext((Instruction) ctx.instruction(0).accept(this));
        i.setPosition(Position.getRulePosition(ctx));
        return i;
    }

    @Override
    public Node visitInstructionBlock(simplescriptParser.InstructionBlockContext ctx) {
        InstructionBlock i = new InstructionBlock();
        List<Instruction> instructions = new ArrayList<>();
        ctx.instruction().forEach(instruction -> instructions.add((Instruction) instruction.accept(this)));
        i.setInstructions(instructions);
        i.setPosition(Position.getRulePosition(ctx));
        return i;
    }

    @Override
    public Node visitFunction_parameter(simplescriptParser.Function_parameterContext ctx) {
        FunctionParameter p = new FunctionParameter();
        p.setId(ctx.ID().getText());
        p.setType((ExpressionType) ctx.type().accept(this));
        p.setPosition(Position.getRulePosition(ctx));
        return p;
    }

    @Override
    public Node visitFunction_declaration(simplescriptParser.Function_declarationContext ctx) {
        FunctionDeclaration d = new FunctionDeclaration();
        d.setId(ctx.ID().getText());
        d.setType((ExpressionType) ctx.type().accept(this));
        List<FunctionParameter> parameters = new ArrayList<>();
        ctx.function_parameter().forEach(p -> parameters.add((FunctionParameter) p.accept(this)));
        d.setParameters(parameters);
        d.setBody((Instruction) ctx.instruction().accept(this));
        d.setPosition(Position.getRulePosition(ctx));
        return d;
    }

    @Override
    public Node visitProgram(simplescriptParser.ProgramContext ctx) {
        Program p = new Program();
        List<Node> childrens = new ArrayList<>();
        ctx.children.forEach(child -> childrens.add(child.accept(this)));
        p.setChildrens(childrens);
        p.setPosition(Position.getRulePosition(ctx));
        return p;
    }
}
