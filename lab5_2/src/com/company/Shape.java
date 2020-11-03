package com.company;

public abstract class Shape {
    public String className="";
    public abstract double calculatePerimeter();
    public abstract double calculateArea();
    public void draw() {
        System.out.println("Shape " + this.className);
        System.out.println("Perimeter: " + calculatePerimeter());
        System.out.println("Area : "+calculateArea());
    }
    @Override
    public abstract boolean equals(Object o);

    @Override
    public abstract int hashCode();

    @Override
    public abstract String toString();
}
