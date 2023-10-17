package g60127.atl.asciipaint.model;

import g60127.atl.asciipaint.view.View;

public class AsciiPaint {
    private Drawing drawing;

    public AsciiPaint() {

    }

    public AsciiPaint(int width, int height) {
        this.drawing = new Drawing(width, height);

    }

    public void display() {
        for (int i = 0; i < drawing.getHeight() + 1; i++) {
            if (i < 10 ) System.out.print(" ");
            for (int j = 0; j < drawing.getWidth(); j++) {
                View.displayShape(drawing.getShapeAt(new Point(j, i)));
                if (i == 0) System.out.print(j);
                if (j == 0) System.out.print(i);
            }
            View.displayMessages();
        }
    }

    public void newCircle(int x, int y, double radius, char color) {
        if (x <= 0 || x > drawing.getWidth() || y <= 0 || y > drawing.getHeight() || radius > drawing.getWidth() || radius > drawing.getHeight() || radius <= 0)
            View.displayMessages("Invalid Cicrle");
        else
            drawing.addShape(new Circle(new Point(x, y), radius, color));
    }

    public void newRectangle(int x, int y, double width, double height, char color) {
        if (x <= 0 || x > drawing.getWidth() || y <= 0 || y > drawing.getHeight() || width > drawing.getWidth() || height > drawing.getHeight() || width <= 0 || height <= 0)
            View.displayMessages("Invalid Rectangle");
        else
            drawing.addShape(new Rectangle(new Point(x, y), width, height, color));
    }

    public void newSquare(int x, int y, double side, char color) {
        if (x <= 0 || x > drawing.getWidth() || y <= 0 || y > drawing.getHeight() || side > drawing.getWidth() || side > drawing.getHeight() || side <= 0)
            View.displayMessages("Invalid Square");

        else
            drawing.addShape(new Square(new Point(x, y), side, color));
    }

    public void move(int index, int x, int y) {
        // @pbt write always {}
        if (x <= 0 || x > drawing.getWidth() || y <= 0 || y > drawing.getHeight())
            View.displayMessages("Invalid position");
        else

            drawing.move(index, x, y);
    }

    public String getList() {
        return drawing.getShapeList();
    }

    public String asAscii() {
        return ""; // @pbt ?
    }
}
