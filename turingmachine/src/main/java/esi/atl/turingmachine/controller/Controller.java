package esi.atl.turingmachine.controller;

import esi.atl.turingmachine.commands.Command;
import esi.atl.turingmachine.commands.EnterCodeCommand;
import esi.atl.turingmachine.commands.SelectValidatorCommand;
import esi.atl.turingmachine.model.ModelFacade;
import esi.atl.turingmachine.model.TuringException;
import esi.atl.turingmachine.view.ViewConsole;
import javafx.stage.Stage;

import javax.swing.text.View;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {
    private static boolean isStarted = true;


    private static ModelFacade model;

    public Controller(Stage stage) {
        model = new ModelFacade();
    }

    public void run() {
        ViewConsole.displayProblems(model.getProblems());
        model.chooseProblem(ViewConsole.readProblem(
                "Choose a problem (number between 1 and 16 or random)",
                1, 16));
        model.startGame();
        String commandPattern =
                "(select)\s([0-" + (model.getValidator().size()-1) + "])"
                        + "|(enter)\s([1-5][1-5][1-5])"
                        + "|(list)"
                        + "|(stop)"
                        + "|(exit)"
                        + "|(help)"
                        + "|(undo)"
                        + "|(redo)"
                        + "|(next)"
                        + "|(guess)";
        Pattern pattern = Pattern.compile(commandPattern);


        while (isStarted) {
            ViewConsole.displayValidator(model.getValidator());
            Matcher matcher = pattern.matcher(ViewConsole.readCommand(
                    "Enter a command (enter \"help\" to see all commands) : "));

            //select a code before validator

            //model.selectValidator((ViewConsole.readInt("Select a validator between 1 and " + model.getValidator().size(), 1,model.getValidator().size()))-1);
            if (matcher.find()) {
                String[] commands = matcher.group(0).split("\s");
                switch (commands[0]) {
                    case "select" ->
                    {


                            model.executeCommand(new SelectValidatorCommand(model, Integer.parseInt(commands[1])));


                    }
                    case "help" -> ViewConsole.displayHelp();
                    case "list" ->
                            ViewConsole.displayValidator(model.getValidator());
                    case "exit" -> isStarted = false;
                    case "stop" -> model.giveUp();
                    case "undo" -> model.undoCommand();
                    case "redo" -> model.redoCommand();
                    case "enter" ->
                            model.executeCommand(new EnterCodeCommand(model, Integer.parseInt(commands[1])));
                    case "next" -> model.nextRound();
                    case "guess" -> model.guessCode();
                }

            } else {
                ViewConsole.displayError("invalid command");
            }
        }
    }


}


