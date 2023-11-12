package g60127.atl.asciipaint.model;

public  class Rectangle extends ColoredShape /*permits Square*/{
    private Point upperLeft;
    private double width;
    private double height;

    public Rectangle(Point upperLeft, double width, double height, char color) {
        super(color);
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
    }


    @Override
    public boolean isInside(Point p) {
        return p.getX() > upperLeft.getX() && p.getX() <= upperLeft.getX() + width
                && p.getY() > upperLeft.getY() && p.getY() <= upperLeft.getY() + height;
    }

    @Override
    public void move(double dx, double dy) {
        upperLeft.move(dx, dy);
    }

    @Override
    public Point getPoint() {
        return new Point(upperLeft);
    }
}
