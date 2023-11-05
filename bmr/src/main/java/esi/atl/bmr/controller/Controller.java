package esi.atl.bmr.controller;

import esi.atl.bmr.model.Model;
import esi.atl.bmr.view.View;
import javafx.stage.Stage;

public class Controller {
    private final View view;
    private final Model model;
    private final Stage stage;
    public Controller (Stage stage){
        this.stage = stage;
        view = new View();
        model = new Model();
    }
    public void run() {
        view.makeView(stage);

    }
}
