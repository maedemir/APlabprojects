package com.company;

public class Person {
    private String firstName;
    private String lastName;

    /**
     * constructor
     * @param fname first name
     * @param lname last name
     */
    public Person (String fname , String lname){
        firstName=fname;
        lastName=lname;
    }

    /**
     *
     * @return first name of a person
     */
    public String getFirstName(){
        return firstName;
    }

    /**
     *
     * @return last name of a person
     */
    public String getLastName(){
        return lastName;
    }

    @Override
    public String toString() {
        return this.lastName;
    }
}
