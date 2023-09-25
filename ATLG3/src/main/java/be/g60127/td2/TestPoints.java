package be.g60127.td2;

public class TestPoints {
    public static void main(String[] args) {
        Point p = new ColoredPoint(2, 4, 0xFF0000FF);
        p.move(1, 2);
        System.out.println(p);
        System.out.println("x: " + p.getX());
        //ColoredPoint p2 = new Point(2, 4);
       // System.out.println("color : " + String.format("%08X", p.getColor()));
    }
}
