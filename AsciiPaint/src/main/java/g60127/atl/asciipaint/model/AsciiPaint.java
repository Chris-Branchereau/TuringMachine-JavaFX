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
            for (int j = 0; j < drawing.getWidth(); j++) {
                View.displayShape(drawing.getShapeAt(new Point(j, i)));
            }
            View.displayMessages();
        }
    }
    public void addShape(Shape shape, int index){
        drawing.addShape(shape, index);
    }

    public void newCircle(int x, int y, double radius, char color) {
        if (x <= 0 || x > drawing.getWidth() || y <= 0 || y > drawing.getHeight()
                || radius > drawing.getWidth() || radius > drawing.getHeight()
                || radius <= 0) {

            View.displayMessages("Invalid Cicrle");
        } else {

            drawing.addShape(new Circle(new Point(x, y), radius, color));
        }
    }

    public void newRectangle(int x, int y, double width, double height, char color) {
        if (x <= 0 || x > drawing.getWidth() || y <= 0 || y > drawing.getHeight()
                || width > drawing.getWidth() || height > drawing.getHeight()
                || width <= 0 || height <= 0) {
            View.displayMessages("Invalid Rectangle");
        } else {

            drawing.addShape(new Rectangle(new Point(x, y), width, height, color));
        }
    }

    public void newSquare(int x, int y, double side, char color) {
        if (x <= 0 || x > drawing.getWidth() || y <= 0 || y > drawing.getHeight()
                || side > drawing.getWidth() || side > drawing.getHeight()
                || side <= 0) {
            View.displayMessages("Invalid Square");
        } else {
            drawing.addShape(new Square(new Point(x, y), side, color));
        }
    }

    public void newLine(int x, int y, int x1, int y1, char color) {
        if (x <= 0 || x > drawing.getWidth() || y <= 0 || y > drawing.getHeight()
                || x1 <= 0 || x1 > drawing.getWidth()
                || y1 <= 0 || y1 > drawing.getHeight()) {
            View.displayMessages("Invalid Line");
        } else {
            drawing.addShape(new Line(new Point(x, y), new Point(x1, y1), color));
        }
    }

    public void newGroup(Shape[] shapes){
        drawing.addShape(new ShapeComposite(shapes));
    }
    public void unGroup(int index){
        try{
            ShapeComposite shape = (ShapeComposite) getShape(index);
            for (Shape shape1 : shape.getComponents())
            drawing.addShape(shape1);
            drawing.deleteShape(index);
        } catch (Exception e){
            View.displayMessages("Not a group");
        }

    }

    public void move(int index, int x, int y) {
        if (x <= 0 || x > drawing.getWidth() || y <= 0 || y > drawing.getHeight())
            View.displayMessages("Invalid position");
        else {
            drawing.move(index, x, y);
        }

    }
    public void deleteShape(int index){
        drawing.deleteShape(index);
    }
    public Shape getShape(int index) {
        return drawing.getShape(index);
    }
    public int getShapeListSize(){
        return drawing.getShapesSize();
    }

    public String getList() {
        return drawing.getShapeList();
    }

    public String asAscii() {
        return "";
    }
}
