package g60127.atl.asciipaint.model;

public class AsciiPaint {
    private Drawing drawing = new Drawing();

    public AsciiPaint() {

    }

    public AsciiPaint(int width, int height) {
        this.drawing = new Drawing(width, height);

    }
    public void display(){
        drawing.display();
    }

    public void newCircle(int x, int y, double radius, char color) {
        drawing.addShape(new Circle(new Point(x, y), radius, color));
    }

    public void newRectangle(int x, int y, double width, double height, char color) {
        drawing.addShape(new Rectangle(new Point(x, y), width, height, color));
    }

    public void newSquare(int x, int y, double side, char color) {
        drawing.addShape(new Square(new Point(x,y),side,color));
    }

    public String asAscii() {
        return "";
    }
}
