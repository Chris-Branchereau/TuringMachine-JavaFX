package esi.atl.turingmachine.view.javafx.game;


import esi.atl.turingmachine.controller.ControllerJavaFX;
import esi.atl.turingmachine.model.Code;
import esi.atl.turingmachine.model.validators.Validator;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GameScene extends GridPane implements PropertyChangeListener {
    private Button nextRoundB;
    private Button guessCodeB;
    private Button okB;
    private Button undoB;
    private Button redoB;
    private Button giveUp;
    private ControllerJavaFX controller;
    private GridPane validatorpane;
    private VBox codeBox;
    private Label error;
    private Label roundL;
    private Label totalValidatorUsedL;
    private List<ValidatorPane> validators = new ArrayList<>();
    private CodeBox triangle = new CodeBox("triangle");
    private CodeBox square = new CodeBox("square");
    private CodeBox circle = new CodeBox("circle");
    private int rounds = 1;
    private int totalValidatorUsed = 0;


    public GameScene(int gap, ControllerJavaFX controller) {
        super();
        this.controller = controller;
        setVgap(gap);
        setHgap(gap);

        nextRoundB = new Button("Next Round");
        guessCodeB = new Button("Guess Code");
        redoB = new Button("Redo");
        undoB = new Button("Undo");
        okB = new Button("OK");
        giveUp = new Button("Give Up");

        codeBox = new VBox();
        validatorpane = new GridPane();
        ScrollPane sp = new ScrollPane(validatorpane);

        roundL = new Label("Round : 1");
        error = new Label();
        totalValidatorUsedL = new Label("Validator used : 0");
        roundL.setStyle("-fx-font-size: 15px;");
        totalValidatorUsedL.setStyle("-fx-font-size: 15px;");


        sp.setFitToHeight(true);
        sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        sp.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        sp.setMaxWidth(1200);
        sp.setStyle("-fx-background-color: #F5F4F6;");


        codeBox.getChildren().add(triangle);
        codeBox.getChildren().add(square);
        codeBox.getChildren().add(circle);
        codeBox.getChildren().add(okB);
        codeBox.setAlignment(Pos.CENTER);
        codeBox.setStyle("-fx-border-width: 5px; " +
                "-fx-border-radius: 8px; "
                + "-fx-border-color: #2DB563; " +
                "-fx-padding: 10px; ");

        okB.setOnAction(e -> enterCode(triangle, square, circle));
        okB.setStyle("-fx-background-radius: 10px; " +
                "-fx-background-color: #F5F4F6; " +
                "-fx-border-width: 5px; " +
                "-fx-border-radius: 8px; " +
                "-fx-text-decoration: none; " +
                "-fx-cursor: hand; " +
                "-fx-text-fill: #2DB563;" +
                "-fx-font-size: 32px");

        guessCodeB.setOnAction(e -> controller.guessCode());
        guessCodeB.setStyle("-fx-font-size: 15px;");
        nextRoundB.setOnAction(e -> controller.nextRound());
        nextRoundB.setStyle("-fx-font-size: 15px;");
        giveUp.setOnAction(e -> controller.giveUp());
        giveUp.setStyle("-fx-font-size: 15px;");
        undoB.setOnAction(e -> controller.undo());
        undoB.setStyle("-fx-font-size: 15px;");
        redoB.setOnAction(e -> controller.redo());
        redoB.setStyle("-fx-font-size: 15px;");
        undoB.setDisable(true);
        redoB.setDisable(true);

        error.setStyle("-fx-font-size:  15px; -fx-text-fill: #E13E2E");
        error.setVisible(false);


        add(sp, 0, 0, 4, 1);
        add(codeBox, 0, 1, 1, 6);
        add(nextRoundB, 1, 1, 2, 1);
        add(guessCodeB, 1, 2, 2, 1);
        add(undoB, 1, 3, 1, 1);
        add(redoB, 2, 3, 1, 1);
        add(giveUp, 1, 4,2 ,1);
        add(roundL, 3, 1, 1, 1);
        add(totalValidatorUsedL, 3, 2, 1, 1);
        add(error, 3, 3, 1, 1);
        setAlignment(Pos.CENTER);
    }

    public void enterCode(CodeBox... c) {
        String s = "";
        for (CodeBox cb : c) {
            if (cb.getDigit() != 0) s = s + Integer.toString(cb.getDigit());
        }

        controller.enterCode(s);
    }

    private void resetCode() {
        triangle.resetCode();
        square.resetCode();
        circle.resetCode();
    }
    private void resetcodeBox(){
        codeBox.setDisable(false);
    }

    public void finish(boolean victory) {
        String title;
        String paragraph;
        Alert alert;
        if (victory){
            alert= new Alert(Alert.AlertType.INFORMATION);
            title = "Victory !";
            paragraph = "You win ";
        } else {
            alert= new Alert(Alert.AlertType.ERROR);
            title = "Defeat..";
            paragraph = "You lose ";
        }
        paragraph = paragraph + "with " + totalValidatorUsed + " validators used and in " + rounds + " rounds.";

        alert.setTitle(title);
        alert.setHeaderText(title);
        alert.setContentText(paragraph);
        alert.showAndWait();

    }

    @Override
    public void propertyChange(PropertyChangeEvent e) {
        switch (e.getPropertyName()) {
            case "validators" -> {
                validatorpane.getChildren().clear();
                validators.clear();
                resetCode();
                resetcodeBox();
                undoB.setDisable(true);
                redoB.setDisable(true);
                totalValidatorUsed = 0;
                rounds = 1;
                roundL.setText("Round : 1");
                totalValidatorUsedL.setText("Validator used : 0");
                error.setVisible(false);
                int j = 0;
                for (Validator validator : (List<Validator>) e.getNewValue()) {
                    validators.add(new ValidatorPane(validator, j, controller));
                    validatorpane.add(validators.get(j), j, 0);
                    j++;
                }
                validatorpane.setHgap(10);
            }
            case "nextround" -> {
                resetcodeBox();

                error.setVisible(false);
                for (ValidatorPane v : validators) {
                    v.resetValidator();
                }
                rounds = (int) e.getNewValue();
                roundL.setText("Round : " + (int) e.getNewValue());
            }
            case "enteredCode" -> {
                if (!(boolean) e.getNewValue()) {
                    resetCode();
                    resetcodeBox();
                }
                else codeBox.setDisable(true);
            }
            case "validatorUsed" -> {
                ValidatorPane v = validators.get((int) e.getNewValue());
                if (v.getValidator().isTested()) v.testedValidator();
                else v.resetValidator();
            }
            case "totalValidatorUsed" -> {
                totalValidatorUsed = (int) e.getNewValue();
                totalValidatorUsedL.setText("Validator used : " + Integer.toString((int) e.getNewValue()));
            }
            case "error" -> {
                error.setText("Error: " + (String) e.getNewValue());
                error.setVisible(true);
            }
            case "undo" -> {
                undoB.setDisable(!(boolean) e.getNewValue());

            }
            case "redo" -> {
                redoB.setDisable(!(boolean) e.getNewValue());
            }
            case "finish" -> {
                finish((boolean) e.getNewValue());
            }
        }
    }
}
