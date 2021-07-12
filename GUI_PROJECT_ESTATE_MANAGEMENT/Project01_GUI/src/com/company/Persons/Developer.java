package com.company.Persons;

import com.company.Helpers.PeopleHolder;
import com.company.ResidentialArea;

import java.util.ArrayList;
import java.util.Date;

public class Developer extends Person{
    private ArrayList<ResidentialArea> residentialAreas = new ArrayList<>();

    public ArrayList<ResidentialArea> getResidentialAreas() {
        return residentialAreas;
    }

    public Developer(String name, String surname, String socialSecurityNumber, String address, Date birthDate){
        super(name,surname,socialSecurityNumber,address,birthDate);
        PeopleHolder.developers.add(this);
    }

    public void buildArea(ResidentialArea area){
        residentialAreas.add(area);
    }

    @Override
    public String toString() {
        return "Developer{" +
                "residentialAreas=" + residentialAreas +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", socialSecurityNumber='" + socialSecurityNumber + '\'' +
                ", address='" + address + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
