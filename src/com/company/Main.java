package com.company;

public class Main {

    public static void main(String[] args) {
        // these 5 students are all of students i use in this program
        Student std1 = new Student("Maede","Mirzazadeh", "9726080");
        Student std2 = new Student("Samane", "Yari", "9626014");
        Student std3 = new Student("Alireza", "Hoseini", "9726030");
        Student std4 = new Student("tara", "shahidi", "9726004");
        Student std5 = new Student("ali", "ramezani", "9726077");
        Student std6 = new Student("reza", "ghasemi", "9726066");
        std1.print();
        std1.setGrade(15);
        std1.print();

        std2.print();
        std2.setGrade(11);
        std2.print();

        std3.print();
        std3.setFirsrName("Ali");
        std3.setGrade(20);
        std3.print();
        std4.setGrade(20);
        std5.setGrade(10);
        std6.setGrade(12);
        System.out.println(" \\\\\\\\\\\\ ///////");
        /* vaghti yek class ra set meikonim dige nmishe behesh enroll konim ,
         chon size students ke to main tarif mikonim mahdoode
         */
        // now i create a new lab
        Lab lab1= new Lab(10,"shanbe , doshanbe","az ap");
        Lab lab2= new Lab(10,"seshanbe , panjshanbe","az manteghi");
        //first i enroll 2 students in lab and see the avg ,...
        lab1.enrollStudent(std4);
        lab1.enrollStudent(std5);
        lab1.calculateAvg();
        lab1.print();
        System.out.println(" \\\\\\\\\\\\ ///////");
        // here i set two whole new list of students in lab1 and lab 2 and calculate the avg , ... of lab1 only.
        Student students1 []={std1,std2,std3} ;
        lab1.setStudents(students1);
        Student students2[]={std4,std5,std6,std1};
        lab2.setStudents(students2);
        lab1.calculateAvg();
        lab1.print();
        System.out.println(" \\\\\\\\\\\\ ///////");
        // here i create a ta obj + 2 group objs which im gonna use a ta in that;
        ta ta1 = new ta("sarvenaz","sarvghad","blahblah1@gmail.com");
        ta ta2 = new ta("ali","moazemi","blahblah2@gmail.com");
        group group1= new group("advanced programming",lab1,ta1);
        group group2= new group("c programming",lab2,ta2);
        group1.print();
        System.out.println(" \\\\\\\\\\\\ ///////");
        // here i created 1 more group and a Faculty just to see how it works:))
        group groups[]={group1,group2};
        faculty Faculty=new faculty("computer",2,groups);
        Faculty.print();

    }
}
