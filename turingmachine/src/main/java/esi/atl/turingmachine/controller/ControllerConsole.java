package esi.atl.turingmachine.controller;

import esi.atl.turingmachine.commands.EnterCodeCommand;
import esi.atl.turingmachine.commands.SelectValidatorCommand;
import esi.atl.turingmachine.model.ModelFacade;
import esi.atl.turingmachine.model.TuringException;
import esi.atl.turingmachine.view.console.ViewConsole;
import esi.atl.turingmachine.view.javafx.ViewJavaFX;
import javafx.application.Platform;
import javafx.stage.Stage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ControllerConsole extends Controller {


    public ControllerConsole() {
        super();
    }

    public void run() {
        Pattern pattern = Pattern.compile("");
        if (!isStarted()) {
            ViewConsole.displayProblems(model.getProblems());
            chooseProblem(ViewConsole.readProblem(
                    "Choose a problem (number between 1 and 16 or random)",
                    1, 16));
        }
        if (isStarted()) {
            String commandPattern =
                    "(select)\s([0-" + (model.getValidator().size() - 1) + "])"
                            + "|(enter)\s([1-5][1-5][1-5])"
                            + "|(list)"
                            + "|(stop)"
                            + "|(exit)"
                            + "|(help)"
                            + "|(undo)"
                            + "|(redo)"
                            + "|(next)"
                            + "|(guess)";
            pattern = Pattern.compile(commandPattern);
        }
        while (isStarted()) {
            ViewConsole.displayValidator(model.getValidator());
            ViewConsole.displayScore(model.getScoreValidator(), model.getTotalRound());
            Matcher matcher = pattern.matcher(ViewConsole.readCommand(
                    "Enter a command (enter \"help\" to see all commands) : "));

            if (matcher.find()) {
                String[] commands = matcher.group(0).split("\s");
                switch (commands[0]) {
                    case "select" -> {
                        try {

                            model.executeCommand(new SelectValidatorCommand(model,
                                    Integer.parseInt(commands[1])));
                        } catch (TuringException e) {
                            ViewConsole.displayError(e.getMessage());
                        }
                    }
                    case "help" -> ViewConsole.displayHelp();
                    case "list" ->
                            ViewConsole.displayValidator(model.getValidator());
                    case "exit" -> {
                        model.giveUp();
                        Platform.exit();
                    }
                    case "stop" -> {
                        try {
                            model.giveUp();
                            ViewConsole.displayEnd(isStarted(),
                                    model.getScoreValidator(), model.getTotalRound());
                            run();
                        } catch (TuringException e) {
                            ViewConsole.displayError(e.getMessage());
                        }
                    }
                    case "undo" -> {
                        try {

                            model.undoCommand();
                        } catch (TuringException e) {
                            ViewConsole.displayError(e.getMessage());
                        }
                    }
                    case "redo" -> {
                        try {
                            model.redoCommand();
                        } catch (TuringException e) {
                            ViewConsole.displayError(e.getMessage());
                        }
                    }
                    case "enter" -> {
                        try {

                            model.executeCommand(new EnterCodeCommand(model,
                                    Integer.parseInt(commands[1])));
                        } catch (TuringException e) {
                            ViewConsole.displayError(e.getMessage());
                        }
                    }
                    case "next" -> model.nextRound();
                    case "guess" -> {
                        try {
                            model.giveUp();
                            ViewConsole.displayEnd(model.guessCode(),
                                    model.getScoreValidator(), model.getTotalRound());
                            run();
                        } catch (TuringException e) {
                            ViewConsole.displayError(e.getMessage());
                        }
                    }
                }

            } else {
                ViewConsole.displayError("invalid command");
            }
        }
    }
}


