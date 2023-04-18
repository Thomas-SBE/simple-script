package net.tsbe.models.typechecking;

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

import net.tsbe.models.Error;
import net.tsbe.models.Instruction;
import net.tsbe.models.SimpleScriptBaseVisitor;
import net.tsbe.models.enums.VALUE_TYPE;
import net.tsbe.models.nodes.*;
import net.tsbe.utils.CompilatorDisplayer;

public class TypeChecker extends SimpleScriptBaseVisitor<VALUE_TYPE>{
	private SymbolTable table;
	private String currentMethod;
	private Stack<InstructionBlock> visitedBlocks;

	private List<Error> errors = new ArrayList<>();

	public Stack<InstructionBlock> getVisitedBlocks(){
		return visitedBlocks;
	}


	//Dans un second temps :
	//- Vérifiez que dans le corps de chaque méthode, une valeur
	//	du bon type est retournée (dans chaque branche des
	//	conditionnelles, en particulier).
	//
	//- Vérifiez pour chaque nœud qu’il est atteignable,
	//    c’est-à-dire qu’il ne vient pas après un 'return'. Sinon,
	//    levez une erreur.
	
	public TypeChecker(SymbolTable t){
		//le TypeChecker dépend de la table des symboles qui a
		//été créée à l’étape précédente, et est initialisé
		//avec le constructeur de la super classe, avec
		//statType comme élément par défaut, car c’est le type
		//renvoyé par un programme.
		visitedBlocks = new Stack<InstructionBlock>();
		visitedBlocks.add(t.getrBlock()); // Adding root block for global variables !
		this.table = t;
	}

	public void check(){
		//S’il y a des erreurs, sortir du programme principal. Sinon, ne
		//rien faire.
		if(errors.size() > 0){
			for(Error e : errors){
				CompilatorDisplayer.showGenericErrorMessage(CompilatorDisplayer.ERROR_CROSS_ICON, "[Line: "+e.position.getLineNumber()+", OFFSET: "+e.position.getLineOffset()+"] "+e.message, false, true);
			}
			System.exit(1);
		}
	}

	@Override
	public VALUE_TYPE visitExpressionIdentifier(ExpressionIdentifier ctx) {
		//retourner le type de l’identifiant correspondant, et
		//une erreur si non trouvé : la variable n’a pas été
		//déclarée auparavant (ou il y a un autre problème)
		VALUE_TYPE t = table.variableLookup(ctx.getId(), visitedBlocks);
		if(t != null){
			return t;
		}else{
			errors.add(new Error(ctx.getPosition(), "Trying to get variable "+ctx.getId()+ " but it was never declared or is out of reach !", ctx));
			return VALUE_TYPE.INVALID;
		}
	}

	@Override
	public VALUE_TYPE visitExpressionInteger(ExpressionInteger ctx) {
		//retourner le type int dans tous les cas
		return VALUE_TYPE.INTEGER;
	}

	@Override
	public VALUE_TYPE visitExpressionBoolean(ExpressionBoolean ctx) {
		return VALUE_TYPE.BOOLEAN;
	}

	@Override
	public VALUE_TYPE visitInstructionVariableAssign(InstructionVariableAssign ctx) {
		//affectation : récupérer le type de l’identifiant, le
		//type de l’expression, et s’assurer que les deux sont
		//identiques. Sinon, lever une erreur précise
		//(impossible d’affecter l’exp de type… à la var. de
		//type … ).
		//
		//retourner un type Instruction s’il n’y a pas
		//d’erreur
		VALUE_TYPE t = table.variableLookup(ctx.getId(), visitedBlocks);
		if(t != null){

			VALUE_TYPE val = ctx.getExpression().accept(this);
			if(t.equals(val)){
				return t;
			}else{
				errors.add(new Error(ctx.getPosition(), "Trying to assign type "+val+" but variable is of type "+t+" !", ctx));
				return VALUE_TYPE.INVALID;
			}

		}else{
			errors.add(new Error(ctx.getPosition(), "Trying to get variable "+ctx.getId()+ " but it was never declared or is out of reach !", ctx));
			return VALUE_TYPE.INVALID;
		}
	}

