package esi.atl.bmr.controller;

import esi.atl.bmr.view.View;
import javafx.stage.Stage;

public class Controller {
    private final View view;
    private final Stage stage;
    public Controller (Stage stage){
        this.stage = stage;
        view = new View();
    }
    public void run() {
        view.makeView(stage);

    }
}
