package com.snoott.android5;
import java.io.Serializable;
public class  Human implements Serializable {

    private String name;
    private double weight , height;

    public String getName () {
        return this.name;
    }
    public double getWeight () {
        return this.weight;
    }

    @Override
    public String toString () {
        return  String.format("%s \n%dKg %dft %" , getName() , getWeight() , getHeight());
    }
    public double getHeight() {
        return this.height;
    }

    public Human () {}

    public Human(String name , double height , double weight){
        this.name = name;
        this.height = height;
        this.weight = weight;
    }
}