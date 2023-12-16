package esi.atl.turingmachine.view.javafx.game;

import esi.atl.turingmachine.controller.ControllerJavaFX;
import esi.atl.turingmachine.model.validators.Validator;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;


public class ValidatorPane extends VBox {
    //private final ViewJavaFX view;
    private ImageView imageCardV;
    private Image imageCard;
    private ImageView imageRobotV;
    private Image imageRobot;
    private Label name;
    private Button chooseB;
    private Validator validator;
    private ControllerJavaFX controller;
    private String chooseBStyle = "-fx-background-radius: 10px; " +
            "-fx-border-width: 5px; " +
            "-fx-border-radius: 8px; " +
            "-fx-text-decoration: none; " +
            "-fx-cursor: hand; " +
            "-fx-font-size: 16px; ";


    private String chooseBDefaultStyle = chooseBStyle
            + "-fx-border-color: #2DB563; " +
            "-fx-background-color: #ffffff; ";

    private String chooseBValidStyle = chooseBStyle +
            "-fx-border-color: #2DB563; " +
            "-fx-background-color: #2DB563; ";
    private String chooseBNotValidStyle = chooseBStyle +
            "-fx-border-color: #E13E2E; " +
            "-fx-background-color: #E13E2E; ";

    public ValidatorPane(Validator validator, int pos, ControllerJavaFX controller) {
        super(5);
        this.controller = controller;
        this.validator = validator;
        //this.view = view;
        imageCard = new Image(getClass().getResourceAsStream(
                "/img/cards/card" + validator.getNumber() + ".png"));
        imageCardV = new ImageView(imageCard);
        String abc = "ABCDEF";
        imageRobot = new Image(getClass().getResourceAsStream(
                "/img/robots/robot" + abc.charAt(pos) + ".png"));
        imageRobotV = new ImageView(imageRobot);
        imageRobotV.setFitWidth(100);
        imageRobotV.setFitHeight(100);
        chooseB = new Button();
        chooseB.setMinWidth(50);
        chooseB.setMinHeight(50);
        chooseB.setStyle(chooseBDefaultStyle);
        chooseB.setOnAction(e -> testValidator(pos));

        name = new Label(String.valueOf(abc.charAt(pos)));
        name.setStyle("-fx-text-fill: #2DB563");
        name.setFont(Font.loadFont(getClass().getResourceAsStream(
                "/fonts/Turingmachinefont.otf"), 48));
        setAlignment(Pos.CENTER);
        getChildren().addAll(imageRobotV, imageCardV, name, chooseB);
    }

    public void testValidator(int pos) {
        controller.selectValidator(pos);
        if (validator.isTested())testedValidator();
    }

    public Validator getValidator() {
        return validator;
    }

    public void testedValidator() {
        if (validator.isValid()) {
            chooseB.setStyle(chooseBValidStyle);
        } else {
            chooseB.setStyle(chooseBNotValidStyle);
        }
    }

    public void resetValidator() {
        chooseB.setStyle(chooseBDefaultStyle);
    }
}
