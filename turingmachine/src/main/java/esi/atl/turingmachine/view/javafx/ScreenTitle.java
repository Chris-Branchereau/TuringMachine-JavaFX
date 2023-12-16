package esi.atl.turingmachine.view.javafx;

import esi.atl.turingmachine.controller.Controller;
import esi.atl.turingmachine.controller.ControllerJavaFX;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class ScreenTitle extends VBox {
    private ComboBox problemsCB;
    private Label title;
    private Button startB;
    private ControllerJavaFX controller;
    public ScreenTitle(int gap, ControllerJavaFX controller){
        super(gap);
        problemsCB = new ComboBox<>();
        title = new Label("Turing Machine");
        startB = new Button("Start");
        this.controller = controller;
        problemsCB.setItems(controller.getProblemsList());

        startB.setOnAction(e -> chooseProblem());

        setAlignment(Pos.CENTER);
        getChildren().addAll(title, problemsCB, startB);
    }
    private void chooseProblem(){
        for (int i=0; i< problemsCB.getItems().size(); i++ ){
            if (problemsCB.getItems().get(i) ==  problemsCB.getValue()){
                controller.chooseProblem(i);
            }
        }
    }
}
