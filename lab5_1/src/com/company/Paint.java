package com.company;

import java.util.ArrayList;

public class Paint {
    private ArrayList<Rectangle> rectangles;
    private ArrayList<Triangle> triangles;
    private ArrayList<Circle> circles;

    /**
     * constructor
     */
    public Paint(){
        rectangles = new ArrayList<>();
        triangles = new ArrayList<>();
        circles = new ArrayList<>();
    }

    /**
     * add a new triangle to list of triangles
     * @param t new triangle
     */
    public void addTriangle(Triangle t ){
        triangles.add(t);
    }
    /**
     * add a new rectangle to list of rectangles
     * @param r new rectangle
     */
    public void addRectangle(Rectangle r){
        rectangles.add(r);
    }
    /**
     * add a new circle to list of circles
     * @param c new circle
     */
    public void addCircle(Circle c){
        circles.add(c);
    }

    /**
     * prints all the info about all the shapes;
     */
    public void drawAll(){
        for(Rectangle r: rectangles) {
            r.draw();
        }
        for(Triangle t: triangles) {
            t.draw();
        }
        for(Circle c: circles) {
            c.draw();
        }
    }

    /**
     * prints toString of all the shapes
     */
    public void printAll(){

        for(Rectangle r : rectangles) {
            System.out.println(r.toString());
        }
        for(Triangle t : triangles) {
            System.out.println(t.toString());
        }
        for(Circle c: circles) {
            System.out.println(c.toString());
        }

    }
}
