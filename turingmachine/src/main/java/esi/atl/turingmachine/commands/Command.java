package esi.atl.turingmachine.commands;

public interface Command {
    void execute();
    void undo();
    void redo();

}
