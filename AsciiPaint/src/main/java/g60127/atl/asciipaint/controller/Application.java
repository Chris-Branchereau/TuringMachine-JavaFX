package g60127.atl.asciipaint.controller;

import g60127.atl.asciipaint.model.AsciiPaint;
import g60127.atl.asciipaint.view.View;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    private static AsciiPaint paint;
    ;
    private static boolean isStarted = true;

    public static void start() {
        int width = View.readInt("Enter a width (between 1 and 199)", 1, 199);
        int height = View.readInt("Enter a height (between 1 and 199)", 1, 199);
        paint = new AsciiPaint(width, height);
        while (isStarted) {
            String commandPattern = "(add)\s(circle|square)\s(1[0-9][0-9]|[1-9][0-9]|[0-9])\s(1[0-9][0-9]|[1-9][0-9]|[0-9])\s(1[0-9][0-9]|[1-9][0-9]|[0-9])\s(.)"
                    + "|(add)\s(rectangle)\s(1[0-9][0-9]|[1-9][0-9]|[0-9])\s(1[0-9][0-9]|[1-9][0-9]|[0-9])\s(1[0-9][0-9]|[1-9][0-9]|[0-9])\s(1[0-9][0-9]|[1-9][0-9]|[0-9])\s(.)"
                    + "|(move)\s([0-9]|[0-9][0-9])\s(1[0-9][0-9]|[1-9][0-9]|[0-9])\s(1[0-9][0-9]|[1-9][0-9]|[0-9])"
                    + "|(show)"
                    + "|(list)"
                    + "|(stop)"
                    + "|(help)";

            Pattern pattern = Pattern.compile(commandPattern);
            Matcher matcher = pattern.matcher(View.readCommand("Enter a command (enter \"help\" to see all commands) : "));

            if (matcher.find()) {
                String[] commands = matcher.group(0).split(" ");
                switch (commands[0]) {
                    case "help" -> View.displayHelp();
                    case "list" -> View.displayMessages(paint.getList());
                    case "show" -> paint.display();
                    case "stop" -> isStarted = false;
                    case "add" -> {

                        if (commands[1].equalsIgnoreCase("rectangle")) {
                            paint.newRectangle(Integer.parseInt(commands[2]), Integer.parseInt((commands[3])), Double.parseDouble(commands[4]), Double.parseDouble(commands[5]), commands[6].charAt(0));
                        } else if (commands[1].equalsIgnoreCase("square"))
                            paint.newSquare(Integer.parseInt(commands[2]), Integer.parseInt((commands[3])), Double.parseDouble(commands[4]), commands[5].charAt(0));
                        else if (commands[1].equalsIgnoreCase("circle"))
                            paint.newCircle(Integer.parseInt(commands[2]), Integer.parseInt((commands[3])), Double.parseDouble(commands[4]), commands[5].charAt(0));
                    }
                    case "move" -> {
                        paint.move(Integer.parseInt(commands[1]), Integer.parseInt(commands[2]), Integer.parseInt(commands[3]));
                    }


                }

            } else {
                View.displayMessages("invalid command");
            }
        }
    }

    public static void main(String[] args) {
        start();
    }
}
