package sample;

import javafx.beans.property.SimpleBooleanProperty;

import java.util.ArrayList;
import java.util.Collections;

public class MemoryGame {
    private TimeHandler timeHandler;
    private PlayerGameData playerGameData;

    private SimpleBooleanProperty gameFinished = new SimpleBooleanProperty(false);

    private ArrayList<MemoryGroup> memoryGroups = new ArrayList<>();

    private MemoryResetThread memoryResetThread = new MemoryResetThread();

    private static MemoryGame instance;

    public static MemoryGame getInstance() {
        if (instance == null) {
            instance = new MemoryGame();
        }
        return instance;
    }

    public MemoryGame(){
        memoryResetThread.start();
    }

    public MemoryResetThread getMemoryResetThread() {
        return memoryResetThread;
    }

    public SimpleBooleanProperty getGameFinished(){
        return gameFinished;
    }

    public PlayerGameData getPlayerGameData() {
        return playerGameData;
    }

    public TimeHandler getTimeHandler() {
        return timeHandler;
    }

    public ArrayList<Memory> getShuffledMemories(){
        ArrayList<Memory> memories = new ArrayList<>();

        for(var memoryGroup : memoryGroups){
            memories.add(memoryGroup.getMemories()[0]);
            memories.add(memoryGroup.getMemories()[1]);
        }

        Collections.shuffle(memories);

        return memories;
    }

    public void startGame(PlayerGameData playerGameData){
        gameFinished.set(false);

        this.playerGameData = playerGameData;

        timeHandler = new TimeHandler();
        timeHandler.start();

        Memory.firstMemoryPicked = null;
        Memory.secondMemoryPicked = null;

        memoryGroups = new ArrayList<>();
        for(int i=0;i<(playerGameData.getGridRow()*playerGameData.getGridCol())/2;i++){
            memoryGroups.add(new MemoryGroup(this));
        }
    }

    public void endGame(){
        int firstTimeGuessedCounter = 0;

        for(var memoryGroup : memoryGroups){
            if(memoryGroup.isLookedFirstTime())
                firstTimeGuessedCounter+=1;
        }

        playerGameData.finishGame(timeHandler.getSeconds().getValue(), firstTimeGuessedCounter);

        var ranking = new Ranking();
        ranking.getPlayers().add(playerGameData);
        ranking.sort();
        ranking.save();

        if(timeHandler.isInterrupted())
            timeHandler.interrupt();

        gameFinished.set(true);
    }

    public void checkWin(){
        for(var memoryGroup : memoryGroups){
            if(!memoryGroup.isGuessed())
                return;
        }

        endGame();
    }
}
