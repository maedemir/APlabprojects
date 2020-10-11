package com.company;

public class Student {
    //the student's first name
    private String firsrName;
    //the student's last name
    private String lastName;
    // student id
    private String id;
    // the student's grade;
    private int grade;

    /**
     * Create a new student with a given name and ID number.
     * @param fname student's first name!
     * @param lname student's last name!
     * @param sID student's ID !
     */
    public Student(String fname , String lname ,String sID){
        firsrName=fname;
        lastName=lname;
        id=sID;
        grade=0;
    }

    /**
     *  gets the first name of student
     * @return student's fist name;
     */
    public String getFirsrName(){
        return firsrName;
    }

    /**
     * this function sets student's first name!
     * @param fname student's first name;)
     */
    public void setFirsrName(String fname){
        firsrName=fname;
    }

    /**
     *  gets the last name of student
     * @return  student's last name!
     */
    public String getLastName(){
        return lastName;
    }

    /**
     * this function sets student's last name!
     * @param lname last name
     */
    public void setLastName(String lname){
        lastName=lname;
    }
////////////////////////////
    /**
     *  gets student id
     * @return  student's id!
     */
    public String getId(){
        return id;
    }

    /**
     * this function sets student's id!
     * @param  ID id
     */
    public void setId(String ID){
        id=ID;
    }
//////////////
    /**
     *  gets student's grade
     * @return  student's grade!
     */
    public int getGrade(){
        return grade;
    }

    /**
     * sets student's grade;
     * @param Grade student's grade
     */
    public void setGrade(int Grade){
        grade=Grade;
    }
    /**
     * Print the student’s last name and ID number to the
     output terminal.
     */
    public void print() {
        System.out.println(lastName + ", student ID: "
                + id + ", grade: " + grade);
    }
}
