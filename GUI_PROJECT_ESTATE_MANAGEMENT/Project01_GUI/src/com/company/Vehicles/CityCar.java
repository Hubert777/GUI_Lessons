package com.company.Vehicles;

import com.company.Dimension;

public class CityCar extends Vehicle {
    private float fuelUsage;

    public CityCar(float area, String name, float engineCapacity,float fuelUsage) {
        super(area, name, engineCapacity);
        this.fuelUsage = fuelUsage;
    }

    public CityCar(Dimension dimension,String name, float engineCapacity, float fuelUsage) {
        super(dimension,name,engineCapacity);
        this.fuelUsage = fuelUsage;
    }

    @Override
    public String toString() {
        return "CityCar{" +
                "area=" + area +
                ", name='" + name + '\'' +
                ", fuelUsage=" + fuelUsage +
                ", engineCapacity=" + engineCapacity +
                '}';
    }
}
