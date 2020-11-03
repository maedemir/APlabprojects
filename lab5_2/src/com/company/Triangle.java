package com.company;

import static java.lang.Math.sqrt;

public class Triangle extends Polygon {

    public Triangle(double... sides) {
        super(sides);
        super.className="Triangle";
    }
    public boolean isEquilateral() {
        if(sides.get(0)==sides.get(1) && sides.get(1)==sides.get(2))
            return true;
        return false;
    }

    @Override
    public double calculateArea() {
        double p = calculatePerimeter()/2;
        return (sqrt(p*(p - sides.get(0))*(p - sides.get(1))*(p - sides.get(2))));
    }
}
