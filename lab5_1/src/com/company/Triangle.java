package com.company;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static java.lang.Math.sqrt;

public class Triangle {
    private ArrayList<Double> sides = new ArrayList<Double>();

    /**
     * constructor
     * @param a side a
     * @param b side b
     * @param c side c
     */
    public Triangle(double a , double b ,  double c){
        sides.add(a);
        sides.add(b);
        sides.add(c);
    }

    /**
     * getter for sides
     * @return sides
     */
    public ArrayList<Double> getSides(){
        return sides;
    }

    /**
     * checks if a triangle is equilateral or not
     * @return true if it is equilateral
     */
    public boolean isEquilateral(){
        if(sides.get(0)==sides.get(1) && sides.get(1)==sides.get(2))
            return true;
        return false;
    }

    /**
     *  calculats perimeter
     * @return perimeter
     */
    public double calculatePerimeter(){
        return (double) (sides.get(0)+sides.get(1)+sides.get(2));
    }

    /**
     * this method calculates the area of triangle with heron's formula!
     * @return area
     */
    public double calculateArea(){
        double p = calculatePerimeter()/2;
        return (sqrt(p*(p - sides.get(0))*(p - sides.get(1))*(p - sides.get(2))));
    }

    /**
     * prints info of a triangle (name of shape , area , perimeter)
     */
    public void draw(){
        System.out.println("triangle");
        System.out.println("area: "+calculateArea());
        System.out.println("perimeter: "+calculatePerimeter());
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(!(obj instanceof Triangle))
            return false;
        Triangle other = (Triangle) obj;
        Collections.sort(other.getSides());
        Collections.sort(this.sides);
        return other.getSides().equals(this.sides);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result =  37 * result +  sides.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Triangle"+" a=" + sides.get(0).toString()+" b="+sides.get(1).toString()
                +" c="+sides.get(2).toString();
    }
}
