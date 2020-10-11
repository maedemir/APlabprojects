package com.company;

public class faculty {
    private String nameOfFaculty;
    private group [] groups;
    private int numberOfGroups;

    /**
     *
     * @param name name of faculty
     * @param numberOfGroups number of groups in this faculty
     * @param groups list of groups in this faculty;
     */
    public faculty(String name , int numberOfGroups,group [] groups){
        this.nameOfFaculty=name;
        this.numberOfGroups=numberOfGroups;
        this.groups = new group[numberOfGroups];
        this.groups=groups;
    }

    /**
     * it prints info of groups in this faculty
     */
    public void print(){
        System.out.println("the name of faculty is :"+nameOfFaculty + " and the names of its groups are:");
        for (int i = 0; i < groups.length; i++) {
            System.out.println("Group "+ (i+1) + " :"+groups[i].getName());
        }
    }


}
