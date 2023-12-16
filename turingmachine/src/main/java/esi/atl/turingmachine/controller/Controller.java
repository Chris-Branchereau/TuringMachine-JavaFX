package esi.atl.turingmachine.controller;


import esi.atl.turingmachine.model.ModelFacade;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


public abstract class Controller {

    protected final ModelFacade model;

    public Controller() {
        model = new ModelFacade();
    }

    public boolean isStarted(){
        return model.isGameStarted();
    }
    public void chooseProblem(int i){
        model.chooseProblem(i);
    }

}


