package com.company;

public class ta {
    //ta's first name
    private String firsrName;
    //ta's last name
    private String lastName;
    //ta's email
    private String email;
    public ta(String fname , String lname ,String email){
        firsrName=fname;
        lastName=lname;
        this.email=email;
    }
    public String getFirsrName(){
        return firsrName;
    }

    /**
     * this function sets student's first name!
     * @param fname ta's first name;)
     */
    public void setFirsrName(String fname){
        firsrName=fname;
    }

    /**
     *  gets the last name of ta
     * @return  ta's last name!
     */
    public String getLastName(){
        return lastName;
    }

    /**
     * this function sets ta's last name!
     * @param lname last name
     */
    public void setLastName(String lname){
        lastName=lname;
    }
    /**
     *  gets the email of ta
     * @return  ta's last name!
     */
    public String getEmail(){
        return email;
    }

    /**
     * this function sets ta's email!
     * @param email last name
     */
    public void setEmail(String email){
        this.email=email;
    }

}
