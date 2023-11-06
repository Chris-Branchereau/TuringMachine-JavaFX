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
        boolean isInsideX;
        boolean isInsideY;
        if (firstPoint.getX() < secondPoint.getX()) {
            isInsideX = p.getX() >= firstPoint.getX()
                    && p.getX() <= secondPoint.getX();

        } else {
            isInsideX = p.getX() <= firstPoint.getX()
                    && p.getX() >= secondPoint.getX();
        }
        if (firstPoint.getY() < secondPoint.getY()){
            isInsideY = p.getY() >= firstPoint.getY()
                    && p.getY() <= secondPoint.getY();
        } else {
            isInsideY = p.getY() <= firstPoint.getY()
                    && p.getY() >= secondPoint.getY();
        }
        return isInsideX && isInsideY;
    }

    @Override
    public void move(double dx, double dy) {

    }
}
