package com.company.Interfaces;

import com.company.RentRooms.Flat;
import com.company.Persons.Person;

public interface IRegister {
    void Register(Flat flat, Person person);
    void Unregister(Flat flat, Person person);
}
