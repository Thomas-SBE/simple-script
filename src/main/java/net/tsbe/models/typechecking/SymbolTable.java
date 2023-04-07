package net.tsbe.models.typechecking;

import java.util.Map;
import java.util.HashMap;
import java.util.Stack;

import net.tsbe.models.enums.VALUE_TYPE;
import net.tsbe.models.nodes.InstructionBlock;

public class SymbolTable {
	//pour les fonctions : 
	private Map<String,MethodSignature> methods;
	//pour les blocs : chaque bloc
	// est associé à sa table locale.
	private Map<InstructionBlock,Map<String,VALUE_TYPE>> blocks;
	private InstructionBlock rBlock; // Root block for global variables in program.

	public SymbolTable(){
		methods = new HashMap<>();
		blocks = new HashMap<>();
	}

	public Map<InstructionBlock, Map<String, VALUE_TYPE>> getBlocks() {
		return blocks;
	}

	public InstructionBlock getrBlock() {
		return rBlock;
	}



	public void setrBlock(InstructionBlock rBlock) {
		this.rBlock = rBlock;
	}



	public void addMethod(String nom, MethodSignature ms){
		methods.put(nom, ms);
	}

	public void addLocalVariable(InstructionBlock block, String nom, VALUE_TYPE type){
		blocks.get(block).put(nom, type);
	}
	public void localTable(InstructionBlock b){
		//Ajoute la table locale du block b
		if(blocks.get(b)==null){
			Map<String,VALUE_TYPE> localT =new HashMap<>();
			blocks.put(b,localT);
		}
	}

	public MethodSignature methodLookup(String name){
		return methods.get(name);
	}
	
	public VALUE_TYPE variableLookup(String name, Stack<InstructionBlock> visitedBlocks){
		//retourne le type d’une variable, dans un historique
		//de blocs donné. Lève une erreur si le bloc, n’est
		//pas associé à une table locale, mais peut retourner
		//null (sans forcément lever une erreur si l’on n’a
		//pas trouvé de type).
		for(InstructionBlock b : visitedBlocks){
			if(blocks.get(b).containsKey(name)){
				return blocks.get(b).get(name);
			}
		}
		return null;
	}


}
