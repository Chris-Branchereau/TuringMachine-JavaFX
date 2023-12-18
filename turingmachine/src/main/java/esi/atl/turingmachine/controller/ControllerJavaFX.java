package esi.atl.turingmachine.controller;

import esi.atl.turingmachine.commands.EnterCodeCommand;
import esi.atl.turingmachine.commands.SelectValidatorCommand;
import esi.atl.turingmachine.model.Problem;
import esi.atl.turingmachine.model.TuringException;
import esi.atl.turingmachine.view.javafx.ViewJavaFX;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Controller of the Java FX View
 */
public class ControllerJavaFX extends Controller {
    private final ViewJavaFX view;
    private final Stage stage;

    /**
     * constructor of this controller
     * @param stage
     */
    public ControllerJavaFX(Stage stage) {
        super();
        view = new ViewJavaFX();
        this.stage = stage;
        view.setController(this);

    }

    /**
     * main run method
     */
    public void run() {
        view.view(stage);
        model.addObserver(view);
        model.addObserver(view.getGameScene());
        model.addObserver(view.getGameScene2());
    }

    /**
     * get the problems list
     * @return the problems list
     */
    public ObservableList getProblemsList() {

        ObservableList<String> t = FXCollections.observableArrayList();
        t.add("Random");
        for (Problem problem : model.getProblems()) {
            String problemView = problem.getNum() + ") Difficulty : " + problem.getDifficulty() + " Luck : " + problem.getLuck();
            t.add(problemView);
        }
        return t;
    }

    /**
     * call selectValidator Command from model with an index of a validator
     * @param i index of the validator selected
     */
    public void selectValidator(int i) {
        try {
            model.executeCommand(new SelectValidatorCommand(model, i));
        } catch (TuringException e) {
            model.error(e.getMessage());
        }
    }

    /**
     * call EnterCode Command from model with a code in param (check the code pattern)
     * @param i the code to check
     */
    public void enterCode(String i) {
        String s = "([1-5][1-5][1-5])";
        Pattern pattern = Pattern.compile(s);
        Matcher matcher = pattern.matcher(i);
        if (matcher.find())
            model.executeCommand(new EnterCodeCommand(model, Integer.parseInt(i)));
        else model.error("You must enter a complete code");
    }
    /**
     * call nextRound from model
     */
    public void nextRound() {
        model.nextRound();
    }
    /**
     * call giveUp from model
     */
    public void giveUp(){
        model.giveUp();
    }
    /**
     * call guessCode from model
     */
    public void guessCode() {
        try {

            model.guessCode();
        } catch (TuringException e) {
            model.error(e.getMessage());
        }
    }
    /**
     * call undo command from model
     */
    public void undo() {
        try {
            model.undoCommand();
        } catch (TuringException e) {
            model.error(e.getMessage());
        }
    }

    /**
     * call redo command from model
     */
    public void redo() {
        try {
            model.redoCommand();
        } catch (TuringException e) {
            model.error(e.getMessage());
        }
    }


}
