package com.company;

import java.util.ArrayList;

/**
 * this class is for saving info of a doctor , his/her patients and further tasks a doctor can do :)
 */
public class Doctor {
    private String name;
    private String specialty;
    //doctor's city
    private String cityName;
    //list of doctor's patients
    private ArrayList<patient> patients;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
    public ArrayList<patient> getPatients(){
        return patients;
    }

    /**
     * for adding a new patient to doctors's list
     */
    public void addPatient(){
        /////
    }

    /**
     * for accessing medical recors of a patient;
     * @param patient
     */
    public void seaPatientsMedicalRecord(String patient){
        /////
    }
    public void refer(Doctor doctor){
      // using methos addDoctor in class patient , it will add a new doctor to its list of trusted doctors;
    }

    /**
     * prescribe for a patient and add a new medical record to patient's records
     * @param patient patient
     */
    public void addRecordForPatient(patient patient){

    }
}
