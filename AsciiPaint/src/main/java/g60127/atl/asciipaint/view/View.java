package g60127.atl.asciipaint.view;

import g60127.atl.asciipaint.model.Drawing;
import g60127.atl.asciipaint.model.Point;
import g60127.atl.asciipaint.model.Shape;

import java.util.List;
import java.util.Scanner;

public class View {

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
    public static String readInt(String message) {
        System.out.println();
        Scanner s = new Scanner(System.in);
        while (s.hasNextInt())
        System.out.println(message);
        return s.nextLine();
    }

    public static void displayHelp() {
        System.out.println();
        System.out.println("AsciiPaint commands:\n" +
                "- add circle <x> <y> [radius]\n" +
                "- play line: l <row> <col> <direction> <i1> <i2>...\n" +
                "- play plic-ploc : m <row1> <col1> <i1> [<row2> <col2> <i2>]...\n" +
                "- play first : f <direction> <i1> <i2>...\n" +
                "- pass : p\n" +
                "- display grid : grid\n" +
                "- display all commands : help \n" +
                "- bag size : size\n" +
                "   i : index in list of tiles (1 - 6) \n" +
                "   d : direction in l (left), r (right), u (up), d(down)\n");
    }


}
