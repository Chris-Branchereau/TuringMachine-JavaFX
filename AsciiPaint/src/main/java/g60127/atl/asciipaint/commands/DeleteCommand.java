package g60127.atl.asciipaint.commands;

import g60127.atl.asciipaint.model.AsciiPaint;
import g60127.atl.asciipaint.model.Shape;

public class DeleteCommand extends AsciiPaintCommand{
    private int index;
    private Shape deletedShape;
    public DeleteCommand(AsciiPaint paint, int index) {
        super(paint);
        this.index = index;


    }

    @Override
    public void execute() {
        deletedShape = paint.getShape(index);
        paint.deleteShape(index);
    }



    @Override
    public void undo() {
        paint.addShape(deletedShape,index);
    }

    @Override
    public void redo() {
        execute();
    }
}
