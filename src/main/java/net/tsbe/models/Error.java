package net.tsbe.models;

public class Error {
    
    public Position position;
    public String message;
    public Node cause;

    public Error(Position position, String message, Node cause){
        this.position = position;
        this.message = message;
        this.cause = cause;
    }

}
