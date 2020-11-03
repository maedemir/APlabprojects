package com.company;

public class Circle {
    private double radius;

    /**
     * constructor
     * @param radius radius
     */
    public Circle(double radius){
        this.radius=radius;
    }

    /**
     * getter for radius
     * @return radius
     */
    public double getRadius(){
        return radius;
    }

    /**
     * calculats perimeter
     * @return premeter of circle
     */
    public double calculatePerimeter() {
        return (2 * Math.PI * radius);
    }

    /**
     * calculates area of circle
     * @return area
     */
    public double calculateArea() {
        return Math.PI * Math.pow(radius , 2);
    }

    /**
     * prints info of a circle
     */
    public void draw() {
        System.out.println("Circle");
        System.out.println("area: "+calculateArea());
        System.out.println("perimeter: "+calculatePerimeter());
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Circle))
            return false;

        Circle circle = (Circle) obj;
        return this.radius == circle.getRadius();
    }
    @Override
    public int hashCode() {
        int result = 7;
        result = 37 * result + (int) radius;
        return result;
    }
    @Override
    public String toString() {
        return "Circle " + "radius: " + this.radius;
    }
}
