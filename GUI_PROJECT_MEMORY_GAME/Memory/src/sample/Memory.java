package sample;

import javafx.beans.property.SimpleBooleanProperty;

public class Memory {
    public static Memory firstMemoryPicked;
    public static Memory secondMemoryPicked;

    private static boolean blocked = false;

    private int id;

    private SimpleBooleanProperty hide = new SimpleBooleanProperty(true);

    private MemoryGroup memoryGroup;

    public Memory(int id, MemoryGroup memoryGroup){
        this.id = id;
        this.memoryGroup = memoryGroup;
    }

    public SimpleBooleanProperty getHide(){
        return hide;
    }

    public MemoryGroup getMemoryGroup() {
        return memoryGroup;
    }

    public static void reset(){
        if(blocked){
            if(!firstMemoryPicked.memoryGroup.isGuessed()){
                if(firstMemoryPicked!=null)
                    firstMemoryPicked.hide.set(true);
                if(secondMemoryPicked!=null)
                    secondMemoryPicked.hide.set(true);
            }

            if(firstMemoryPicked!=null)
                firstMemoryPicked = null;

            if(secondMemoryPicked!=null)
                secondMemoryPicked = null;

            blocked = false;
        }
    }

    public void pick() throws InterruptedException {
        if(!memoryGroup.isGuessed()){
            if(blocked)
                reset();

            if(firstMemoryPicked == this){
                firstMemoryPicked.hide.set(true);
                firstMemoryPicked = null;
                return;
            }
            else if(secondMemoryPicked == this){
                secondMemoryPicked.hide.set(true);
                secondMemoryPicked = null;
                return;
            }

            if(firstMemoryPicked==null){
                firstMemoryPicked = this;
                firstMemoryPicked.hide.set(false);
            }
            else if(secondMemoryPicked==null){
                secondMemoryPicked = this;
                secondMemoryPicked.hide.set(false);

                guessCheck();
            }
        }
    }

    private void guessCheck() {
        if(firstMemoryPicked.id == secondMemoryPicked.id){
            firstMemoryPicked.memoryGroup.setGuessed();

            firstMemoryPicked.memoryGroup.look();

            firstMemoryPicked = null;
            secondMemoryPicked = null;

            return;
        }
        else {
            firstMemoryPicked.memoryGroup.look();
            secondMemoryPicked.memoryGroup.look();
        }

        blocked = true;
        MemoryGame.getInstance().getMemoryResetThread().resetThread();
    }
}