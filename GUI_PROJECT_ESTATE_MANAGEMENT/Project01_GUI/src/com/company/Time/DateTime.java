package com.company.Time;

public class DateTime {
    private int day = 1;

    public void addDay(){
        System.out.println("New day!");
        day+=1;
    }

    public int getDay(){
        return day;
    }
}
