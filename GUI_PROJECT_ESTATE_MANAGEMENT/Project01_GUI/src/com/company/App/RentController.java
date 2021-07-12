package com.company.App;

import com.company.Helpers.Utility;
import java.util.Scanner;

public class RentController {
    private MainMenu mainMenu;

    public RentController(MainMenu mainMenu){
        this.mainMenu = mainMenu;
    }

    public boolean printFreeRooms(){
        boolean anyRooms=false;
        for(var room : Utility.getRooms()){
            if(room.getTenancyInfo()==null || room.getTenancyInfo().getTenant()==null){
                System.out.println(room.toString());
                anyRooms = true;
            }
        }

        if(!anyRooms)
            System.out.println("There are no estates available!");

        return anyRooms;
    }

    public void rentRoom(){
        if(printFreeRooms()){
            System.out.println("Pick id number to rent estate or 0 to back to main menu");

            Scanner scan = new Scanner(System.in);
            int num = scan.nextInt();

            if(num==0){
                mainMenu.enableMainMenu();
                return;
            }

            boolean finded = false;
            for(var room : Utility.getRooms()){
                if(room.getId() == num) {
                    System.out.println("Press number of days you want to rent for: ");

                    scan = new Scanner(System.in);
                    num = scan.nextInt();

                    if(mainMenu.personControlller.getCurrentPerson().Rent(mainMenu.getDateTime().getDay(), mainMenu.getDateTime().getDay()+num,room)){
                        mainMenu.enableMainMenu();
                        return;
                    }
                }
            }

            rentRoom();
        }
        else{
            mainMenu.enableMainMenu();
        }
    }

    public void showRentedRooms(){
        if(mainMenu.personControlller.getCurrentPerson()==null){
            System.out.println("No person selected! Automatically going to main menu.");
            mainMenu.enableMainMenu();
        }
        else{
            System.out.println(mainMenu.personControlller.getCurrentPerson().getRentedFlats().toString());
            System.out.println(mainMenu.personControlller.getCurrentPerson().getRentedParkingSpaces().toString());
            System.out.println("Pick id number of estate to show more info or press 0 to back to main menu");

            Scanner scan = new Scanner(System.in);
            int num = scan.nextInt();

            if(num==0){
                mainMenu.enableMainMenu();
                return;
            }

            for(var flat : mainMenu.personControlller.getCurrentPerson().getRentedFlats()){
                if(flat.getId() == num){
                    System.out.println(flat.toString());
                    showRentedRoomsBehavior();
                    return;
                }
            }

            for(var parkingSpace : mainMenu.personControlller.getCurrentPerson().getRentedParkingSpaces()){
                if(parkingSpace.getId() == num){
                    System.out.println(parkingSpace.toString());
                    showRentedRoomsBehavior();
                    return;
                }
            }

            System.out.println("You pick an invalid id number! Try again.");
            showRentedRoomsBehavior();
        }
    }

    private void showRentedRoomsBehavior(){
        System.out.println("Press 1 to show rented rooms or 0 to back to main menu");
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();

        if(num==0)
            mainMenu.enableMainMenu();
        else if(num==1)
            showRentedRooms();
        else
            showRentedRoomsBehavior();
    }
}
