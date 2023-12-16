package esi.atl.turingmachine.model;

/**
 * Exceptions class for TuringMachine
 */
public class TuringException extends RuntimeException{
    public TuringException(){
        super();
    }
    public TuringException(String message){
        super(message);
    }
}
