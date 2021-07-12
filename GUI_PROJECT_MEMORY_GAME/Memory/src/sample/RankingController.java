package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;

public class RankingController {
    @FXML
    private TableView tableView;

    private Ranking ranking;

    public void initialize() throws IOException, ClassNotFoundException {
        ranking = new Ranking();

        setTableView();
    }

    public void back() throws IOException {
        SceneController.getInstance().setScene("sample.fxml","MainMenu");
    }

    private void setTableView(){
        TableColumn<PlayerGameData, String> playerNameColumn = new TableColumn<PlayerGameData,String>("PlayerName");
        playerNameColumn.setCellValueFactory(new PropertyValueFactory<>("playerName"));

        TableColumn<PlayerGameData, String> gridColumn = new TableColumn<PlayerGameData,String>("Grid");
        gridColumn.setCellValueFactory(new PropertyValueFactory<>("grid"));

        TableColumn<PlayerGameData, String> timeColumn = new TableColumn<PlayerGameData,String>("Time");
        timeColumn.setCellValueFactory(new PropertyValueFactory<>("timeElapsedFormatted"));

        ObservableList<PlayerGameData> players =  FXCollections.observableList(ranking.getPlayers());
        tableView.setItems(players);
        tableView.getColumns().addAll(playerNameColumn,gridColumn,timeColumn);
    }
}
