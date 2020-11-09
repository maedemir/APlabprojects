package com.company;

import java.util.ArrayList;

/**
 * this class is for saving medical record(that a doctor prescribes for his/her patient)
 * its basically like a piece of paper with some fields to be filled:)))
 */
public class medicalRecord {
    private GeneralDisease disease;
    private LevelOfDisease level;
    // a summery about patient's situation
    private String patientSituation;
    private String doctorDiagnose;
    private ArrayList<String> medicines;
    private String date;
    private Doctor doctor;
}
