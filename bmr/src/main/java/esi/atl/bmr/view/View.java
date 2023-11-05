package esi.atl.bmr.view;

import esi.atl.bmr.model.LifeStyle;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class View {
    private final TextField bmrTF = new TextField();
    private final TextField caloriesTF = new TextField();

    private final TextField sizeTF = new TextField();
    private final TextField weightTF = new TextField();
    private final TextField ageTF = new TextField();
    private final RadioButton sexeFemmeRB = new RadioButton("Femme");
    private final RadioButton sexeHommeRB = new RadioButton("Homme");
    private final ToggleGroup sexeGroup = new ToggleGroup();
    private final ChoiceBox lifeStyleCB = new ChoiceBox<LifeStyle>();

    private final Button calculBmrBTN = new Button("Calcul du BMR");

    private DataPane datapane = new DataPane(this);
    private ResultPane resultpane = new ResultPane(this);

    public void makeView(Stage stage) {
        VBox root = new VBox(10);
        HBox hbox = new HBox(10);
        HBox sexeBox = new HBox(10);



        datapane.add(sizeTF, 1 , 1);
        datapane.add(weightTF, 1, 2);
        datapane.add(ageTF,1,3);
        sexeBox.getChildren().addAll(sexeFemmeRB, sexeHommeRB);
        datapane.add(sexeBox,1,4);
        datapane.add(lifeStyleCB, 1,5);

        resultpane.add(bmrTF,1,1);
        resultpane.add(caloriesTF,1,2);



        hbox.getChildren().addAll(datapane,resultpane);
        root.getChildren().addAll(hbox,calculBmrBTN);

        Scene scene = new Scene(root, 600, 500);
        stage.setScene(scene);
        stage.show();
    }

    public ToggleGroup getSexeGroup() {
        return sexeGroup;
    }

    public TextField getBmrTF() {
        return bmrTF;
    }

    public TextField getCaloriesTF() {
        return caloriesTF;
    }

    public TextField getSizeTF() {
        return sizeTF;
    }

    public TextField getWeightTF() {
        return weightTF;
    }

    public TextField getAgeTF() {
        return ageTF;
    }
    public int getCalories() {
        return Integer.parseInt(caloriesTF.getText());
    }

    public int getSize() {
        return Integer.parseInt(sizeTF.getText());
    }

    public int getWeight() {
        return Integer.parseInt(weightTF.getText());
    }

    public int getAge() {
        return Integer.parseInt(ageTF.getText());
    }

    public RadioButton getSexeFemmeRB() {
        return sexeFemmeRB;
    }

    public RadioButton getSexeHommeRB() {
        return sexeHommeRB;
    }

    public ChoiceBox getLifeStyleCB() {
        return lifeStyleCB;
    }

    public ResultPane getResultpane() {
        return resultpane;
    }
}
