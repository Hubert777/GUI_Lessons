package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public final class SceneController {
    private static SceneController instance;

    private Scene lastScene=null;
    private Scene currentScene=null;

    private Stage primaryStage;

    public static SceneController getInstance() {
        if (instance == null) {
            instance = new SceneController();
        }
        return instance;
    }

    public void initialize(Stage primaryStage){
        this.primaryStage = primaryStage;
    }

    public void setScene(String fxmlFile,String title) throws IOException {
        lastScene = primaryStage.getScene();

        Parent root = FXMLLoader.load(getClass().getResource(fxmlFile));
        primaryStage.setTitle(title);
        primaryStage.setScene(currentScene = new Scene(root, primaryStage.widthProperty().getValue(), primaryStage.heightProperty().getValue()));
        primaryStage.show();
    }

    public void returnToLastScene(){
        primaryStage.setScene(lastScene);
        primaryStage.show();
    }
}
