package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Hero h1 = new Hero("Jan", 50);
        Leader l1 = new Leader("Eagle", 20);
        Hero h3 = (Hero)l1;

        h1.sayHelloTo(h3);
        h3.sayHelloTo(h1);

        Squad s = new Squad("DELTA");

        s.setLeader(l1);
        try{
            s.addHero(h1);
        }
        catch(TooManyHeroesException e){
            e.printStackTrace();
        }

        System.out.println(s);
    }
}

class TooManyHeroesException extends Exception{
    public TooManyHeroesException(String message){
        super(message);
    }
}

class Squad{
    private String name;

    private int length = 5;
    private int index = 0;

    private Hero[] squad;
    private Leader leader;

    public Squad(String name){
        this.name = name;
        squad = new Hero[length];
        leader = new Leader("Unknown",0);
    }

    public void addHero(Hero hero) throws TooManyHeroesException{
        if(index<length){
            squad[index] = hero;
            index+=1;
        }
        else
            throw new TooManyHeroesException("Too many heroes!");
    }

    public void setLeader(Leader leader){
        this.leader = leader;
    }

    @Override
    public String toString() {
        return "Squad{" +
                "name='" + name + '\'' +
                ", length=" + length +
                ", index=" + index +
                ", squad=" + Arrays.toString(squad) +
                ", leader=" + leader +
                '}';
    }
}

class Hero{
    private String name;
    private int age;

    public Hero(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void sayHelloTo(Hero hero){
        System.out.println(name+" says hello to: "+ hero.name+"!");
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class Leader extends Hero{
    public Leader(String name, int age){
        super(name,age);
    }
}
