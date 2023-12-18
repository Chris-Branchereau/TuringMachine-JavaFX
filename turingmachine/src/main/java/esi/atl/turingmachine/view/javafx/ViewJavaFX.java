package esi.atl.turingmachine.view.javafx;


import esi.atl.turingmachine.controller.ControllerJavaFX;
import esi.atl.turingmachine.view.javafx.game.GameScene;
import esi.atl.turingmachine.view.javafx.game.GameScene2;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


public class ViewJavaFX implements PropertyChangeListener {


    private ScreenTitle root;
    private GameScene root2;
    private GameScene2 root3;
    private ControllerJavaFX controller;

    private Scene scene1;
    private Scene scene2;
    private Scene scene3;
    private Stage stage;
    private Stage stage2;

    public void view(Stage stage) {
        this.stage =stage;
        this.stage2 = new Stage();
        root = new ScreenTitle(10, controller);
        root2 = new GameScene(10, controller);
        root3 = new GameScene2(10,controller);
        scene2 = new Scene(root2, 1920,1080);
        scene1 = new Scene(root, 1920, 1080);
        scene3 = new Scene(root3,1280, 720);

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
    public GameScene2 getGameScene2(){
        return root3;
    }

    @Override
    public void propertyChange(PropertyChangeEvent e) {
        switch (e.getPropertyName()){
            case "start" ->{
                if ((boolean) e.getNewValue()){
                    stage.setScene(scene2);
                    stage2.setTitle("Turing Machine");
                    stage2.setScene(scene3);
                    stage2.show();
                }
                else {
                    stage.setScene(scene1);
                }
            }
        }
    }
}
