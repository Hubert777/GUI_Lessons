package sample;

import java.io.Serializable;

public class PlayerGameData implements Serializable {
    private long pairsWithNoLook;
    private long elapsedTime;

    private int gridCol;
    private int gridRow;

    private String playerName;
    private String grid;
    private String timeElapsedFormatted;

    public PlayerGameData(String playerName, int gridCol, int gridRow){
        this.playerName = playerName;
        this.gridCol = gridCol;
        this.gridRow = gridRow;
        this.grid = gridCol+" x "+gridRow;
    }

    public void finishGame(long elapsedTime, int pairsWithNoLook){
        this.elapsedTime = elapsedTime;
        this.pairsWithNoLook = pairsWithNoLook;
    }

    public long getScore(){
        return (getGridCol()*getGridRow()/ elapsedTime)+pairsWithNoLook;};

    public int getGridCol() {
        return gridCol;
    }

    public int getGridRow() {
        return gridRow;
    }

    public String getGrid() {
        return grid;
    }

    public String getPlayerName() {
        return playerName;
    }

    public long getElapsedTime() {
        return elapsedTime;
    }

    public String getTimeElapsedFormatted() {
        return Helper.GetFormattedTime((int)elapsedTime);
    }
}
