package esi.atl.turingmachine.commands;

import esi.atl.turingmachine.model.ModelFacade;

public class EnterCodeCommand extends TuringMachineCommand {
    private int code;

    public EnterCodeCommand(ModelFacade model, int code) {
        super(model);
        this.code = code;
    }

    @Override
    public void execute() {
        model.setCode(code);
    }

    @Override
    public void undo() {
        model.setCode(000);
    }

    @Override
    public void redo() {
        execute();
    }
}
