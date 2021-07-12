package sample;

public class Helper {
    public static String GetFormattedTime(int seconds){
        int minutes = seconds/60;

        String newMinutes = minutes > 9 ? Integer.toString(minutes) : "0"+Integer.toString(minutes);

        String newSeconds = "00";
        int secsWithoutMinutes = seconds-(minutes*60);

        if(secsWithoutMinutes>0)
            newSeconds = secsWithoutMinutes > 9 ? Integer.toString(secsWithoutMinutes) : "0"+secsWithoutMinutes;

        return newMinutes+":"+newSeconds;
    }
}
