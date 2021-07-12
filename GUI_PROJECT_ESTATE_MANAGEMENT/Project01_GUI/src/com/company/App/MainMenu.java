package com.company.App;

import com.company.Helpers.PeopleHolder;
import com.company.Time.DateTime;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MainMenu {
    PersonControlller personControlller = new PersonControlller(this);
    RentController rentController = new RentController(this);
    ItemController itemController = new ItemController(this);
    DateTime dateTime;

    public MainMenu(DateTime dateTime){
        this.dateTime = dateTime;
        enableMainMenu();
    }

    public void enableMainMenu(){
        System.out.println("#MAIN MENU");
        System.out.println("Press number to manage");
        System.out.println("1. Choose person.");
        System.out.println("2. Print person infos");
        System.out.println("3. Print free estates");
        System.out.println("4. Rent estate");
        System.out.println("5. Show owned estates");
        System.out.println("6. Add items");
        System.out.println("7. Remove items");
        System.out.println("8. Write current state to file");
        System.out.println("9. Quit");

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter any number: ");
        int num = scan.nextInt();

        switch(num){
            case 1:{
                personControlller.choosePerson();
                break;
            }
            case 2:{
                personControlller.printPersonInfo();
                break;
            }
            case 3:{
                rentController.printFreeRooms();
                afterAction();
                break;
            }
            case 4:{
                rentController.rentRoom();
                break;
            }
            case 5:{
                rentController.showRentedRooms();
                break;
            }
            case 6:{

                break;
            }
            case 7:{
                break;
            }
            case 8:{
                try{
                    FileWriter fw = new FileWriter("currentState.txt");
                    fw.write("CURRENT STATE OF ESTATES.");
                    for(var dev : PeopleHolder.developers){
                        for(var area : dev.getResidentialAreas()) {
                            fw.write(area.toString());
                            for(var parkingSpace : area.getParkingSpaces())
                                fw.write(parkingSpace.toString());
                            for(var block : area.getResidentialBlocks()){
                                for(var flat : block.getFlats())
                                    fw.write(flat.toString());
                            }
                        }
                    }
                    fw.close();
                    afterAction();
                }
                catch(IOException e){
                    e.printStackTrace();
                }
                break;
            }
            case 9: {
                System.exit(0);
                break;
            }
        }
    }

    public void afterAction(){
        System.out.println("Press 0 to back to main menu");

        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();

        if(num == 0)
            enableMainMenu();
        else
            afterAction();
    }

    public PersonControlller getPersonControlller() {
        return personControlller;
    }

    public RentController getRentController() {
        return rentController;
    }

    public DateTime getDateTime() {
        return dateTime;
    }
}