	@Override
	public VALUE_TYPE visitFunctionDeclaration(FunctionDeclaration ctx) {
		//visiter le bloc du corps de la méthode. (les paramètres
		//auront été intégrés à la table locale dans le
		//tableBuilder, donc on n’aura pas en s’en occuper
		//précisément ici).
		currentMethod = ctx.getId();
		if(ctx.getBody() instanceof InstructionBlock){
			InstructionBlock b = (InstructionBlock) ctx.getBody();
			visitedBlocks.add(b);
			VALUE_TYPE blockRet = b.accept(this);
			if(blockRet != table.methodLookup(currentMethod).getReturnType()){
				errors.add(new Error(ctx.getPosition(), String.format("The returned type of function %s is not equivalent to the method signature, got %s instead of %s.", currentMethod, blockRet, table.methodLookup(currentMethod).getReturnType()), ctx));
				return VALUE_TYPE.INVALID;
			}
			// errors.add(new Error(ctx.getPosition(), "Could not find the return statement required for function "+ctx.getId()+" !", ctx));
			currentMethod = null;
			visitedBlocks.pop();
			return VALUE_TYPE.INVALID;
		}else{
			currentMethod = null;
			return ctx.getBody().accept(this);
		}
	}

	@Override
	public VALUE_TYPE visitExpressionBinary(ExpressionBinary ctx) {
		// récupérer les deux types retournés par les sous
		// expressions visitées, vérifier qu’ils sont
		// identiques.
		//
		// Puis selon l’opérateur, vérifier que ce sont bien
		// ceux attendus.
		if(ctx.getLeft().accept(this) == ctx.getRight().accept(this)){
			switch (ctx.getOperation()){
				case AND, OR:
					if(ctx.getLeft().accept(this).equals(VALUE_TYPE.BOOLEAN)){ return VALUE_TYPE.BOOLEAN; }
					else{errors.add(new Error(ctx.getPosition(), "Cannot use "+ ctx.getOperator() +" without 2 booleans !", ctx)); return VALUE_TYPE.INVALID; }
				case EQUALS, LESS, LESS_OR_EQUALS, SUPERIOR, SUP_OR_EQUALS, DIFFERENT:
					if(ctx.getLeft().accept(this).equals(VALUE_TYPE.INTEGER)){ return VALUE_TYPE.BOOLEAN; }
					else{errors.add(new Error(ctx.getPosition(), "Cannot use "+ ctx.getOperator() +" without 2 integers !", ctx)); return VALUE_TYPE.INVALID; }
				default:
					if(ctx.getLeft().accept(this).equals(VALUE_TYPE.INTEGER)){ return VALUE_TYPE.INTEGER; }
					else{errors.add(new Error(ctx.getPosition(), "Cannot use "+ ctx.getOperator() +" without 2 integers !", ctx)); return VALUE_TYPE.INVALID; }
			}
		}
		else{
			errors.add(new Error(ctx.getPosition(), "Cannot apply binary operation between 2 values of different types !", ctx));
			return VALUE_TYPE.INVALID;
		}
	}

	@Override
	public VALUE_TYPE visitExpressionUnary(ExpressionUnary ctx) {
		return ctx.getExpression().accept(this);
	}

	@Override
	public VALUE_TYPE visitExpressionFunctionCall(ExpressionFunctionCall ctx) {
		// plus compliqué : vérifier que le nombre de
		// paramètres est bien celui attendu, et qu’ils sont
		// tous du bon type. Commencer par récupérer la
		// signature de la méthode dans la table des symboles.
		// Si elle n’y est pas , c’est que la méthode n’a pas
		// été déclarée, ou qu’il y a un autre problème.

		MethodSignature method = table.methodLookup(ctx.getId());

		// Vérification du nombre de paramètres.
		if(ctx.getParameters().size() != method.getParams().size()) {
			errors.add(new Error(ctx.getPosition(), "Function "+ctx.getId()+" requires "+method.getParams().size()+" but "+ctx.getParameters().size()+" were given.", ctx));
			return VALUE_TYPE.INVALID;
		}

		// Checking if each parameter has correct signature match.
		for(int i = 0; i < method.getParams().size(); i++){
			VALUE_TYPE result = ctx.getParameters().get(i).accept(this);
			if(!method.getParams().get(i).getParameterType().equals(result)){
				errors.add(new Error(ctx.getPosition(), String.format("Function parameter at index %d:%s requires to be %s but instead got %s.", i, method.getParams().get(i).getParameter(), method.getParams().get(i).getParameterType(), result), ctx));
				return VALUE_TYPE.INVALID;
			}
		}

		return method.getReturnType();
	}

