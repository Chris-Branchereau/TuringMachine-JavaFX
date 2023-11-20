package be.g60127.td5;

import java.util.ArrayList;
import java.util.List;

public class TestWildcardsList {
    public static void printList(List<?> list) {
        for (Object n : list) {
            System.out.println(n);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        //ArrayList<Point> list = new ArrayList<>();
        //ArrayList<Object> list = new ArrayList<>();
        list.add(44);
        list.add(42);
        list.add(43);
        printList(list);
    }
}
