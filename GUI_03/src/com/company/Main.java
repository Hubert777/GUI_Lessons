package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        //1.0
        Guppy guppy = new Guppy();
        Duck duck = new Duck();
        Emu emu = new Emu();
        Human human = new Human();
        System.out.println(guppy.toString());
        System.out.println(duck.toString());
        System.out.println(emu.toString());
        System.out.println(human.toString());

        //2.0
        ICalc myAdd = (x,y)->{return x+y;};
        ICalc mySubstract = (x,y)->{return x-y;};
        ICalc myMultiply = (x,y)->{return x*y;};
        ICalc myDivide = (x,y)->{return x/y;};

        System.out.println(myAdd.count(2.3,4.5));
        System.out.println(mySubstract.count(2.3,4.5));
        System.out.println(myMultiply.count(2.3,4.5));
        System.out.println(myDivide.count(2.3,4.5));

        //3.0
        int len = 10;
        double[] myTab = new double[len];
        for(int i = 0;i<len;i++){
            myTab[i] = (double)Math.random()*100;
        }

        System.out.println(Arrays.toString(myTab));
        System.out.println(Arrays.toString(Calc.calculate(myTab,myAdd)));

        //4.0
        CountingList list = new CountingList();
        list.add("Ala ma kota");

        System.out.println(list.get(0));
        System.out.println(list.count(0));

        //5.0
        list.clear();
        list.add("Ala");
        list.add("ma");
        list.add("kota");
        list.printTextList();
        list.sortByTextLength();
        list.printTextList2();
    }
}

//4.0,5.0
class CountingList{
    ArrayList<String> arrayList;

    public CountingList(){
        arrayList = new ArrayList<String>();
    }

    public ArrayList<String> getArrayList(){
        return arrayList;
    }

    public void add(String inscription){
        arrayList.add(inscription);
    }

    public String get(int index){
        return arrayList.get(index);
    }

    public int count(int index){
        return arrayList.get(index).length();
    }

    public void printTextList(){
        arrayList.forEach(x->System.out.println(x));
    }

    public void printTextList2(){
        arrayList.forEach(System.out::println);
    }

    public void sortByTextLength(){
        arrayList.sort(Comparator.comparing(String::length));
    }

    public void clear(){
        arrayList.clear();
    }
}

//3.0
class Calc{
    public static double[] calculate(double[] list,ICalc iCalc){
        double[] resultTab = new double[list.length/2];

        for (int i = 0;i<resultTab.length;i+=1){
            resultTab[i] = iCalc.count(list[i*2],list[i*2+1]);
        }

        return resultTab;
    }
}


//2.0
interface ICalc{
    public double count(double num1,double num2);
}

//1.0
class Guppy implements IFish{
    @Override
    public String toString() {
        return super.toString()+" "+swim();
    }
}

class Duck implements IBird,IFish{
    @Override
    public String toString() {
        return super.toString()+" "+swim()+" "+fly();
    }
}

class Emu implements IBird,IRunner{
    @Override
    public String toString() {
        return super.toString()+" "+fly()+" "+run();
    }
}

class Human implements IBird,IFish,IRunner{
    @Override
    public String toString() {
        return super.toString()+" "+fly()+" "+swim()+" "+run();
    }
}

interface IBird{
    default String fly(){
        return "I can fly!";
    }
}

interface IFish{
    default String swim(){
        return "I can swim!";
    }
}

interface IRunner{
    default String run(){
        return "I can run!";
    }
}
