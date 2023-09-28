package g60127.atl.asciipaint.model;

public class Circle extends ColoredShape implements Shape{
    private Point center;
    private double radius;

    public Circle(Point center, double radius, char color){
        super(color);
        this.center = center;
        this.radius = radius;
    }
    @Override
    public boolean isInside(Point p) {
        return false;
    }

    @Override
    public void move(double dx, double dy) {

    }


}
