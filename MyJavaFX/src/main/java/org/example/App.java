package org.example;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


/**
 * JavaFX App
 */
public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        /* Chap 2
        primaryStage.setTitle("My First JavaFX App");
        //primaryStage.initStyle(StageStyle.TRANSPARENT);

        BorderPane root = new BorderPane();
        Text helloText = new Text("Hello World");
        helloText.setFont(Font.font("Times New Roman"));
        helloText.setFill(Color.RED);
        root.setTop(helloText);
        Scene scene = new Scene(root, 500, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
         */



        /* HelloWorldProperty
        primaryStage.setTitle("My First JavaFX App");
        BorderPane root = new BorderPane();

        Label helloText = new Label("Hello World");
        helloText.setUnderline(true);
        helloText.setTextFill(Color.RED);
        helloText.setFont(Font.font("Verdana", 20));

        System.out.println("Le message du Libellé est " + helloText.getText());
        System.out.println("La police du Libellé est " + helloText.getFont());
        System.out.println("La couleur du Libellé est " + helloText.getTextFill());

        root.setCenter(helloText);
        Scene scene = new Scene(root, 250, 100);
        primaryStage.setScene(scene);
        primaryStage.show();
        */



        /* HelloWorldCheckBox
        primaryStage.setTitle("My First JavaFX App");
        BorderPane root = new BorderPane();

        CheckBox checkBox1 = new CheckBox();
        checkBox1.setText("First");
        checkBox1.setSelected(true);

        CheckBox checkBox2 = new CheckBox("Second");
        checkBox2.setIndeterminate(true);

        CheckBox checkBox3 = new CheckBox("Third");

        checkBox3.setAllowIndeterminate(true);

        //Alignment
        root.setLeft(checkBox1);
        //BorderPane.setAlignment(checkBox1, Pos.CENTER);
        root.setCenter(checkBox2);
        root.setRight(checkBox3);
        //BorderPane.setAlignment(checkBox3, Pos.CENTER);

        Scene scene = new Scene(root, 250, 100);
        primaryStage.setScene(scene);
        primaryStage.show();
        */



        /* HelloWorldTextField
        primaryStage.setTitle("My First JavaFX App");
        BorderPane root = new BorderPane();

        Label userName = new Label("User Name");

        PasswordField tfdUserName = new PasswordField();
        tfdUserName.setPrefColumnCount(12);
        tfdUserName.setAlignment(Pos.CENTER_LEFT);

        //Alignment
        root.setTop(userName);
        BorderPane.setAlignment(userName, Pos.CENTER);
        root.setCenter(tfdUserName);

        Scene scene = new Scene(root, 250, 100);
        primaryStage.setScene(scene);
        primaryStage.show();
        */



        /* HelloWorldTextFieldAction
        primaryStage.setTitle("My First JavaFX App");
        BorderPane root = new BorderPane();

        Label userName = new Label("User Name");
        Label test = new Label("User name saved! You can’t change it");

        TextField tfdUserName = new TextField();
        tfdUserName.setPrefColumnCount(12);
        tfdUserName.setAlignment(Pos.CENTER_LEFT);
        tfdUserName.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                root.setBottom(test);
                BorderPane.setAlignment(test, Pos.CENTER);
                tfdUserName.setEditable(false);
                tfdUserName.setAlignment(Pos.CENTER);
            }
        });
        //Alignment
        root.setTop(userName);
        BorderPane.setAlignment(userName, Pos.CENTER);
        root.setCenter(tfdUserName);

        Scene scene = new Scene(root, 300, 100);
        primaryStage.setScene(scene);
        primaryStage.show();
        */



        /* HelloWorldTextArea
        primaryStage.setTitle("My First JavaFX App");
        BorderPane root = new BorderPane();
        TextArea txaUserName = new TextArea();
        txaUserName.setPrefColumnCount(12);
        txaUserName.setPrefRowCount(5);
        txaUserName.setWrapText(true);

        Button btnPrint = new Button("Print");
        btnPrint.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println(txaUserName.getText());
            }
        });
        //Alignment
        root.setTop(txaUserName);
        BorderPane.setAlignment(txaUserName, Pos.CENTER);
        root.setCenter(btnPrint);

        Scene scene = new Scene(root, 250, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
        */




        /* HBoxSample and  VBoxSample
        primaryStage.setTitle("My First JavaFX App");
        VBox root = new VBox(10);
        //root.setAlignment(Pos.CENTER);

        CheckBox checkBox1 = new CheckBox();
        checkBox1.setText("First");
        checkBox1.setSelected(true);

        CheckBox checkBox2 = new CheckBox("Second");
        checkBox2.setIndeterminate(true);

        CheckBox checkBox3 = new CheckBox("Third");

        checkBox3.setAllowIndeterminate(true);

        root.getChildren().addAll(checkBox1, checkBox2, checkBox3);
        //root.getChildren().add(checkBox2);
        //root.getChildren().add(checkBox3);

        Scene scene = new Scene(root, 250, 100);
        primaryStage.setScene(scene);
        primaryStage.show();
        */




        /* GridPane */
        primaryStage.setTitle("My First JavaFX App");
        GridPane root = new GridPane();
        root.setPadding(new Insets(10));
        root.setHgap(10);
        root.setVgap(5);

        Label lblTitle = new Label("JavaFX Course Login");
        lblTitle.setFont(Font.font("System", FontWeight.BOLD, 20));
        lblTitle.setTextFill(Color.RED);
        root.add(lblTitle, 0, 0, 2, 1);
        GridPane.setHalignment(lblTitle, HPos.CENTER);
        GridPane.setMargin(lblTitle, new Insets(0, 0, 10, 0));

        Label lblUserName = new Label("User Name or email");
        GridPane.setHalignment(lblUserName, HPos.RIGHT);
        root.add(lblUserName, 0, 1);

        TextField tfdUserName = new TextField();
        tfdUserName.setPrefColumnCount(20);
        root.add(tfdUserName, 1, 1);

        Label lblPassword = new Label("Password");
        root.add(lblPassword, 0, 2);

        TextField tfdPassword = new TextField();
        tfdPassword.setPrefColumnCount(12);
        root.add(tfdPassword, 1, 2);

        GridPane.setHalignment(lblPassword, HPos.RIGHT);
        GridPane.setFillWidth(tfdPassword, false);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void init() throws Exception {
        super.init();
        System.out.println("Init");
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        System.out.println("stop");
    }
}