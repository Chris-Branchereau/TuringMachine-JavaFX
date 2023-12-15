package esi.atl.turingmachine.commands;

import esi.atl.turingmachine.model.ModelFacade;

public class SelectValidatorCommand extends TuringMachineCommand{
    private int validatorNB;
    public SelectValidatorCommand(ModelFacade model, int validatorNB){
        super(model);
        this.validatorNB = validatorNB;
    }
    @Override
    public void execute() {
        model.selectValidator(validatorNB);
    }

    @Override
    public void undo() {
        model.getValidator().get(validatorNB).setTested(false);
        model.removeLastValidator();
    }

    @Override
    public void redo() {
        execute();
    }
}
