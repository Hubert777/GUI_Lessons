package sample;

import javafx.beans.property.SimpleIntegerProperty;

public class TimeHandler extends Thread{
    private SimpleIntegerProperty seconds = new SimpleIntegerProperty(0);

    public SimpleIntegerProperty getSeconds() {
        return seconds;
    }

    public void run(){
        while (true){
            try {
                this.sleep(1000);
                addSecond();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void addSecond(){
        seconds.set(seconds.getValue()+1);
    }
}
