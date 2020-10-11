package com.company;

public class Lab {
    //list of students;
    private Student students[];
    // avg of students
    private int avg;
    // days of week that students have lab class!
    private String day;
    // capacity of lab
    private int capacity;
    //number of current students in the lab
    private int currentSize;
    //name of lab
    private String labname;
    /**
     * Create a new lab with a given capacity and day.
     * @param cap capacity of lab
     * @param d day
     */
    public Lab(int cap, String d , String name) {
        capacity=cap;
        day=d;
        currentSize =0;
        avg=0;
        labname=name;
        students = new Student[capacity];
    }

    /**
     * this function add a student to the lab and student list if there is availble space in lab!
     * @param std new student
     */
    public void enrollStudent(Student std) {
        if (currentSize < capacity) {
            students[currentSize] = std;
            currentSize++;
        } else {
            System.out.println("Lab is full!!!");
        }
    }

    /**
     * it prints the info of studenent (name , id , grade ) and avg of their marks
     */
    public void print() {
        for(int i=0 ; i< currentSize ;i++){
            students[i].print();
        }
        System.out.println("the average is :" + avg);
    }

    /**
     * this function return the list of students in the lab;
     * @return
     */
    public Student[] getStudents() {
        return students;
    }

    /**
     * this function delets the former sudent list and make a new one (for example new students in new term)!
     * if there was not enough space it prints som error
     * @param students list of new student
     */
    public void setStudents(Student[] students) {
        if(students.length>capacity){
            System.out.println("not enough available seats :| ");
            return;
        }
        this.students=students;
       int i=0;
       for(Student student:students){
           if(student == null)
               break;
           i++;
       }
       currentSize=i;
    }

    /**
     * it return average of grades:/
     * @return average
     */
    public int getAvg() {

        return avg;
    }

    /**
     * this function calculates avg of grades
     */
    public void calculateAvg() {
        int sum=0;
        int i =0;
        for (i=0;i<currentSize;i++){
            sum+=students[i].getGrade();
        }
        avg = sum/i;
    }

    /**
     * it returns days of lab class
     * @return
     */
    public String getDay() {
        return day;
    }

    /**
     * it sets days that lab is held
     * @param day days
     */
    public void setDay(String day) {
        this.day=day;
    }

    /**
     * it returns capacity of lab class
     * @return capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * it sets capacity of lab;
     * @param capacity capacity.
     */
    public void setCapacity(int capacity) {
        this.capacity=capacity;

    }
    public String getLabname(){
        return labname;
    }




}
