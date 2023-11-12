package g60127.atl.asciipaint.commands;

import g60127.atl.asciipaint.model.AsciiPaint;

public class UnGroupCommand extends AsciiPaintCommand{
    private int index;
    public UnGroupCommand(AsciiPaint paint, int index) {
        super(paint);
        this.index = index;
    }

    @Override
    public void execute() {
        paint.unGroup(index);
    }

    @Override
    public void undo() {


    }

    @Override
    public void redo() {
        execute();
    }
}
