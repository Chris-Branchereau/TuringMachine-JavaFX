package esi.atl.bmr.controller;

import esi.atl.bmr.model.Model;
import esi.atl.bmr.view.View;
import javafx.stage.Stage;

public class Controller {
    private final View view;
    private final Model model;
    private final Stage stage;

    /**
     * Constructor of the Controller
     *
     * @param stage
     */
    public Controller(Stage stage) {
        this.stage = stage;
        view = new View();
        view.setController(this);
        model = new Model();
    }

    /**
     * run the model and view
     */
    public void run() {
        view.view(stage);
        model.addObserver(view.getResultpane());
    }

    /**
     * check informations from the view and call the model
     */
    public void calculBMR() {
        try {
            view.getSize();
            view.getAge();
            view.getWeight();
        } catch (NumberFormatException e) {
            model.error();
            return;
        }
        if (view.getSize() <= 0) view.error("Taille Incorrect",
                "La taille doit être strictement supérieur à 0");
        if (view.getAge() <= 0) view.error("Age Incorrect",
                "L'âge doit être strictement supérieur à 0");
        if (view.getWeight() <= 0) view.error("Poids Incorrect",
                "Le poids doit être strictement supérieur à 0");
        model.calculBMR(view.getSize(), view.getWeight(), view.getAge(), view.isMen(), view.getLifeStyle());
    }
}
