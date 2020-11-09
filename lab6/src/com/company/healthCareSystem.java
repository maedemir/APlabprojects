package com.company;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author maede mir
 * @version 1
 * this class is for designing a healthcare system.
 * in this class you can access patients of each city and their medical records...
 */
public class healthCareSystem {
    //keeping records as a hashmap with cities as keys
    private HashMap<String, ArrayList<patient>> records;
    private ArrayList<Doctor> doctors;
    public ArrayList<ArrayList<medicalRecord>> CityRecords(String CityName){
        //searching for all the patients in this city and return their medical records;
    }
    public ArrayList<medicalRecord> getRecordsOfPatient(patient patient){
        //using method seaPatientsMedicalRecord;
    }

    /**
     *  //when a new patient is gonna be added to the system ,
     *  // this method will search on its trusted doctors and add new ones to doctor's list
     */
    public void addDoctor(){
       ////
    }

    public HashMap<String, ArrayList<patient>> getRecords() {
        return records;
    }

    /**
     * this method will add new patient to hashmap "records" based on his/her city
     * @param patient new patient
     */
    public void (patient patient) addPatient(patient patient){

    }
}
