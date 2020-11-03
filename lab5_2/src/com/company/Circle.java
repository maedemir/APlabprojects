package com.company;

public class Circle extends Shape{
    private double radius;
    public Circle(double radius){
        this.radius=radius;
        super.className="Circle";
    }
    public double getRadius(){
        return radius;
    }
    public double calculatePerimeter() {
        return (2 * Math.PI * radius);
    }

    public double calculateArea() {
        return Math.PI * radius*radius;
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
        return "Circle :" + "radius: " + this.radius;
    }
}
