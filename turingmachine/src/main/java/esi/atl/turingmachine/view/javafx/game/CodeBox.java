package esi.atl.turingmachine.view.javafx.game;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

import java.util.ArrayList;
import java.util.List;

public class CodeBox extends HBox {
    private int digit;
    private List<Button> digits = new ArrayList<>();
    private ImageView imageV;
    private Image image;
    private String codeStyleB = "-fx-background-radius: 10px; " +
            "-fx-border-width: 5px; " +
            "-fx-border-radius: 8px; " +
            "-fx-text-decoration: none; " +
            "-fx-cursor: hand; ";
    private String codeDefaultStyleB = "-fx-text-fill: #2DB563; " +
            "-fx-background-color: #F5F4F6; " + codeStyleB;
    private String codeSelectedStyleB = "-fx-text-fill: #ffffff; " +
            "-fx-background-color: #2DB563; " + codeStyleB;

    public CodeBox(String name) {
        image = new Image(getClass().getResourceAsStream(
                "/img/codes/" + name + ".png"));
        imageV = new ImageView(image);
        imageV.setFitWidth(65);
        imageV.setFitHeight(65);
        for (int i = 5; i > 0; i--) {
            digits.add(new Button(Integer.toString(i)));
        }
        setStyle("-fx-margin: 10px; ");

        setAlignment(Pos.CENTER);
        getChildren().addAll(imageV);
        for (Button b : digits) {
            b.setStyle(codeDefaultStyleB);
            b.setFont(Font.loadFont(getClass().getResourceAsStream(
                    "/fonts/Turingmachinefont.otf"), 50));
            b.setOnAction(e -> selectDigit(b.getText(), b));
            getChildren().add(b);
        }

    }

    public void resetCode() {
        for (Button b : digits) {
            b.setStyle(codeDefaultStyleB);
            digit = 0;
        }
    }

    private void selectDigit(String s, Button b) {
        resetCode();
        b.setStyle(codeSelectedStyleB);
        digit = Integer.parseInt(s);
    }

    public int getDigit() {
        return digit;
    }
}
