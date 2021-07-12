package com.company;

public class Dimension {
    private float height;
    private float width;
    private float length;

    public float getArea(){return height*width*length;}

    public Dimension(float height,float width,float length){
        this.height = height;
        this.width = width;
        this.length = length;
    }
}
