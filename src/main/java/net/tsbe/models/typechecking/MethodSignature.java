package net.tsbe.models.typechecking;

import java.util.ArrayList;
import java.util.List;

import net.tsbe.models.enums.VALUE_TYPE;
import net.tsbe.models.nodes.FunctionDeclaration;
import net.tsbe.models.nodes.FunctionParameter;

public class MethodSignature {
    
    private List<FunctionParameter> params = new ArrayList<>();
    private VALUE_TYPE returnType = VALUE_TYPE.VOID;

    public MethodSignature(List<FunctionParameter> p, VALUE_TYPE t){
        this.params = List.copyOf(p);
        this.returnType = t;
    }

    public List<FunctionParameter> getParams(){
        return params;
    }

    public VALUE_TYPE getReturnType(){
        return returnType;
    }

    public static MethodSignature signatureOf(FunctionDeclaration function){
        return new MethodSignature(function.getParameters(), function.getType());
    }
}
