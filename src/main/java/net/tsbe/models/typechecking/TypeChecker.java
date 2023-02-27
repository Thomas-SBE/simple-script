package net.tsbe.models.typechecking;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

import net.tsbe.models.Error;
import net.tsbe.models.Instruction;
import net.tsbe.models.SimpleScriptBaseVisitor;
import net.tsbe.models.enums.VALUE_TYPE;
import net.tsbe.models.nodes.ExpressionBinary;
import net.tsbe.models.nodes.ExpressionBoolean;
import net.tsbe.models.nodes.ExpressionFunctionCall;
import net.tsbe.models.nodes.ExpressionIdentifier;
import net.tsbe.models.nodes.ExpressionInteger;
import net.tsbe.models.nodes.ExpressionUnary;
import net.tsbe.models.nodes.FunctionDeclaration;
import net.tsbe.models.nodes.InstructionBlock;
import net.tsbe.models.nodes.InstructionIf;
import net.tsbe.models.nodes.InstructionReturn;
import net.tsbe.models.nodes.InstructionVariableAssign;
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
		this.table = t;
	}

	public void check(){
		//S’il y a des erreurs, sortir du programme principal. Sinon, ne
		//rien faire.
		if(errors.size() > 0){
			for(Error e : errors){
				CompilatorDisplayer.showGenericErrorMessage(CompilatorDisplayer.ERROR_CROSS_ICON, "[Line: "+e.position.getLineNumber()+", OFFSET: "+e.position.getLineOffset()+"] "+e.message, false, false);
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
			if(t == val){
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
		if(ctx.getType() == VALUE_TYPE.VOID) return VALUE_TYPE.VOID;
		if(ctx.getBody() instanceof InstructionBlock){
			InstructionBlock b = (InstructionBlock) ctx.getBody();
			for(Instruction i : b.getInstructions()){
				if(i instanceof InstructionReturn) return i.accept(this);
			}
			errors.add(new Error(ctx.getPosition(), "Could not find the return statement required for function "+ctx.getId()+" !", ctx));
			return VALUE_TYPE.INVALID;
		}else{
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
		if(ctx.getLeft().accept(this) == ctx.getRight().accept(this)) return ctx.getLeft().accept(this);
		else{
			errors.add(new Error(ctx.getPosition(), "Cannot apply binary operation between 2 values of different types !", ctx));
			return VALUE_TYPE.INVALID;
		}
	}

	@Override
	public VALUE_TYPE visitExpressionUnary(ExpressionUnary ctx) {
		return ctx.getExpression().accept(this);
	}

	// TODO: From this point on, continue implementation of type checking !

	@Override
	public VALUE_TYPE visitExpressionFunctionCall(ExpressionFunctionCall ctx) {
		// plus compliqué : vérifier que le nombre de
		// paramètres est bien celui attendu, et qu’ils sont
		// tous du bon type. Commencer par récupérer la
		// signature de la méthode dans la table des symboles.
		// Si elle n’y est pas , c’est que la méthode n’a pas
		// été déclarée, ou qu’il y a un autre problème.
		return super.visitExpressionFunctionCall(ctx);
	}

	@Override
	public VALUE_TYPE visitInstructionReturn(InstructionReturn ctx) {
		//visiter l’expression retournée
		//
		//Si vous vérifiez qu’une méthode renvoie toujours
		//quelque chose, faites une mise à jour ici.
		return super.visitInstructionReturn(ctx);
	}

	@Override
	public VALUE_TYPE visitInstructionIf(InstructionIf ctx) {
		//pour le typage : visiter tous les blocs, et vérifier
		//que la condition est de type bool.
		//
		//pour vérifier qu’une méthode renvoie toujours
		//quelque chose : si les deux blocs retournent une
		//valeur, faire une mise à jour.
		return super.visitInstructionIf(ctx);
	}

	@Override
	public VALUE_TYPE visitInstructionBlock(InstructionBlock ctx) {
		//utiliser la méthode de visite de la super classe,
		//mais ne pas oublier de noter dans la pile l’entrée
		//et la sortie du bloc !
		return super.visitInstructionBlock(ctx);
	}

}
	

