package be.g60127.td2;

public class ColoredPoint extends Point {
    private int color; // A 32-bit integer of the form: 0xRRGGBBAA
// where AA represents the alpha value

    public ColoredPoint(double x, double y, int color) {
        this.color = color;
    }

    public int getColor() {
        return color;
    }

    @Override
    public String toString() {
        return super.toString() + " - " + String.format("%08X", color);
    }
}

