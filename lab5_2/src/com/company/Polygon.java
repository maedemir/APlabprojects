package com.company;
import java.util.ArrayList;
import java.util.Collections;

import static java.lang.Math.sqrt;

public class Polygon extends Shape {
    ArrayList<Double> sides = new ArrayList<>();
    public Polygon(double... sides) {
        for (double S : sides) {
            this.sides.add(S);
        }
    }
    public ArrayList<Double> getSides() {
        return sides;
    }

    public double calculatePerimeter() {
        double sumOfSides= 0;
        for(double S : sides){
            sumOfSides += S;
        }
        return sumOfSides;
    }
    public double calculateArea() {
        // it will be overriden in each subclass
       return -1;
    }
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Polygon))
            return false;
        Polygon other = (Polygon) obj;
        Collections.sort(this.sides);
        Collections.sort(other.getSides());
        return other.getSides().equals(this.sides);
    }
    public int hashCode() {
        int result = 17;
        result =  37 * result +  sides.hashCode();
        return result;
    }
    public String toString() {
        String Str = "";
        Str += className +" :";
        int counter = 1;
        for(double S : sides)
        {
            Str += "side " + counter +")" +S+" ";
            counter+=1;
        }
        return Str;
    }

}
