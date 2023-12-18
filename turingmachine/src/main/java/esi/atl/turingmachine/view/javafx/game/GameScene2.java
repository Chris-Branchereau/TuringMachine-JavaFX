package esi.atl.turingmachine.view.javafx.game;

import esi.atl.turingmachine.controller.ControllerJavaFX;
import esi.atl.turingmachine.model.validators.Validator;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public class GameScene2 extends GridPane implements PropertyChangeListener {
    private List<ValidatorPane> validators = new ArrayList<>();
    private GridPane validatorpane;
    private ControllerJavaFX controller;

    public GameScene2(int gap, ControllerJavaFX controller) {
        super();
        this.controller = controller;
        setVgap(gap);
        setHgap(gap);

        validatorpane = new GridPane();
        ScrollPane sp = new ScrollPane(validatorpane);

        sp.setFitToHeight(true);
        sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        sp.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        sp.setMaxWidth(1200);
        sp.setStyle("-fx-background-color: #F5F4F6;");

        add(sp, 0, 0);
    }
    @Override
    public void propertyChange(PropertyChangeEvent e) {
        switch (e.getPropertyName()) {
            case "validators" -> {
                validatorpane.getChildren().clear();
                validators.clear();

                int j = 0;
                for (Validator validator : (List<Validator>) e.getNewValue()) {
                    validators.add(new ValidatorPane(validator, j, controller));
                    validatorpane.add(validators.get(j), j, 0);
                    j++;
                }
                validatorpane.setHgap(10);
            }
            case "validatorUsed" -> {
                ValidatorPane v = validators.get((int) e.getNewValue());
                if (v.getValidator().isTested()) v.testedValidator();
                else v.resetValidator();
            }
            case "nextround" -> {
                for (ValidatorPane v : validators) {
                    v.resetValidator();
                }
            }
        }
    }
}
