package esi.atl.turingmachine.view.javafx.game;


import esi.atl.turingmachine.controller.ControllerJavaFX;
import esi.atl.turingmachine.model.Code;
import esi.atl.turingmachine.model.validators.Validator;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

public class GameScene extends GridPane implements PropertyChangeListener {
    private Button nextRoundB;
    private Button guessCodeB;
    private Button okB;
    private ControllerJavaFX controller;
    private GridPane validatorpane;
    private VBox codeBox;


    public GameScene(int gap, ControllerJavaFX controller) {
        super();
        this.controller = controller;
        nextRoundB = new Button("Next Round");
        guessCodeB = new Button("Guess Code");
        guessCodeB.setOnAction(e -> controller.guessCode());
        validatorpane = new GridPane();
        codeBox = new VBox();
        okB = new Button("OK");
        okB.setStyle("-fx-background-radius: 10px; " +
                "-fx-background-color: #F5F4F6; " +
                "-fx-border-width: 5px; " +
                "-fx-border-radius: 8px; " +
                "-fx-text-decoration: none; " +
                "-fx-cursor: hand; " +
                "-fx-text-fill: #2DB563;");
        CodeBox triangle = new CodeBox("triangle");
        CodeBox square = new CodeBox("square");
        CodeBox circle = new CodeBox("circle");
        codeBox.getChildren().add(triangle);
        codeBox.getChildren().add(square);
        codeBox.getChildren().add(circle);
        okB.setOnAction(e -> enterCode(triangle, square, circle));
        codeBox.getChildren().add(okB);
        codeBox.setStyle("-fx-border-width: 5px; " +
                "-fx-border-radius: 8px; "
                + "-fx-border-color: #2DB563; " +
                "-fx-padding: 10px; ");
        add(nextRoundB, 1, 1);
        add(guessCodeB, 2, 1);
        add(validatorpane, 2, 2);
        add(codeBox, 2, 3);
        setAlignment(Pos.TOP_CENTER);
    }

    public void enterCode(CodeBox... c) {
        String s = "";
        for (CodeBox cb : c) {
            if (cb.getDigit() != 0) s = s + cb.getDigit();
        }
        System.out.println(s);
        controller.enterCode(Integer.parseInt(s));
    }

    @Override
    public void propertyChange(PropertyChangeEvent e) {
        switch (e.getPropertyName()) {
            case "validators" -> {
                validatorpane.getChildren().clear();
                int j = 0;
                for (Validator validator : (List<Validator>) e.getNewValue()) {
                    validatorpane.add(new ValidatorPane(validator, j, controller), j, 0);
                    j++;
                }
                validatorpane.setHgap(10);
            }
        }
    }
}
