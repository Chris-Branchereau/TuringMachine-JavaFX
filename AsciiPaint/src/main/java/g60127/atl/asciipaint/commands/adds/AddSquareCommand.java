package g60127.atl.asciipaint.commands.adds;

import g60127.atl.asciipaint.commands.AddCommand;
import g60127.atl.asciipaint.model.AsciiPaint;

public class AddSquareCommand extends AddCommand {
    private int x,y;
    private double size;
    private char color;

    public AddSquareCommand(AsciiPaint paint, int x, int y, double size,
                            char color) {
        super(paint);
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;
    }

    @Override
    public void execute() {
        paint.newSquare(x,y,size,color);
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
