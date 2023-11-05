package esi.atl.bmr.view;

import esi.atl.bmr.controller.Controller;
import esi.atl.bmr.model.LifeStyle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
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
    private final Button clearBTN = new Button("Clear");

    private DataPane datapane = new DataPane(this);
    private ResultPane resultpane = new ResultPane(this);

    private Controller controller;

    public void clear(){
        sizeTF.clear();
        weightTF.clear();
        ageTF.clear();
        sexeFemmeRB.setSelected(true);
        lifeStyleCB.getSelectionModel().select(0);
        bmrTF.clear();
        caloriesTF.clear();
    }
    public void error(String title, String paragraph){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(title);
        alert.setContentText(paragraph);
        alert.showAndWait();
    }

    public void makeView(Stage stage) {
        VBox root = new VBox(10);
        HBox hbox = new HBox(10);
        HBox sexeBox = new HBox(10);


        //Data add
        datapane.add(sizeTF, 1 , 1);
        datapane.add(weightTF, 1, 2);
        datapane.add(ageTF,1,3);
        sexeBox.getChildren().addAll(sexeFemmeRB, sexeHommeRB);
        datapane.add(sexeBox,1,4);
        datapane.add(lifeStyleCB, 1,5);

        //Result add
        resultpane.add(bmrTF,1,1);
        resultpane.add(caloriesTF,1,2);


        //Menu
        Menu menu = new Menu("file");
        MenuItem exit = new MenuItem("exit");
        exit.setOnAction(actionEvent -> Platform.exit());
        menu.getItems().add(exit);
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().add(menu);

        //Clear button
        clearBTN.setOnAction(e -> clear());


        //BMR Button
        calculBmrBTN.setOnAction(e -> controller.calculBMR());

        //ADD
        hbox.getChildren().addAll(datapane,resultpane);
        root.getChildren().addAll(menuBar,hbox,calculBmrBTN, clearBTN);

        root.setAlignment(Pos.TOP_CENTER);
        hbox.setAlignment(Pos.CENTER);
        stage.setTitle("Calculer le BMR");
        stage.setResizable(false);

        Scene scene = new Scene(root, 550, 300);
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
    public boolean isMen(){
        return sexeHommeRB.isSelected();
    }

    
    public ChoiceBox getLifeStyleCB() {
        return lifeStyleCB;
    }


    public LifeStyle getLifeStyle(){
        return (LifeStyle) lifeStyleCB.getValue();
    }


    public ResultPane getResultpane() {
        return resultpane;
    }


    public void setController(Controller controller) {
        this.controller = controller;
    }
}
