package g60127.atl.asciipaint.commands;

public interface Command {
    void execute();
    void undo();
    void redo();
}
