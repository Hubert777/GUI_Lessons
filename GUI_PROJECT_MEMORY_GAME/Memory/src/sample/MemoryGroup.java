package sample;

public class MemoryGroup {
    private static int id = 0;

    private final String[] icons = {
        "beer","beer1","beer2","beer3","beer4","beer5","bakery",
            "beauty", "bedtime", "beer6", "boxer", "burrito", "death",
            "fish", "meditation", "music", "nachos", "onigiri", "outer-space",
            "pizza", "protection", "rainbow", "rich", "rockstar", "sandwich",
            "spaguetti", "toast", "winner","biker"
    };

    private String iconName;

    private boolean isGuessed = false;
    private int lookCounter = 0;

    private MemoryGame memoryGame;
    private Memory[] memories;

    public MemoryGroup(MemoryGame memoryGame){
        this.memoryGame = memoryGame;
        memories = new Memory[]{new Memory(id,this), new Memory(id,this)};

        if(id<icons.length){
            iconName = icons[id];
        }

        id+=1;
    }

    public boolean isLookedFirstTime(){
        return lookCounter < 2;
    }

    public boolean isGuessed(){
        return isGuessed;
    }

    public String getIconName() {
        return iconName+".png";
    }

    public Memory[] getMemories() {
        return memories;
    }

    public void look(){
        lookCounter += 1;
    }

    public void setGuessed(){
        isGuessed = true;

        memoryGame.checkWin();
    }

    public MemoryGame getMemoryGame() {
        return memoryGame;
    }
}
