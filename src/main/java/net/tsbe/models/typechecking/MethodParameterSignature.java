package net.tsbe.models.typechecking;

import net.tsbe.models.enums.VALUE_TYPE;
import net.tsbe.models.nodes.FunctionParameter;

public class MethodParameterSignature {
        
    private VALUE_TYPE parameterType;
    private String parameter;
    private FunctionParameter source;

    public MethodParameterSignature(VALUE_TYPE pType, String parameteString, FunctionParameter sParameter){
        this.parameterType = pType;
        this.parameter = parameteString;
        this.source = sParameter;
    }

    public VALUE_TYPE getParameterType() {
        return parameterType;
    }

    public String getParameter() {
        return parameter;
    }

    public FunctionParameter getSource() {
        return source;
    }

    

}
