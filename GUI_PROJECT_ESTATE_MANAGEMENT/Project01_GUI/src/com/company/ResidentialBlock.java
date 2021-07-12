package com.company;

import com.company.RentRooms.Flat;

import java.util.ArrayList;

public class ResidentialBlock {
    private int maxFlats;
    private ArrayList<Flat> flats = new ArrayList<Flat>();
    
    public ArrayList<Flat> getFlats() {return flats;}

    public ResidentialBlock(int maxFlats, ArrayList<Flat> flats){
        this.maxFlats = maxFlats;
        this.flats = flats;
    }

    @Override
    public String toString() {
        return "ResidentialBlock{" +
                "maxFlats=" + maxFlats +
                ", flats=" + flats +
                '}';
    }
}
