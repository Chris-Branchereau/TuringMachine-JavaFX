package g60127.atl.asciipaint.view;

import g60127.atl.asciipaint.model.Drawing;
import g60127.atl.asciipaint.model.Point;
import g60127.atl.asciipaint.model.Shape;

import java.util.List;
import java.util.Scanner;

public class View {

    // @pbt don't displayShape but one char (2 chars)
    public static void displayShape(Shape shape) {
        boolean space = false;
        if (shape != null) {
            System.out.print(shape.getColor() + " ");
            space = true;
        }
        if (!space) System.out.print("  ");
    }

    public static void displayMessages(String... messages) {
        System.out.println();
        for (String message : messages) {
            System.out.println(message);
        }
    }

    public static String readCommand(String message) {
        System.out.println();
        Scanner s = new Scanner(System.in);
        System.out.println(message);
        return s.nextLine();
    }

    public static int readInt(String message) {
        System.out.println();
        Scanner s = new Scanner(System.in);
        while (!s.hasNextInt()){
            System.out.println(message);
            s.next();
        }
        return s.nextInt();
    }

    public static int readInt(String message, int min, int max) {
        System.out.println();
        Scanner s = new Scanner(System.in);
        System.out.println(message);
        while (!s.hasNextInt()) {
            System.out.println(message);
            s.next();
        }
        int n = s.nextInt();
        while (n < min || n > max) {
            System.out.println("Enter an integer between " + min + " and " + max);
            n = readInt(message, min,  max);
        }
        return n;
    }

    public static void displayHelp() {
        System.out.println();
        System.out.println("AsciiPaint commands:\n" +
                "- add circle <x> <y> <radius> <color>\n" +
                "- add rectangle <x> <y> <width> <height> <color>\n" +
                "- add square <x> <y> <side> <color>\n" +
                "- move [index] <new x> <new y>\n" +
                "- list : show the list of shapes added\n" +
                "- show : draw the shapes\n" +
                "- stop : stop the program\n" +
                "- help : show this message");
    }


}
