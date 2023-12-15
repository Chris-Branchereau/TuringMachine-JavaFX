package g60127.atl.asciipaint.controller;

import g60127.atl.asciipaint.commands.*;
import g60127.atl.asciipaint.commands.adds.AddCircleCommand;
import g60127.atl.asciipaint.commands.adds.AddLineCommand;
import g60127.atl.asciipaint.commands.adds.AddRectangleCommand;
import g60127.atl.asciipaint.commands.adds.AddSquareCommand;
import g60127.atl.asciipaint.model.AsciiPaint;
import g60127.atl.asciipaint.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    private static AsciiPaint paint;
    private static final List<Command> history = new ArrayList<Command>();
    private static int actualUndoCommand = 0;
    private static boolean isStarted = true;

    public static void start() {
        int width = View.readInt("Enter a width (between 1 and 199)", 1, 199);
        int height = View.readInt("Enter a height (between 1 and 199)", 1, 199);
        paint = new AsciiPaint(width, height);
        while (isStarted) {
            String commandPattern = """
                            (add)\s(circle|square)\s((1[0-9][0-9]|[1-9][0-9]|[0-9])\s){3}(.)
                            |(add)\s(rectangle|line)\s((1[0-9][0-9]|[1-9][0-9]|[0-9])\s){4}(.)
                            |(move)\s([0-9]|[0-9][0-9])\s(1[0-9][0-9]|[1-9][0-9]|[0-9])\s(1[0-9][0-9]|[1-9][0-9]|[0-9])
                            |(show)
                            |(list)
                            |(exit)
                            |(help)
                            |(undo)
                            |(redo)
                            |(delete)\s(1[0-9][0-9]|[1-9][0-9]|[0-9])
                            |(color)\s(1[0-9][0-9]|[1-9][0-9]|[0-9])\s(.)
                            |(group)\s((1[0-9][0-9]|[1-9][0-9]|[0-9])\s)+(1[0-9][0-9]|[1-9][0-9]|[0-9])
                            |(ungroup)\s(1[0-9][0-9]|[1-9][0-9]|[0-9])
                            """;

            Pattern pattern = Pattern.compile(commandPattern);
            Matcher matcher = pattern.matcher(View.readCommand(
                    "Enter a command (enter \"help\" to see all commands) : "));

            if (matcher.find()) {
                String[] commands = matcher.group(0).split("\s");
                switch (commands[0]) {
                    case "help" -> View.displayHelp();
                    case "list" -> View.displayMessages(paint.getList());
                    case "show" -> paint.display();
                    case "exit" -> isStarted = false;
                    case "add" -> {

                        if (commands[1].equalsIgnoreCase("rectangle")) {
                            executeCommand(new AddRectangleCommand(paint,
                                    Integer.parseInt(commands[2]),
                                    Integer.parseInt((commands[3])),
                                    Double.parseDouble(commands[4]),
                                    Double.parseDouble(commands[5]),
                                    commands[6].charAt(0)));

                        } else if (commands[1].equalsIgnoreCase("square")) {
                            executeCommand(new AddSquareCommand(paint,
                                    Integer.parseInt(commands[2]),
                                    Integer.parseInt((commands[3])),
                                    Double.parseDouble(commands[4]),
                                    commands[5].charAt(0)));
                        } else if (commands[1].equalsIgnoreCase("circle")) {
                            executeCommand(new AddCircleCommand(paint,
                                    Integer.parseInt(commands[2]),
                                    Integer.parseInt((commands[3])),
                                    Double.parseDouble(commands[4]),
                                    commands[5].charAt(0)));
                        } else if (commands[1].equalsIgnoreCase("line")) {
                            executeCommand(new AddLineCommand(paint,
                                    Integer.parseInt(commands[2]),
                                    Integer.parseInt((commands[3])),
                                    Integer.parseInt(commands[4]),
                                    Integer.parseInt(commands[5]),
                                    commands[6].charAt(0)));

                        }
                    }
                    case "move" -> executeCommand(new MoveCommand(paint,
                            Integer.parseInt(commands[1]),
                            Integer.parseInt(commands[2]),
                            Integer.parseInt(commands[3])));
                    case "undo" -> {
                        undoCommand();
                    }
                    case "redo" -> {
                        redoCommand();
                    }
                    case "delete" -> {
                        executeCommand(new DeleteCommand(paint,
                                Integer.parseInt(commands[1])));
                    }
                    case "color" -> {
                        executeCommand(new ColorCommand(paint,
                                Integer.parseInt(commands[1]),
                                commands[2].charAt(0)));
                    }
                    case "group" -> {
                        executeCommand(new GroupCommand(paint, getIndexes(commands)));
                    }
                    case "ungroup" -> {
                        executeCommand(new UnGroupCommand(paint,  Integer.parseInt(commands[1])));
                    }


                }

            } else {
                View.displayMessages("invalid command");
            }
        }
    }

    private static void executeCommand(Command command) {
        for (int i = history.size() - actualUndoCommand; i < history.size(); i++) {
            history.remove(i);
        }
        actualUndoCommand = 0;
        history.add(command);
        command.execute();
    }

    private static void undoCommand() {
        if (actualUndoCommand < history.size()) {
            actualUndoCommand++;
            Command toUndo = history.get(history.size() - actualUndoCommand);
            toUndo.undo();
        } else {
            View.displayMessages("0 undo found");
        }
    }

    private static int[] getIndexes(String[] commands) {
        int[] indexes = new int[commands.length - 1];
        for (int i = 0; i < indexes.length; i++) {
            indexes[i] = Integer.parseInt(commands[i + 1]);
        }
        return indexes;
    }

    private static void redoCommand() {
        if (actualUndoCommand > 0) {
            Command toRedo = history.get(history.size() - actualUndoCommand);
            toRedo.redo();
            actualUndoCommand--;
        } else {
            View.displayMessages("0 redo found");
        }
    }

    public static void main(String[] args) {
        start();
    }
}
