package com.company.Threads;

import com.company.DebtLetter;
import com.company.Helpers.Utility;
import com.company.Time.DateTime;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TenancyCheck extends TimerTask {
    private DateTime dateTime;
    private int debtCounter = 0;
    public TenancyCheck(DateTime dateTime){
        this.dateTime = dateTime;
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(this, new Date(), 10000);
    }

    public synchronized void run(){
        var rooms = Utility.getRooms();

        for(var room : rooms) {
            if(room.getTenancyInfo()!=null){
                if(dateTime.getDay() > room.getTenancyInfo().getEndTenancy()){
                    room.getTenancyInfo().getTenant().getDebtLetters().add(new DebtLetter("debt#"+debtCounter+".txt",room.getTenancyInfo(),room));
                }
            }
        }
    }
}
