package com.company;

import java.util.ArrayList;

/**
 * this class holds info of a patient , and also medical records
 * it makes you capable of choosing your first doctor
 * this class keeps the list of a patient's doctors as well
 * patient can get his/her medical record through this class;
 */
public class patient {
    private String birthDate;
    private String sexuality;
    private String baseInsurance;
    private  String additionalInsurance;
    private String degree;
    private String job;
    private String residence;
    private String location;
    private ArrayList<Doctor> doctors;
    private ArrayList<medicalRecord> medicalRecords;
    //adding first doctor to list of trusted doctors
    public patient(Doctor doctor){
        doctors = new Doctor();
        doctors.add(doctor);
    }

    public ArrayList<Doctor> getDoctors() {
        return doctors;
    }

    public ArrayList<medicalRecord> getMedicalRecords() {
        return medicalRecords;
    }
}
