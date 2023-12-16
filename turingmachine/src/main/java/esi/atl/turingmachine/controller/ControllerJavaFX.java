package esi.atl.turingmachine.controller;

import esi.atl.turingmachine.commands.EnterCodeCommand;
import esi.atl.turingmachine.commands.SelectValidatorCommand;
import esi.atl.turingmachine.model.Problem;
import esi.atl.turingmachine.view.javafx.ViewJavaFX;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;

public class ControllerJavaFX extends Controller {
    private final ViewJavaFX view;
    private final Stage stage;

    public ControllerJavaFX(Stage stage) {
        super();
        view = new ViewJavaFX();
        this.stage = stage;
        view.setController(this);

    }

    public void run() {
        view.view(stage);
        model.addObserver(view);
        model.addObserver(view.getGameScene());
        //model.addObserver(view.getValidatorPane);
    }

    public ObservableList getProblemsList() {

        ObservableList<String> t = FXCollections.observableArrayList();
        t.add("Random");
        for (Problem problem : model.getProblems()) {
            String problemView = problem.getNum() + ") Difficulty : " + problem.getDifficulty() + " Luck : " + problem.getLuck();
            t.add(problemView);
        }
        return t;
    }
    public void selectValidator(int i){
        model.executeCommand(new SelectValidatorCommand(model, i));
    }
    public void enterCode(int i){
        model.executeCommand(new EnterCodeCommand(model, i));
    }

    public void guessCode(){
        model.guessCode();
    }


}
