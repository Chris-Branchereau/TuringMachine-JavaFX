package esi.atl.turingmachine.model;

public class TuringException extends RuntimeException{
    public TuringException(){
        super();
    }
    public TuringException(String message){
        super(message);
    }
}
