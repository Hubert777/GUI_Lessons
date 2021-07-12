package com.company.Persons;

import com.company.DebtLetter;
import com.company.Exceptions.ProblematicTenantException;
import com.company.Exceptions.TooManyThingsException;
import com.company.Helpers.PeopleHolder;
import com.company.Interfaces.IRent;
import com.company.RentRooms.BaseRoom;
import com.company.RentRooms.Flat;
import com.company.Interfaces.IManageParkingSpace;
import com.company.Interfaces.IRegister;
import com.company.Item;
import com.company.RentRooms.ParkingSpace;
import com.company.TenancyInfo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Tenant extends Person implements IRegister, IManageParkingSpace {
    private ArrayList<Flat> rentedFlats = new ArrayList<>();
    private ArrayList<ParkingSpace> rentedParkingSpaces = new ArrayList<>();
    private ArrayList<DebtLetter> debtLetters = new ArrayList<>();
    
    public Tenant(String name, String surname, String socialSecurityNumber, String address, Date birthDate){
        super(name,surname,socialSecurityNumber,address,birthDate);
        PeopleHolder.tenants.add(this);
    }

    public ArrayList<DebtLetter> getDebtLetters() {
        return debtLetters;
    }
    public ArrayList<Flat> getRentedFlats() {return rentedFlats;}
    public ArrayList<ParkingSpace> getRentedParkingSpaces() {return rentedParkingSpaces; }

    public boolean canRent(){
        return rentedFlats.size() + rentedParkingSpaces.size() < 5;
    }

    public boolean Rent(int startDate,int endDate,BaseRoom baseRoom){
        try{
            if(baseRoom.rent(new TenancyInfo(this,startDate,endDate))){
                return true;
            }
            return false;
        }
        catch (ProblematicTenantException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void Register(Flat flat, Person person) {
        for(var f : rentedFlats){
            if(f == flat){
                flat.Register(person);
                System.out.println("Registered: "+person.toString());
                return;
            }
        }
        System.out.println(toString() + " doesn't own this flat!");
    }

    @Override
    public void Unregister(Flat flat, Person person) {
        for(var f : rentedFlats){
            if(f == flat){
                flat.Unregister(person);
                System.out.println("Unregistered: "+person.toString());
                return;
            }
        }
        System.out.println(toString() + " doesn't own this flat!");
    }

    @Override
    public void addItem(Item item, ParkingSpace parkingSpace) {
        try{
            if(rentedParkingSpaces.contains(parkingSpace)){
                parkingSpace.putItem(item);
                System.out.println(getName()+" puts: "+item.getName()+" into "+parkingSpace.toString());
            }
            else
                System.out.println(toString() + " doesn't rent"+parkingSpace.toString());
        }
        catch(TooManyThingsException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeItem(Item item, ParkingSpace parkingSpace) {
        if(rentedParkingSpaces.contains(parkingSpace)){
            parkingSpace.removeItem(item);
            System.out.println(getName()+" removed: "+item.getName()+" from "+parkingSpace.toString());
        }
        else
            System.out.println(toString() + " doesn't rent parking space of ID: "+parkingSpace.getId());
    }

    @Override
    public String toString() {
        return "Tenant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", socialSecurityNumber='" + socialSecurityNumber + '\'' +
                ", address='" + address + '\'' +
                ", birthDate=" + birthDate +
                ", rentedFlats=" + rentedFlats +
                ", rentedParkingSpaces=" + rentedParkingSpaces +
                ", debtLetters=" + debtLetters +
                '}';
    }
}
