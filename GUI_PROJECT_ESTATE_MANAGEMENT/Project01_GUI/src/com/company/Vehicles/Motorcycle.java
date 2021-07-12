package com.company.Vehicles;

import com.company.Dimension;

public class Motorcycle extends Vehicle {
    private float noiseFactor;

    public Motorcycle(float area, String name, float engineCapacity, float noiseFactor) {
        super(area, name, engineCapacity);
        this.noiseFactor = noiseFactor;
    }

    public Motorcycle(Dimension dimension,String name, float engineCapacity, float noiseFactor) {
        super(dimension, name, engineCapacity);
        this.noiseFactor = noiseFactor;
    }

    @Override
    public String toString() {
        return "Motorcycle{" +
                "area=" + area +
                ", name='" + name + '\'' +
                ", noiseFactor=" + noiseFactor +
                ", engineCapacity=" + engineCapacity +
                '}';
    }
}
