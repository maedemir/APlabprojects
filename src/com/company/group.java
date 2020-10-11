package com.company;

import org.omg.CORBA.UShortSeqHelper;

/**
 * this class holds the info of a group in faculty
 * in hypothetical situation :))) , each group has a ta and a lab class
 */
public class group {
    private String name;
    private Lab lab ;
    private ta TA;
    public group(String name,Lab lab,ta TA){
        this.name=name;
        this.lab=lab;
        this.TA=TA;

    }

    /**
     * this function prints : 1)the name of group 2) the name of ta in group and 3)the name of lab in this group
     */
    public void print(){
        System.out.println("the name of group is : " + name);
        System.out.println("ta in this group is :"+TA.getFirsrName() +" "+ TA.getLastName());
        System.out.println("the name of lab in this group is :"+lab.getLabname());
    }
    public String getName(){
        return name;
    }


}
