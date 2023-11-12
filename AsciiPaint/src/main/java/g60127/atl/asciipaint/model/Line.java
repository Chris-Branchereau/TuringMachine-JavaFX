package g60127.atl.asciipaint.model;

public final class Line extends ColoredShape {
    private Point firstPoint;
    private Point secondPoint;

    public Line(Point firstPoint, Point secondPoint, char color) {
        super(color);
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
    }

    @Override
    public boolean isInside(Point p) {
        double m = (secondPoint.getY() - firstPoint.getY())
                / (secondPoint.getX() - firstPoint.getX());
        return (Math.abs(m * p.getX() - p.getY() - m * firstPoint.getX()
                + firstPoint.getY())) / Math.sqrt(Math.pow(m, 2) + 1) < 0.5;
    }

    @Override
    public void move(double dx, double dy) {

        double x = dx - firstPoint.getX();
        double y =  dy - firstPoint.getY();
        double x1 = dx - secondPoint.getX();
        double y1 = dy - secondPoint.getY();
        firstPoint.move(firstPoint.getX() + x, firstPoint.getY() + y);
        secondPoint.move(secondPoint.getX() + x1, secondPoint.getY() + y1);
    }

    @Override
    public Point getPoint() {
        return new Point(firstPoint);
    }
}
