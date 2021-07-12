package sample;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.io.IOException;

public class MemoryController {
    @FXML
    public VBox parent;

    private Label elapsedTime = new Label();

    public void initialize(){
        var memoryGame = MemoryGame.getInstance();

        memoryGame.getGameFinished().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue){
                    try {
                        SceneController.getInstance().setScene("Ranking.fxml","Ranking");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        int counter = 0;

        GridPane gridPane = new GridPane();
        var shuffledMemories = memoryGame.getShuffledMemories();

        for(int i=0;i<memoryGame.getPlayerGameData().getGridCol();i++){
            for(int j=0;j<memoryGame.getPlayerGameData().getGridRow();j++){
                Button button = new Button("");
                button.setPrefSize(60,60);
                setImage(button, "card-games.png");

                gridPane.add(button, i, j);

                Memory memory = shuffledMemories.get(counter);

                memory.getHide().addListener(new ChangeListener<Boolean>() {
                    @Override
                    public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                if(newValue){
                                    setImage(button, "card-games.png");
                                }
                                else{
                                    setImage(button, memory.getMemoryGroup().getIconName());
                                }
                            }
                        });
                    }
                });

                button.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        try {
                            memory.pick();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });

                counter+=1;
            }
        }

        gridPane.setVgap(30);
        gridPane.setHgap(30);
        gridPane.setAlignment(Pos.CENTER);
        parent.getChildren().add(gridPane);
        parent.getChildren().add(elapsedTime);

        memoryGame.getTimeHandler().getSeconds().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        int seconds= memoryGame.getTimeHandler().getSeconds().getValue();

                        elapsedTime.setText(Helper.GetFormattedTime(seconds));
                    }
                });
            }
        });
    }

    private void setImage(Button button, String fileName){
        fileName = "sample/images/"+fileName;

        ImageView imageView = new ImageView(new Image(fileName));

        imageView.setFitHeight(40);
        imageView.setPreserveRatio(true);
        button.setGraphic(imageView);
    }
}
