package esi.atl.bmr.view;

import esi.atl.bmr.controller.Controller;
import esi.atl.bmr.model.LifeStyle;
import javafx.application.Platform;
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

    /**
     * clear all JavaFx elements
     */
    public void clear() {
        sizeTF.clear();
        weightTF.clear();
        ageTF.clear();
        sexeFemmeRB.setSelected(true);
        lifeStyleCB.getSelectionModel().select(0);
        bmrTF.clear();
        caloriesTF.clear();
    }

    /**
     * makes an alert Box Dialog
     *
     * @param title     = title and header text of the alert
     * @param paragraph = content text of the alert
     */
    public void error(String title, String paragraph) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(title);
        alert.setContentText(paragraph);
        alert.showAndWait();
    }

    /**
     * makes the main view of the App
     *
     * @param stage the main stage
     */
    public void view(Stage stage) {
        VBox root = new VBox(10);
        HBox hbox = new HBox(10);
        HBox sexeBox = new HBox(10);


        //Data add
        datapane.add(sizeTF, 1, 1);
        datapane.add(weightTF, 1, 2);
        datapane.add(ageTF, 1, 3);
        sexeBox.getChildren().addAll(sexeFemmeRB, sexeHommeRB);
        datapane.add(sexeBox, 1, 4);
        datapane.add(lifeStyleCB, 1, 5);

        //Result add
        resultpane.add(bmrTF, 1, 1);
        resultpane.add(caloriesTF, 1, 2);


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
        hbox.getChildren().addAll(datapane, resultpane);
        root.getChildren().addAll(menuBar, hbox, calculBmrBTN, clearBTN);

        root.setAlignment(Pos.TOP_CENTER);
        hbox.setAlignment(Pos.CENTER);
        stage.setTitle("Calculer le BMR");
        stage.setResizable(false);

        Scene scene = new Scene(root, 550, 300);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * get the ToggleGroup sexeGroup
     *
     * @return ToggleGroup sexeGroup
     */
    public ToggleGroup getSexeGroup() {
        return sexeGroup;
    }

    /**
     * get the TextField Calories
     *
     * @return the TextField Calories
     */
    public TextField getBmrTF() {
        return bmrTF;
    }

    /**
     * get the TextField Calories
     *
     * @return the TextField Calories
     */
    public TextField getCaloriesTF() {
        return caloriesTF;
    }

    /**
     * get the TextField Size
     *
     * @return the TextField Size
     */
    public TextField getSizeTF() {
        return sizeTF;
    }

    /**
     * get the TextField Weight
     *
     * @return the TextField Weight
     */
    public TextField getWeightTF() {
        return weightTF;
    }

    /**
     * get the TextField Age
     *
     * @return the TextField Age
     */
    public TextField getAgeTF() {
        return ageTF;
    }

    /**
     * get the value of user's size (in cm)
     *
     * @return user's size (in cm)
     */
    public int getSize() {
        return Integer.parseInt(sizeTF.getText());
    }

    /**
     * get the value of user's weight (in kg)
     *
     * @return user's weight (in kg)
     */
    public int getWeight() {
        return Integer.parseInt(weightTF.getText());
    }

    /**
     * get the value of user's age (in year)
     *
     * @return user's age (in year)
     */
    public int getAge() {
        return Integer.parseInt(ageTF.getText());
    }

    /**
     * get RadioBox Femme
     *
     * @return RadioBox sexeFemmeRB
     */
    public RadioButton getSexeFemmeRB() {
        return sexeFemmeRB;
    }

    /**
     * get RadioBox Homme
     *
     * @return RadioBox sexeHommeRB
     */
    public RadioButton getSexeHommeRB() {
        return sexeHommeRB;
    }

    /**
     * get user's sexe
     *
     * @return true if Radio box Homme is selected
     */
    public boolean isMen() {
        return sexeHommeRB.isSelected();
    }

    /**
     * get Lifestyle ChoiceBox
     *
     * @return Lifestyle ChoiceBox
     */
    public ChoiceBox getLifeStyleCB() {
        return lifeStyleCB;
    }

    /**
     * get actual value of LifeStyle
     *
     * @return the value selected of LifeStyle
     */
    public LifeStyle getLifeStyle() {
        return (LifeStyle) lifeStyleCB.getValue();
    }

    /**
     * get Result GridPane
     *
     * @return ResultPane
     */
    public ResultPane getResultpane() {
        return resultpane;
    }

    /**
     * set the controller
     *
     * @param controller the controller to set
     */
    public void setController(Controller controller) {
        this.controller = controller;
    }
}
