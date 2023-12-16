package esi.atl.turingmachine.view.console;


import esi.atl.turingmachine.model.Problem;
import esi.atl.turingmachine.model.validators.Validator;

import javax.sound.midi.Soundbank;
import java.util.List;
import java.util.Scanner;

public class ViewConsole {
    public static final String COLOR_RESET = "\u001B[0m";
    public static final String COLOR_RED = "\u001B[31m";

    /**
     * display the list of known problems (from known_problems.csv)
     * @param problems list of problems
     */
    public static void displayProblems(List<Problem> problems) {
        for (Problem problem : problems) {
            System.out.println(problem.getNum() + ": difficulty = "
                    + problem.getDifficulty() + " luck = " + problem.getLuck());
        }

    }

    /**
     * display the score (total of validator and rounds until now)
     * @param validatorsTested total of validators tested
     * @param rounds total of rounds
     */
    public static void displayScore(int validatorsTested, int rounds){
        System.out.println();
        System.out.println("Total Validators Tested: " + validatorsTested);
        System.out.println("Round : " + rounds);
        System.out.println();
    }

    /**
     * display the end of the game (Victory or defeat)
     * @param won = true if victory
     * @param validatorsTested total of validator tested
     * @param rounds total of rounds
     */
    public static void displayEnd(boolean won, int validatorsTested, int rounds){
        if (won){
            System.out.println();
            System.out.println("Victory !");
            displayScore(validatorsTested, rounds);
        } else {
            System.out.println();
            System.out.println("Defeat..");
            displayScore(validatorsTested, rounds);
        }
    }

    /**
     * display the list of validator for the game (and if a validator is valid or not for this round)
     * @param validators list of validator
     */
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
     * read, from input, a integer between min and max to select a problem (or random)
     * @param message message to print
     * @param min minimum
     * @param max maximum
     * @return
     */
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

    /**
     * read a command from input
     * @param message to print
     * @return
     */
    public static String readCommand(String message) {
        System.out.println();
        Scanner s = new Scanner(System.in);
        System.out.println(message);
        return s.nextLine();
    }

    /**
     * method to display a message
     * @param messages message to print
     */
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
        System.out.println("""
                T U R I N G  M A C H I N E
                Turing Machine's commands:
                - Enter a code (3 digits between 1 - 5) : enter <code>
                - Select a validator : select <index>
                - display validator : list
                - Show all commands : help
                - Next round : next
                - Guess the code entered : guess
                - Undo a command (only enter and select): undo
                - Redo a command (only enter and select): redo
                - Stop the game : stop
                - Exit the program : exit
                """);
        System.out.println();
    }
}
