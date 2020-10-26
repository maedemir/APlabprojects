package com.company;

import ir.huri.jcal.JalaliCalendar;

import java.util.Date;
import java.util.Random;

public class Vote {
    private Person person ;
    private String date;
    //this field save string date in a jalali date.
    private JalaliCalendar calendar = new JalaliCalendar();
    public Vote(Person person , String date){
        this.person=person;
        this.date=date;
        String arr[] = date.split("_");
        calendar.set(Integer.parseInt(arr[0]) , Integer.parseInt(arr[1] ), Integer.parseInt(arr[2]));
    }

    /**
     * getter for person
     * @return person
     */
    public Person getPerson(){
        return person;
    }

    /**
     * getter for date
     * @return date in string form
     */
    public String getDate(){
        return date;
    }

    /**
     *getter for calender
     * @return date in jalali date :))))
     */
    public JalaliCalendar getCalendar(){
        return calendar;
    }
    @Override
    public boolean equals(Object obj) {
        if(obj == this){
            return true;
        }
        if (!(obj instanceof Vote)) {
            return false;
        }
        Vote v = (Vote) obj;
        return this.calendar==v.calendar && this.person==v.person;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 37 * result + this.person.hashCode();
        return result;
    }
}
