package g60127.atl.asciipaint.commands.adds;

import g60127.atl.asciipaint.commands.AddCommand;
import g60127.atl.asciipaint.model.AsciiPaint;

public class AddLineCommand extends AddCommand {
    private int x,y;
    private int x1,y1;
    private char color;

    public AddLineCommand(AsciiPaint paint, int x, int y,
                          int x1, int y1, char color) {
        super(paint);
        this.x = x;
        this.y = y;
        this.x1 = x1;
        this.y1 = y1;
        this.color = color;
    }

    @Override
    public void execute() {
        paint.newLine(x,y,x1,y1,color);
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
