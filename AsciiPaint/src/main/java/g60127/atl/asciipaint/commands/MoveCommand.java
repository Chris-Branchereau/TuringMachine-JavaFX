package g60127.atl.asciipaint.commands;

import g60127.atl.asciipaint.model.AsciiPaint;
import g60127.atl.asciipaint.model.Point;


public class MoveCommand extends AsciiPaintCommand {
    private int index, x, y;
    private Point old;

    public MoveCommand(AsciiPaint paint, int index, int x, int y) {
        super(paint);
        this.index = index;
        this.x = x;
        this.y = y;

    }

    @Override
    public void execute() {
        old = paint.getShape(index).getPoint();
        paint.move(index, x, y);
    }


    @Override
    public void undo() {
        paint.move(index, (int) old.getX(), (int) old.getY());
    }

    @Override
    public void redo() {
        execute();
    }
}