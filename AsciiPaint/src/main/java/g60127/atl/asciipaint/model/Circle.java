package g60127.atl.asciipaint.model;

public final class Circle extends ColoredShape{
    private Point center;
    private double radius;

    public Circle(Point center, double radius, char color){
        super(color);
        this.center = center;
        this.radius = radius;
    }
    @Override
    public boolean isInside(Point p) {
        return p.distanceTo(center) <= radius;

    }

    @Override
    public void move(double dx, double dy) {
        center.move(dx,dy);
    }

    @Override
    public Point getPoint() {
        return new Point(center);
    }
}
