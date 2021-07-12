package com.company.Vehicles;

import com.company.Dimension;
import com.company.Item;

public class Vehicle extends Item {
    protected float engineCapacity;

    public Vehicle(float area, String name,float engineCapacity) {
        super(area, name);
        this.engineCapacity = engineCapacity;
    }

    public Vehicle(Dimension dimension, String name,float engineCapacity) {
        super(dimension, name);
        this.engineCapacity = engineCapacity;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "area=" + area +
                ", name='" + name + '\'' +
                ", engineCapacity=" + engineCapacity +
                '}';
    }
}
