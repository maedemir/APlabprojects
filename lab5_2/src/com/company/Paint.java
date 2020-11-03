package com.company;

import java.util.ArrayList;

public class Paint {
    ArrayList<Shape> shapes = new ArrayList<Shape>();
    public void addShape(Shape shape){
        shapes.add(shape);
    }
    public void drawAll(){
        for (Shape shape: shapes) {
            shape.draw();
        }
    }
    public void printAll(){
        for (Shape shape: shapes) {
            System.out.println(shape.toString());
        }
    }

    /**
     * a method for finding equal side shapes
     */
    public void describeEqualSides(){
        for (Shape shape : shapes) {
            if(shape instanceof Triangle && ((Triangle) shape).isEquilateral())
                System.out.println(shape.toString());
            if(shape instanceof Rectangle && ((Rectangle) shape).isSquare())
                System.out.println(shape.toString());

        }
    }

}
