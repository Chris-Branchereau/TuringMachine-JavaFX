package g60127.atl.asciipaint.model;

public interface Shape {
    boolean isInside(Point p);
    void move(double dx, double dy);
    char getColor();
    void setColor(char color);
    Point getPoint();
}
