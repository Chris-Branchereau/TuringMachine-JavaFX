package esi.atl.bmr.view;

import esi.atl.bmr.view.View;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ResultPane extends GridPane{
    public ResultPane(View view){
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


}
