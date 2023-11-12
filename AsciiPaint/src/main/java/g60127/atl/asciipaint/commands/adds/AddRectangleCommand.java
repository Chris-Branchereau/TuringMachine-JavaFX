package g60127.atl.asciipaint.commands.adds;

import g60127.atl.asciipaint.commands.AddCommand;
import g60127.atl.asciipaint.model.AsciiPaint;

public class AddRectangleCommand extends AddCommand {
    private int x,y;
    private double width,height;
    private char color;

    public AddRectangleCommand(AsciiPaint paint, int x, int y,
                               double width, double height, char color) {
        super(paint);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    @Override
    public void execute() {
        paint.newRectangle(x,y,width,height,color);
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
