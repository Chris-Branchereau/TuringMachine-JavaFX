package g60127.atl.asciipaint.controller;

import g60127.atl.asciipaint.model.AsciiPaint;
import g60127.atl.asciipaint.view.View;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    private static AsciiPaint  paint = new AsciiPaint(50, 50);;
    private static boolean isStarted = true;

    public static void start() {
        while (isStarted) {
            String commandPattern = "(add)\s(circle)\s([0-" + 50 + "])\s([0-" + 50 + "])"
                    + "|(add)\s(rectangle)\s([0-" + 50 + "])\s([0-" + 50 + "])"
                    + "|(add)\s(square)\s([0-" + 50 + "])\s([0-" + 50 + "])"
                    + "(help)";

            Pattern pattern = Pattern.compile(commandPattern);
            Matcher matcher = pattern.matcher(View.readCommand("Enter a command (enter \"help\" to see all commands) : "));
            if (matcher.find()) {
                if (matcher.group(1) == "add"){

                }
                System.out.println(matcher.group(1));
            } else {
                System.out.println("non");
            }
        }
    }

    public static void main(String[] args) {
        paint.newRectangle(5, 4, 3, 2, 'c');
        paint.newRectangle(5, 5, 3, 2, 'v');
        paint.newSquare(15, 14, 4, 'r');
        paint.newCircle(25, 25, 5, 'g');
        paint.newCircle(27, 27, 5, 's');
        paint.newCircle(2, 25, 4, 'g');
        paint.display();
        start();
        //System.out.println((Math.pow(5,2)<=(Math.pow((15-20),2)+Math.pow((6-5),2)) && (Math.pow((15-20),2)+Math.pow((6-5),2))<=(Math.pow(5,2)+1)));


    }
}
