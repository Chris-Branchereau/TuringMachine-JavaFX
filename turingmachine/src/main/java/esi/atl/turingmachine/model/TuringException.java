package esi.atl.turingmachine.model;

import esi.atl.turingmachine.view.ViewConsole;

public class TuringException extends RuntimeException{
    public TuringException(){
        super();
    }
    public TuringException(String message){
        super(message);
    }
}
