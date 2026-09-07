package com.hospital.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TreatmentRecord {
    private int patientId;
    private String patientName;
    private String treatment;
    private String doctorName;
    private LocalDateTime treatmentDate;
    
    public TreatmentRecord(int patientId, String patientName, String treatment, String doctorName) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.treatment = treatment;
        this.doctorName = doctorName;
        this.treatmentDate = LocalDateTime.now();
    }
    
    // Getters
    public int getPatientId() { return patientId; }
    public String getPatientName() { return patientName; }
    public String getTreatment() { return treatment; }
    public String getDoctorName() { return doctorName; }
    public LocalDateTime getTreatmentDate() { return treatmentDate; }
    
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return String.format("Patient: %s (ID: %d) | Treatment: %s | Doctor: %s | Date: %s",
                patientName, patientId, treatment, doctorName, treatmentDate.format(formatter));
    }
}