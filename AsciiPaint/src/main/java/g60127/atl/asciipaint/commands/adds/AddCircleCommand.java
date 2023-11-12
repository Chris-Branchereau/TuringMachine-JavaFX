package g60127.atl.asciipaint.commands.adds;

import g60127.atl.asciipaint.commands.AddCommand;
import g60127.atl.asciipaint.model.AsciiPaint;

public class AddCircleCommand extends AddCommand {
    private int x,y;
    private double radius;
    private char color;

    public AddCircleCommand(AsciiPaint paint, int x, int y, double radius,
                            char color) {
        super(paint);
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;
    }

    @Override
    public void execute() {
        paint.newCircle(x,y,radius,color);
    }



    @Override
    public void undo() {
        paint.deleteShape(paint.getShapeListSize()-1);
    }

    @Override
    public void redo() {
        execute();
    }
}
