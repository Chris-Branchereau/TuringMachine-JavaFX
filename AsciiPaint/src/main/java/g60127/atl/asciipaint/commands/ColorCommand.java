package g60127.atl.asciipaint.commands;

import g60127.atl.asciipaint.model.AsciiPaint;

public class ColorCommand extends AsciiPaintCommand{
    private int index;
    private char color;
    private char oldColor;
    public ColorCommand(AsciiPaint paint, int index, char color) {
        super(paint);
        this.index =index;
        this.color = color;
    }

    @Override
    public void execute() {
        oldColor = paint.getShape(index).getColor();
        paint.getShape(index).setColor(color);
    }



    @Override
    public void undo() {
        paint.getShape(index).setColor(oldColor);
    }

    @Override
    public void redo() {
        execute();
    }
}
