package esi.atl.bmr.view;

import esi.atl.bmr.model.LifeStyle;
import esi.atl.bmr.view.View;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class DataPane extends GridPane {
    public DataPane (View view){
        this.setHgap(10);
        this.setVgap(10);
        Label datalbl = new Label("Donnée : ");
        datalbl.setUnderline(true);

        // Labels
        Label sizelbl = new Label("Taille (cm)");
        Label weightlbl = new Label("Poids (kg)");
        Label agelbl = new Label("Age (années)");
        Label sexelbl = new Label("Sexe");
        Label lifelbl = new Label("Style de vie");

        //TextField PromptText
        view.getSizeTF().setPromptText("Taille en cm");
        view.getWeightTF().setPromptText("Poids en kg");
        view.getAgeTF().setPromptText("Age en années");

        // ChoiceBox LifeStyle
        view.getLifeStyleCB().getItems().addAll(LifeStyle.values());
        view.getLifeStyleCB().getSelectionModel().select(0);

        //ToggleGroup
        view.getSexeFemmeRB().setToggleGroup(view.getSexeGroup());
        view.getSexeHommeRB().setToggleGroup(view.getSexeGroup());
        view.getSexeFemmeRB().setSelected(true);


        //add to Data GridPane
        this.add(datalbl, 0, 0);
        this.add(sizelbl, 0 , 1);
        this.add(weightlbl, 0 , 2);
        this.add(agelbl, 0 , 3);
        this.add(sexelbl, 0 , 4);
        this.add(lifelbl, 0 , 5);

    }
}
