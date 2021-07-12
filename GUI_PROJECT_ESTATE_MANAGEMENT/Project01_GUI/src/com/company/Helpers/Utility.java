package com.company.Helpers;

import com.company.RentRooms.BaseRoom;
import com.company.RentRooms.Flat;
import com.company.RentRooms.ParkingSpace;
import com.company.ResidentialArea;

import java.util.ArrayList;

public class Utility {
    public static ResidentialArea getContainingArea(ParkingSpace space){
        for(var dev : PeopleHolder.developers){
            for(var area : dev.getResidentialAreas()){
                if(area.getParkingSpaces().contains(space))
                    return area;
            }
        }
        return null;
    }

    public static ResidentialArea getContainingArea(Flat flat){
        for(var dev : PeopleHolder.developers){
            for(var area : dev.getResidentialAreas()){
                for(var block : area.getResidentialBlocks())
                    if(block.getFlats().contains(flat))
                        return area;
            }
        }
        return null;
    }

    public static ArrayList<BaseRoom> getRooms(){
        ArrayList<BaseRoom> rooms = new ArrayList<>();

        for(var dev: PeopleHolder.developers){
            for(var areas:dev.getResidentialAreas()){
                areas.getParkingSpaces().forEach(x->rooms.add(x));
                for(var block : areas.getResidentialBlocks())
                    block.getFlats().forEach(x->rooms.add(x));
            }
        }
        return rooms;
    }
}
