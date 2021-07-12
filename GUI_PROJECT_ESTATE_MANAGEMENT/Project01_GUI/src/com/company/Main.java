package com.company;

import com.company.App.MainMenu;
import com.company.Exceptions.TooManyThingsException;
import com.company.Helpers.Utility;
import com.company.Persons.Developer;
import com.company.Persons.Tenant;
import com.company.RentRooms.Flat;
import com.company.RentRooms.ParkingSpace;
import com.company.Threads.TenancyCheck;
import com.company.Threads.TimeHandler;
import com.company.Time.DateTime;
import com.company.Vehicles.Vehicle;

import java.util.ArrayList;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        Developer developer = new Developer("Bogdan","Żyłka","980247856372","Koszykowa 43 Warszawa",new Date(123123123123L));

        developer.buildArea(new ResidentialArea(new ArrayList<ResidentialBlock>(){
            {
                add(new ResidentialBlock(10,new ArrayList<Flat>(){
                    {
                        add(new Flat(100f));
                        add(new Flat(new Dimension(10f,30f,15f)));
                        add(new Flat(250f));
                        add(new Flat(300f));
                        add(new Flat(400f));
                        add(new Flat(new Dimension(20f,30f,20f)));
                        add(new Flat(50f));
                        add(new Flat(700f));
                        add(new Flat(440f));
                        add(new Flat(new Dimension(40f,40f,40f)));
                    }
                }));
            }
        }, new ArrayList<ParkingSpace>(){
            {
                add(new ParkingSpace(50f));
                add(new ParkingSpace(20f));
                add(new ParkingSpace(new Dimension(9f,5f,5f)));
                add(new ParkingSpace(10f));
                add(new ParkingSpace(new Dimension(7f,7f,6f)));
                add(new ParkingSpace(15f));
                add(new ParkingSpace(new Dimension(9f,9f,8f)));
                add(new ParkingSpace(new Dimension(10f,10f,10f)));
                add(new ParkingSpace(9f));
                add(new ParkingSpace(new Dimension(17f,26f,56f)));
            }
        }));

        ArrayList<Tenant> tenants = new ArrayList<Tenant>(){
            {
                add(new Tenant("Karolina","Banan","98627446372","Koszykowa 43 Warszawa",new Date(123123123123L)){});
                add(new Tenant("Kamil","Stoch","274846453632","Krakowska 1 Lublin",new Date(134123153123L)){});
                add(new Tenant("Magda","Klapek","383764290812","Zjawy 43A Poznań",new Date(122228579623L)){});
                add(new Tenant("Piotr","Żyłka","992846849045","Mickiewiczaa 23 Warszawa",new Date(121323166123L)){});
                add(new Tenant("Monika","Ratownik","738364758934","Fiołkowa 23F Białystok",new Date(122723463123L)){});
            }
        };

        ArrayList<String> itemNames = new ArrayList<String>(){{
            add("bar_stool");
            add("bassinet");
            add("bed");
            add("bed_table");
            add("carpet");
            add("cradle");
        }
        };

        ArrayList<String> vehicleNames = new ArrayList<String>(){{
            add("Delirium");
            add("Moan");
            add("Nightrunner");
            add("Nitro");
            add("Princess");
            add("Ponyboy");
        }
        };

        for(var room : Utility.getRooms()){
            try{
                var rand = (int)(Math.random() * 1);
                if(rand==0)
                    room.putItem(new Item((int)(Math.random() * 5)+5f,itemNames.get((int)(Math.random() * (itemNames.size()-1)))));
                else
                    room.putItem(new Vehicle((int)(Math.random() * 10f)+5f,vehicleNames.get((int)(Math.random() * (vehicleNames.size()-1))),10f));
            }
            catch (TooManyThingsException e){
                e.printStackTrace();
            }
        }

        DateTime dateTime = new DateTime();
        TimeHandler timeHandler = new TimeHandler(dateTime);
        TenancyCheck tenancyCheck = new TenancyCheck(dateTime);

        MainMenu mainMenu = new MainMenu(dateTime);
    }
}
