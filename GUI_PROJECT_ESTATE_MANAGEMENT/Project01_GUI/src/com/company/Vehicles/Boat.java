package com.company.Vehicles;

import com.company.Dimension;

public class Boat extends Vehicle {
    private float maxSpeed;
    public Boat(float area, String name, float engineCapacity, float maxSpeed) {
        super(area, name, engineCapacity);
        this.maxSpeed = maxSpeed;
    }

    public Boat(Dimension dimension,String name, float engineCapacity, float maxSpeed) {
        super(dimension,name, engineCapacity);
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "Boat{" +
                "area=" + area +
                ", name='" + name + '\'' +
                ", maxSpeed=" + maxSpeed +
                ", engineCapacity=" + engineCapacity +
                '}';
    }
}
