package g60127.atl.asciipaint.commands;

import g60127.atl.asciipaint.model.AsciiPaint;
import g60127.atl.asciipaint.model.Shape;
import g60127.atl.asciipaint.model.ShapeComposite;

public class GroupCommand extends AsciiPaintCommand {
    private int[] indexes;
    public GroupCommand(AsciiPaint paint, int[] indexes) {
        super(paint);
        this.indexes = indexes;
    }

    @Override
    public void execute() {
        int n = 0;
        Shape[] shapes = new Shape[indexes.length];
        for (int i = 0; i < shapes.length; i++){
            shapes[i] = paint.getShape(indexes[i]-n);
            paint.deleteShape(indexes[i]-n);
            n++;
        }
        paint.newGroup(shapes);

    }



    @Override
    public void undo() {
        paint.unGroup(paint.getShapeListSize()-1);
    }

    @Override
    public void redo() {
        execute();
    }
}
