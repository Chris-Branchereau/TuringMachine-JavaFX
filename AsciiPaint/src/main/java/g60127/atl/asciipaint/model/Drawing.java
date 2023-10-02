package g60127.atl.asciipaint.model;

import java.util.ArrayList;
import java.util.List;

public class Drawing {
    private List<Shape> shapes = new ArrayList<>();
    private int height;
    private int width;

    public Drawing() {

    }

    public Drawing(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    public Shape getShapeAt(Point p) {
        for (int f = shapes.size()-1; f >= 0; f--){
            if (shapes.get(f).isInside(p)){
                return shapes.get(f);
            }
        }
        return null;
    }

    int getHeight() {
        return this.height;
    }

    int getWidth() {
        return this.width;
    }
}
