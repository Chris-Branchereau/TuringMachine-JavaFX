package esi.atl.bmr.view.components;

import esi.atl.bmr.view.View;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class DataPane extends GridPane {
    public DataPane (View view){
        this.setHgap(10);
        this.setVgap(10);
        Label datalbl = new Label("Donnée : ");
        datalbl.setUnderline(true);


        Label sizelbl = new Label("Taille (cm)");
        Label weightlbl = new Label("Poids (kg)");
        Label agelbl = new Label("Age (années)");
        Label sexelbl = new Label("Sexe");
        Label lifelbl = new Label("Style de vie");


        this.add(datalbl, 0, 0);
        this.add(sizelbl, 0 , 1);
        this.add(weightlbl, 0 , 2);
        this.add(agelbl, 0 , 3);
        this.add(sexelbl, 0 , 4);
        this.add(lifelbl, 0 , 5);

    }
}