	@Override
	public VALUE_TYPE visitInstructionReturn(InstructionReturn ctx) {
		//visiter l’expression retournée
		//
		//Si vous vérifiez qu’une méthode renvoie toujours
		//quelque chose, faites une mise à jour ici.
		return ctx.getExpression().accept(this);
	}

	@Override
	public VALUE_TYPE visitInstructionIf(InstructionIf ctx) {
		//pour le typage : visiter tous les blocs, et vérifier
		//que la condition est de type bool.
		//
		//pour vérifier qu’une méthode renvoie toujours
		//quelque chose : si les deux blocs retournent une
		//valeur, faire une mise à jour.

		// Verifying boolean condition
		VALUE_TYPE condType = ctx.getCondition().accept(this);
		if(condType != VALUE_TYPE.BOOLEAN){
			errors.add(new Error(ctx.getPosition(), String.format("If condition is expected to be of type BOOLEAN, got %s.", condType), ctx));
			return VALUE_TYPE.INVALID;
		}

		VALUE_TYPE returnedType = VALUE_TYPE.VOID;

		// Check If True/False return value type
		VALUE_TYPE ifTrType = ctx.getIfTrue().accept(this);
		VALUE_TYPE ifFalsType = null;

		if(ctx.getIfFalse() != null){
			ifFalsType = ctx.getIfFalse().accept(this);
		}

		if(ifFalsType != null){
			if(ifFalsType != VALUE_TYPE.VOID && ifTrType != VALUE_TYPE.VOID && ifTrType != ifFalsType){
				errors.add(new Error(ctx.getPosition(), String.format("If blocks return different types: %s & %s.", ifTrType, ifFalsType), ctx));
				return VALUE_TYPE.INVALID;
			}
			if(returnedType == VALUE_TYPE.VOID){
				returnedType = ifFalsType;
			}
		}

		return ifTrType;
	}

	@Override
	public VALUE_TYPE visitInstructionWhile(InstructionWhile ctx) {
		// Verifying boolean condition
		VALUE_TYPE condType = ctx.getCondition().accept(this);
		if(condType != VALUE_TYPE.BOOLEAN){
			errors.add(new Error(ctx.getPosition(), String.format("While condition is expected to be of type BOOLEAN, got %s.", condType), ctx));
			return VALUE_TYPE.INVALID;
		}

		return ctx.getIfTrue().accept(this);
	}

	@Override
	public VALUE_TYPE visitInstructionFor(InstructionFor ctx) {
		// Verifying boolean condition
		VALUE_TYPE condType = ctx.getComparaison().accept(this);
		if(condType != VALUE_TYPE.BOOLEAN){
			errors.add(new Error(ctx.getPosition(), String.format("For condition is expected to be of type BOOLEAN, got %s.", condType), ctx));
			return VALUE_TYPE.INVALID;
		}

		return ctx.getBody().accept(this);
	}

	@Override
	public VALUE_TYPE visitInstructionBlock(InstructionBlock ctx) {
		//utiliser la méthode de visite de la super classe,
		//mais ne pas oublier de noter dans la pile l’entrée
		//et la sortie du bloc !
		
		if(currentMethod == null) return VALUE_TYPE.VOID;

		visitedBlocks.add(ctx);
		for(Instruction i : ctx.getInstructions()){
			if(i instanceof InstructionReturn) return i.accept(this);
			if(i instanceof InstructionIf || i instanceof InstructionFor || i instanceof InstructionWhile) {
				VALUE_TYPE ret = i.accept(this);
				if(ret != VALUE_TYPE.VOID) return ret;
			}
		}
		visitedBlocks.pop();
		
		return VALUE_TYPE.VOID;
	}

}
	

