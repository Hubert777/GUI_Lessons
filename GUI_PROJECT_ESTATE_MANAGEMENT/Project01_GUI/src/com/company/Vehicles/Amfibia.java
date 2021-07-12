package com.company.Vehicles;

import com.company.Dimension;

public class Amfibia extends Vehicle {
    private boolean hasWinch;

    public Amfibia(float area, String name,float engineCapacity, boolean hasWinch) {
        super(area, name,engineCapacity);
        this.hasWinch = hasWinch;
    }

    public Amfibia(Dimension dimension,String name,float engineCapacity, boolean hasWinch) {
        super(dimension,name, engineCapacity);
        this.hasWinch = hasWinch;
    }

    @Override
    public String toString() {
        return "Amfibia{" +
                "area=" + area +
                ", name='" + name + '\'' +
                ", hasWinch=" + hasWinch +
                ", engineCapacity=" + engineCapacity +
                '}';
    }
}
