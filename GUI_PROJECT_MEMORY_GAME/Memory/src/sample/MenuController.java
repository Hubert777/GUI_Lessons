package sample;

import javafx.event.ActionEvent;

import java.io.IOException;

public class MenuController {
    public void newGameLaunched(javafx.event.ActionEvent actionEvent) throws IOException {
        SceneController.getInstance().setScene("NewGame.fxml","New Game");
    }

    public void highScoreLaunched(ActionEvent actionEvent) throws IOException {
        SceneController.getInstance().setScene("Ranking.fxml","Ranking");
    }

    public void exitLaunched(ActionEvent actionEvent) {
        System.exit(0);
    }
}
