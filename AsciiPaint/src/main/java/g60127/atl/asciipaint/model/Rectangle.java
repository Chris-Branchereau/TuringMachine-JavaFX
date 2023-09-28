package g60127.atl.asciipaint.model;

public class Rectangle extends ColoredShape implements Shape{
    private Point upperLeft;
    private double width;
    private double height;
    public Rectangle(char color) {
        super(color);
    }

    @Override
    public boolean isInside(Point p) {
        return false;
    }

    @Override
    public void move(double dx, double dy) {
    }

}
