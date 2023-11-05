package esi.atl.bmr.view;

import esi.atl.bmr.view.View;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ResultPane extends GridPane implements PropertyChangeListener {
    private final View view;

    /**
     * All elements of the result side
     *
     * @param view the main view
     */
    public ResultPane(View view){
        this.view = view;
        this.setHgap(10);
        this.setVgap(10);
        Label titlelbl = new Label("Résultats");
        titlelbl.setUnderline(true);

        // Labels
        Label bmrlbl = new Label("BMR");
        Label calories = new Label("Calories");

        // TextField
        view.getBmrTF().setPromptText("Résultats du BMR");
        view.getCaloriesTF().setPromptText("Dépense en calories");
        view.getBmrTF().setEditable(false);
        view.getCaloriesTF().setEditable(false);

        this.add(titlelbl, 0,0);
        this.add(bmrlbl,0,1);
        this.add(calories,0,2);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("error")){
            view.getBmrTF().setText("Failed!");
            view.getBmrTF().setStyle("-fx-text-fill: red;");
            view.getCaloriesTF().setText("Failed!");
            view.getCaloriesTF().setStyle("-fx-text-fill: red;");
        }
        if (evt.getPropertyName().equals("BMR")){
            view.getBmrTF().setStyle("-fx-text-fill: black;");
            view.getBmrTF().setText(Double.toString((Double) evt.getNewValue()));
        }
        if (evt.getPropertyName().equals("Calories")){
            view.getCaloriesTF().setStyle("-fx-text-fill: black;");
            view.getCaloriesTF().setText(Double.toString((Double) evt.getNewValue()));
        }
    }
}
