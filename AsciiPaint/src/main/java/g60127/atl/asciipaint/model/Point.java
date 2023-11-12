package g60127.atl.asciipaint.model;

public class Point {
    private double x;
    private double y;
    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }
    public Point(Point p){
        this.x = p.x;
        this.y = p.y;
    }
    public void move(double dx, double dy){
        this.x = dx;
        this.y = dy;
    }
    public double distanceTo(Point other){
        return Math.sqrt(Math.pow(this.x - other.x,2)
                + Math.pow(this.y - other.y,2));
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
