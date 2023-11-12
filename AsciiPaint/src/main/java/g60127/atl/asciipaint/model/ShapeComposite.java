package g60127.atl.asciipaint.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class ShapeComposite extends ShapeComponent{
    private List<Shape> components = new ArrayList<>();
    public ShapeComposite(Shape[] shapes){
        components.addAll(Arrays.asList(shapes));
    }
    public List<Shape> getComponents() {
        return Collections.unmodifiableList(components);
    }
    @Override
    public boolean isInside(Point p) {
        for(Shape shape: components){
            if(shape.isInside(p)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void move(double dx, double dy) {
        for(Shape shape: components){
            shape.move(dx, dy);
        }
    }

    @Override
    public char getColor() {
        return components.get(0).getColor();
    }

    @Override
    public void setColor(char color) {
        for(Shape shape: components){
            shape.setColor(color);
        }
    }

    @Override
    public Point getPoint() {
        return null;
    }
}
