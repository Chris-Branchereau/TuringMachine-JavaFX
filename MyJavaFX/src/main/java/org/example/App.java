package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
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