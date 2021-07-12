package com.company;

public class Item {
    protected float area;
    protected String name;

    public Item(float area,String name){
        this.area = area;
        this.name = name;

        System.out.println("Created: "+toString());
    }

    public Item(Dimension dimension,String name){
        this.area = dimension.getArea();
        this.name = name;

        System.out.println("Created: "+toString());
    }

    public String getName() {
        return name;
    }

    public float getArea() {
        return area;
    }

    @Override
    public String toString() {
        return "Item{" +
                "area=" + area +
                ", name='" + name + '\'' +
                '}';
    }
}
