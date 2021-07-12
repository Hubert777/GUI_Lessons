package com.company.Interfaces;

import com.company.Item;
import com.company.RentRooms.ParkingSpace;

public interface IManageParkingSpace {
    void addItem(Item item, ParkingSpace parkingSpace);
    void removeItem(Item item, ParkingSpace parkingSpace);
}
