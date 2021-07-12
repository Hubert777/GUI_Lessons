package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import sample.SceneController;

import java.io.IOException;

public class NewGameController {
    @FXML
    public TextField playerName;

    @FXML
    public TextField cols;

    @FXML
    public TextField rows;

    @FXML
    public Label warning;

    public void validate() throws IOException {
        if((Integer.parseInt(cols.getText()) * Integer.parseInt(rows.getText()) % 2 == 0)
                && Integer.parseInt(cols.getText())!=0 && Integer.parseInt(rows.getText()) != 0){
            var memoryGame = MemoryGame.getInstance();
            memoryGame.startGame(new PlayerGameData(playerName.getText(), Integer.parseInt(cols.getText()), Integer.parseInt(rows.getText())));
            SceneController.getInstance().setScene("Memory.fxml","Memory");
        }
        else
        {
            warning.setText("wrong values!");
        }
    }
}
