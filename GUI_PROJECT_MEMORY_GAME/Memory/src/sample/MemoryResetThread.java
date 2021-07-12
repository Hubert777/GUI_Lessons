package sample;

class MemoryResetThread extends Thread{
    private final long WAIT_TO_RESET_MILLIS = 1000;

    boolean reset = false;
    boolean check = false;

    private long startClock;

    public void run(){
        while(true){
            synchronized (this){
                check = true;

                while(System.currentTimeMillis()-startClock <= WAIT_TO_RESET_MILLIS){
                    check = false;
                }

                if(!reset && check){
                    Memory.reset();
                    reset = true;
                }
            }
        }
    }

    public void resetThread(){
        synchronized (this){
            reset = false;
            startClock = System.currentTimeMillis();
        }
    }
}