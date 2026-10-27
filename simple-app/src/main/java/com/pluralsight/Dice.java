package com.pluralsight;

public class Dice {

    public int minValue;
    public int maxValue;


    public Dice(){
        minValue = 1;
        maxValue = 6;
    }

    public Dice(int numberOfSides){
        minValue = 1;
        maxValue = numberOfSides;
    }

    public int roll(){

        return (int)(Math.random() * (maxValue - minValue + 1)) + minValue;
    }

}
