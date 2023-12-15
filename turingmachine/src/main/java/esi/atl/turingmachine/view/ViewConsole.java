package esi.atl.turingmachine.view;


import esi.atl.turingmachine.model.Problem;
import esi.atl.turingmachine.model.validators.Validator;

import java.util.List;
import java.util.Scanner;

public class ViewConsole {
    public static final String COLOR_RESET = "\u001B[0m";
    public static final String COLOR_RED = "\u001B[31m";


    public static void displayProblems(List<Problem> problems) {
        for (int i = 0; i < problems.size(); i++) {
            Problem problem = problems.get(i);
            System.out.println(problem.getNum() + ": difficulty = "
                    + problem.getDifficulty() + " luck = " + problem.getLuck());
        }

    }

    public static void displayScore(){

    }

    public static void displayValidator(List<Validator> validators) {
        System.out.println("List of Validator");
        for (int i = 0; i < validators.size(); i++) {
            Validator validator = validators.get(i);
            System.out.print(i + ": " + validator.getNumber() + " ");
            if (validator.isTested()) {
                if (validator.isValid()) System.out.print("V");
                else System.out.print("X");
            }
            System.out.println();
        }
    }

    /**
     * display an error
     *
     * @param message explanation of the error
     */
    public static void displayError(String message) {
        System.out.println();
        System.out.println(COLOR_RED + "Turing Machine error : "
                + message + COLOR_RESET);

    }

    /**
     * Read an integer from input
     *
     * @param message to print in console
     * @return
     */
    public static int readInt(String message) {
        System.out.println();
        Scanner s = new Scanner(System.in);
        while (!s.hasNextInt()) {
            System.out.println(message);
            s.next();
        }
        return s.nextInt();
    }

    /**
     * Read an integer from input between min and max
     *
     * @param message to print in console
     * @param min     minimum
     * @param max     maximum
     * @return
     */
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
            n = readInt(message, min, max);
        }
        return n;
    }


    public static int readProblem(String message, int min, int max) {
        System.out.println();
        Scanner s = new Scanner(System.in);
        System.out.println(message);
        String read = "";
        while (!s.hasNextInt()) {
            read = s.next();
            if (read.equalsIgnoreCase("random")) return 0;
            System.out.println(message);
        }
        int n = s.nextInt();
        while (n < min || n > max) {
            System.out.println("Enter an integer between " + min + " and " + max);
            n = readProblem(message, min, max);
        }
        return n;
    }

    public static String readCommand(String message) {
        System.out.println();
        Scanner s = new Scanner(System.in);
        System.out.println(message);
        return s.nextLine();
    }

    public static void displayMessages(String... messages) {
        System.out.println();
        for (String message : messages) {
            System.out.println(message);
        }
    }

    /**
     * display all commands
     */
    public static void displayHelp() {
        System.out.println();
        System.out.println("T U R I N G  M A C H I N E\n" +
                "Turing Machine's commands:\n" +
                "- Enter a code (3 digits between 1 - 5) : enter <code>\n" +
                "- Select a validator : select <index>\n" +
                "- display validator : list\n" +
                "- Show all commands : help\n" +
                "- Next round : next\n" +
                "- Guess the code entered : guess\n" +
                "- Undo a command (only enter and select): undo\n" +
                "- Redo a command (only enter and select): redo\n" +
                "- Stop the game : stop\n" +
                "- Exit the program : exit");
    }
}
