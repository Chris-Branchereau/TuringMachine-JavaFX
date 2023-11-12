package g60127.atl.asciipaint.model;

import g60127.atl.asciipaint.view.View;

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
    public void addShape(Shape shape, int index) {
        shapes.add(index, shape);
    }

    public Shape getShapeAt(Point p) {
        for (int f = shapes.size() - 1; f >= 0; f--) {
            if (shapes.get(f).isInside(p)) {
                return shapes.get(f);
            }
        }
        return null;
    }

    public String getShapeList() {
        String list = "Shapes : ";
        for (int f = 0; f < shapes.size(); f++) {
            list += shapes.get(f).getColor() + ", ";
        }
        return list;
    }

    public void move(int index, int x, int y) {
        if (index >= 0 && index < shapes.size())
            shapes.get(index).move(x, y);
        else View.displayMessages("Invalid index");
    }
    public void deleteShape(int index){
        shapes.remove(index);
    }
    public Shape getShape(int index){
        if (index >= 0 && index< shapes.size() ) {
            return shapes.get(index);
        }
        else {
            return null;
        }
    }
    public int getShapesSize(){
        return shapes.size();
    }

    int getHeight() {
        return this.height;
    }

    int getWidth() {
        return this.width;
    }
}
