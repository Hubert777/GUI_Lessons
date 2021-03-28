package com.company;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat(10);
        Dog dog = new Dog(14);
        Cow cow = new Cow(4);

        Animal[] animals = {cat, dog, cow};

        for (Animal z : animals) {
            System.out.println("Voice: " + z.getVoice() + " age: " + z.age());
        }

        Singer s1 = new Singer("Eminem") {
            @Override
            protected String sing() {
                return "You own it, you better never let it";
            }
        };
        Singer s2 = new Singer("Eagles") {
            @Override
            protected String sing() {
                return "Hotel California";
            }
        };
        Singer s3 = new Singer("Dżem") {
            @Override
            protected String sing() {
                return "Chwila, która trwa może być najlepszą z Twoich chwil...";
            }
        };

        Singer sp[] = {s1, s2, s3};
        for (Singer s : sp) System.out.println(s);
        System.out.println("\n" + Singer.loudest(sp) + "\n");

        try {
            Square sq1 = new Square(5);
            Square sq2 = new Square(4);
            Square sq3 = new Square(2);
            Square sq4 = new Square(3);
            Square sq5 = new Square(1);

            Square[] squares = {sq1, sq2, sq3, sq4, sq5};

            for (Square sq : squares) System.out.println(sq);
            Arrays.sort(squares);
            for (Square sq : squares) System.out.println(sq);
        } catch (TooBigSquareException e) {
            e.printStackTrace();
        }
    }
}

interface Figure{
    public final int max = 6;

    public int getArea();
    public int getParameter();
}

class TooBigSquareException extends Exception{
    public TooBigSquareException(int max){
        super("Maximum length is: "+max);
    }
}

class Square implements Figure,Comparable<Square>{
    private int length;

    public Square(int length) throws TooBigSquareException{
        if(length>max)
            throw new TooBigSquareException(max);
        this.length = length;
    }

    @Override
    public int compareTo(Square o) {
        if(o.getParameter()<getParameter())
            return 1;
        if(o.getParameter()==getParameter())
            return 0;
        return -1;
    }

    @Override
    public int getArea() {
        return length*length;
    }

    @Override
    public int getParameter() {
        return length*4;
    }

    @Override
    public String toString() {
        return "Square{" +
                "length=" + length +
                '}';
    }
}

abstract class Singer{
    private static int startNumber=1;

    private String surname;

    public Singer(String surname){
        this.surname = surname;
    }

    public static Singer loudest(Singer[] singers){
        int len = 0;
        Singer loudestSinger = new Singer("Undefined") {
            @Override
            protected String sing() {
                return null;
            }
        };
        for(int i=1;i<singers.length;i++){
            String sing = singers[i].sing();
            int bigLetters = 0;
            for (int j=0;j<sing.length();j++){
                if(Character.isUpperCase(sing.charAt(j)))
                    bigLetters+=1;
            }
            if(bigLetters>len)
                loudestSinger = singers[i];
        }
        return loudestSinger;
    }

    @Override
    public String toString() {
        return surname +": "+sing();
    }

    protected abstract String sing();
}

interface Animal {
    String getVoice();
    int age();
}

class Cat implements Animal{
    private int age;
    private final String voice = "Miau!";

    public Cat(int age){
        this.age = age;
    }

    @Override
    public String getVoice() {
        return voice;
    }

    @Override
    public int age() {
        return age;
    }
}

class Dog implements Animal{
    private int age;
    private final String voice = "Hau!";

    public Dog(int age){
        this.age = age;
    }

    @Override
    public String getVoice() {
        return voice;
    }

    @Override
    public int age() {
        return age;
    }
}

class Cow implements Animal{
    private int age;
    private final String voice = "Muu!";

    public Cow(int age){
        this.age = age;
    }

    @Override
    public String getVoice() {
        return voice;
    }

    @Override
    public int age() {
        return age;
    }
}