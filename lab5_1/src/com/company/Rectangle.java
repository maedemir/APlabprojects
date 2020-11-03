package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class Rectangle {
    private ArrayList<Double> sides= new ArrayList<Double>();

    /**
     * constructor
     * @param a a side
     * @param b b side
     * @param c c side
     * @param d d side
     */
    public Rectangle(double a , double b ,  double c, double d){
        sides.add(a);
        sides.add(b);
        sides.add(c);
        sides.add(d);
    }

    /**
     * getter for sides
     * @return sides
     */
    public ArrayList<Double> getSides(){
        return sides;
    }

    /**
     * checks if rectangle is also square
     * @return true if square
     */
    public boolean isSquare(){
        if(sides.get(0)==sides.get(1) && sides.get(1)==sides.get(2)&& sides.get(2)==sides.get(3))
            return true;
        return false;

    }

    /**
     * calculates the perimeter
     * @return perimeter of rectangle
     */
    public double calculatePerimeter(){
        return (double) (sides.get(0)+sides.get(1)+sides.get(2)+sides.get(3));
    }

    /**
     * calculates area of rectangle
     * @return area
     */
    public double calculateArea(){
       Collections.sort(this.sides);
       return sides.get(0)*sides.get(2);
    }

    /**
     *prints name of shape , area and its perimeter
     */
    public void draw(){
        System.out.println("Rectangle");
        System.out.println("area: "+calculateArea());
        System.out.println("perimeter: "+calculatePerimeter());
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(!(obj instanceof Rectangle))
            return false;
        Rectangle other = (Rectangle) obj;
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
        return "Rectangle"+" a=" + sides.get(0).toString()+" b="+sides.get(1).toString()
                +" c="+sides.get(2).toString()+" d="+sides.get(3).toString();
    }
}
