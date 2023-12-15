package esi.atl.turingmachine;

import esi.atl.turingmachine.controller.Controller;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);

    }


    @Override
    public void start(Stage stage) {
        new Controller(stage).run();
    }
}