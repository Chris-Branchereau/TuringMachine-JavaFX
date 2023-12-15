package esi.atl.turingmachine.commands;

import esi.atl.turingmachine.model.ModelFacade;

public abstract class TuringMachineCommand implements Command {
    protected ModelFacade model;
    public TuringMachineCommand(ModelFacade model){
        this.model = model;
    }
}
