package sample;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

public class Ranking implements Serializable {
    private ArrayList<PlayerGameData> players = new ArrayList<>();

    public ArrayList<PlayerGameData> getPlayers() {
        return players;
    }

    public Ranking(){
        initialize();
    }

    public void initialize(){
        try{
            FileInputStream fis = new FileInputStream("Ranking.obj");

            try (ObjectInputStream inputStream = new ObjectInputStream(fis)) {
                Ranking ranking = (Ranking) inputStream.readObject();

                for(var playerGameData : ranking.getPlayers()){
                    players.add(playerGameData);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        catch (FileNotFoundException e){
            try{
                FileOutputStream fis = new FileOutputStream("Ranking.obj");
            }
            catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        }
    }

    public void sort(){
        players.sort(new Comparator<PlayerGameData>() {
            @Override
            public int compare(PlayerGameData o1, PlayerGameData o2) {
                return Long.compare(o1.getScore(),o2.getScore());
            }
        });
    }

    public void save() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("Ranking.obj"))) {
            outputStream.writeObject(this);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
