package g60127.atl.asciipaint.model;

public final class ShapeComposite  extends ColoredShape{
    public ShapeComposite(char color) {
        super(color);
    }

    @Override
    public boolean isInside(Point p) {
        return false;
    }

    @Override
    public void move(double dx, double dy) {

    }

    @Override
    public Point getPoint() {
        return null;
    }
}
