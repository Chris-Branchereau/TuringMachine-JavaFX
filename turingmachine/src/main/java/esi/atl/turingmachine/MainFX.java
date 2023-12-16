package esi.atl.turingmachine;

import esi.atl.turingmachine.controller.ControllerJavaFX;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * The main class which initialize game with Java FX.
 */
public class MainFX extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) {
        new ControllerJavaFX(stage).run();
    }
}