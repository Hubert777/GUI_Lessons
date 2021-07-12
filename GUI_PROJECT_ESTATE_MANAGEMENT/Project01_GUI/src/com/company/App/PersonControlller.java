package com.company.App;

import com.company.Helpers.PeopleHolder;
import com.company.Persons.Tenant;

import java.util.Scanner;

public class PersonControlller {
    private MainMenu mainMenu;

    private Tenant currentPerson;

    public PersonControlller(MainMenu mainMenu){
        this.mainMenu = mainMenu;
    }

    public void choosePerson(){
        PeopleHolder.tenants.forEach(System.out::println);
        System.out.println("Pick an id number to choose, or press 0 to back to main menu");

        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();

        switch(num){
            case 0:{
                mainMenu.enableMainMenu();
                break;
            }
        }

        boolean check = false;
        for(var person : PeopleHolder.tenants){
            if(person.getId() == num){
                currentPerson = person;
                check = true;
            }
        }

        if(!check){
            System.out.println("You choosed a bad id number. Try again.");
            choosePerson();
        }
        else
            mainMenu.enableMainMenu();
    }

    public void printPersonInfo(){
        if(currentPerson==null){
            System.out.println("You haven't choose person!");
            mainMenu.enableMainMenu();
        }
        else{
            System.out.println(currentPerson.toString());
            System.out.println("Press 0 to back to main menu");

            Scanner scan = new Scanner(System.in);
            int num = scan.nextInt();

            if(num == 0)
                mainMenu.enableMainMenu();
            else
                printPersonInfo();
        }
    }

    public Tenant getCurrentPerson() {
        return currentPerson;
    }
}
