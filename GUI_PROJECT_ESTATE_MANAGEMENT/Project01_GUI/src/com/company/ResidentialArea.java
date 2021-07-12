package com.company;

import com.company.RentRooms.ParkingSpace;

import java.util.ArrayList;

public class ResidentialArea {
    private ArrayList<ResidentialBlock> residentialBlocks = new ArrayList<ResidentialBlock>();
    private ArrayList<ParkingSpace> parkingSpaces = new ArrayList<ParkingSpace>();

    public ArrayList<ParkingSpace> getParkingSpaces() {return parkingSpaces;}
    public ArrayList<ResidentialBlock> getResidentialBlocks() {return residentialBlocks;}

    public ResidentialArea(ArrayList<ResidentialBlock> residentialBlocks,ArrayList<ParkingSpace> parkingSpaces){
        this.residentialBlocks = residentialBlocks;
        this.parkingSpaces = parkingSpaces;
    }

    @Override
    public String toString() {
        return "ResidentialArea{" +
                "residentialBlocks=" + residentialBlocks +
                ", parkingSpaces=" + parkingSpaces +
                '}';
    }
}
