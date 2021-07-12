package com.company.Threads;

import com.company.Helpers.PeopleHolder;
import com.company.Time.DateTime;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimeHandler extends TimerTask {
    private DateTime dateTime;

    public TimeHandler(DateTime dateTime){
        this.dateTime = dateTime;
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(this, new Date(), 5000);
    }

    public synchronized void run(){
        dateTime.addDay();
        PeopleHolder.tenants.forEach(x->x.getDebtLetters().forEach(y->y.nextDay()));
    }
}
