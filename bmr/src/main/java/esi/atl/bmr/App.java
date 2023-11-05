package esi.atl.bmr;

import esi.atl.bmr.controller.Controller;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        new Controller(stage).run();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
