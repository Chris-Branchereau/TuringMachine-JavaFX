package esi.atl.turingmachine.view.javafx;


import esi.atl.turingmachine.controller.ControllerJavaFX;
import esi.atl.turingmachine.view.javafx.game.GameScene;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


public class ViewJavaFX implements PropertyChangeListener {


    private ScreenTitle root;
    private GameScene root2;
    private ControllerJavaFX controller;

    private Scene scene1;
    private Scene scene2;
    private Stage stage;

    public void view(Stage stage) {
        this.stage =stage;
        root = new ScreenTitle(10, controller);
        root2 = new GameScene(10, controller);
        scene2 = new Scene(root2, 1920,1080);
        scene1 = new Scene(root, 1920, 1080);

        stage.setTitle("Turing Machine");
        stage.setScene(scene1);
        stage.show();
    }

    public void setController(ControllerJavaFX controller) {
        this.controller = controller;
    }
    public GameScene getGameScene(){
        return root2;
    }


    @Override
    public void propertyChange(PropertyChangeEvent e) {
        switch (e.getPropertyName()){
            case "start" ->{
                if ((boolean) e.getNewValue()){
                    stage.setScene(scene2);
                }
                else {
                    stage.setScene(scene1);
                }
            }
        }
    }
}
