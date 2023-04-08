package net.tsbe.models.typechecking;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import net.tsbe.models.enums.VALUE_TYPE;
import net.tsbe.models.nodes.FunctionDeclaration;

public class MethodSignature {
    
    private List<MethodParameterSignature> params = new ArrayList<>();
    private VALUE_TYPE returnType = VALUE_TYPE.VOID;

    public MethodSignature(List<MethodParameterSignature> p, VALUE_TYPE t){
        this.params = p;
        this.returnType = t;
    }

    public List<MethodParameterSignature> getParams(){
        return params;
    }

    public VALUE_TYPE getReturnType(){
        return returnType;
    }

    public static MethodSignature signatureOf(FunctionDeclaration function){
        return new MethodSignature(function.getParameters().stream().map(p -> new MethodParameterSignature(p.getType().getEnumType(), p.getId(), p)).collect(Collectors.toList()), function.getType().getEnumType());
    }
}
