package be.g60127.td5;

import be.g60127.td2.Point;

import java.util.ArrayList;
import java.util.List;

public class TestMethod {
    public static <T> List<T> arrayToList(T[] t) {
        List<T> list = new ArrayList<>();
        for (T element : t) list.add(element);
        return list;
    }

    public static void main(String[] args) {
        Point[] points = {new Point(), new Point(1, 2)};
        List<Point> list = TestMethod.<Point>arrayToList(points);
    }
}

