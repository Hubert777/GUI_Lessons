package com.company.Persons;

import com.company.Helpers.PeopleHolder;

import java.util.Date;

public abstract class Person {
    protected static int idCounter = 0;
    protected int id;
    protected String name;
    protected String surname;
    protected String socialSecurityNumber;
    protected String address;
    protected Date birthDate;

    public Person(String name,String surname,String socialSecurityNumber,String address,Date birthDate){
        id = idCounter++;
        this.name = name;
        this.surname = surname;
        this.socialSecurityNumber = socialSecurityNumber;
        this.address = address;
        this.birthDate = birthDate;

        PeopleHolder.persons.add(this);

        System.out.println("Created: "+toString());
    }

    public int getId() {return id; }
    public String getName() {return name;}
    public String getSurname() {return surname;}
    public Date getBirthDate() {return birthDate;}
    public String getAddress() {
        return address;
    }
    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id + '\'' +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", socialSecurityNumber='" + socialSecurityNumber + '\'' +
                ", address='" + address + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
