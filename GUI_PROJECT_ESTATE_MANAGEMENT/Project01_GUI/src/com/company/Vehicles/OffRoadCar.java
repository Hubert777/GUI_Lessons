package com.company.Vehicles;

import com.company.Dimension;

public class OffRoadCar extends Vehicle {
    private boolean fourByFour;

    public OffRoadCar(float area, String name, float engineCapacity, boolean fourByFour) {
        super(area, name, engineCapacity);
        this.fourByFour = fourByFour;
    }

    public OffRoadCar(Dimension dimension,String name, float engineCapacity, boolean fourByFour) {
        super(dimension,name, engineCapacity);
        this.fourByFour = fourByFour;
    }

    @Override
    public String toString() {
        return "OffRoadCar{" +
                "area=" + area +
                ", name='" + name + '\'' +
                ", fourByFour=" + fourByFour +
                ", engineCapacity=" + engineCapacity +
                '}';
    }
}
