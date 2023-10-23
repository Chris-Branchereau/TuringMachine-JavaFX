package esi.atl.bmr;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class App extends Application {
    private final BorderPane root = new BorderPane();
    @Override
    public void start(Stage stage) {

        Scene scene = new Scene(root, 640, 500);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
