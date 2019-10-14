package com.patient.registration.patientDetails.serviceinterfaces;

import com.patient.registration.patientDetails.beans.Patient;

import java.util.List;

public interface PatientServiceInt {
    public Patient addPatient(Patient patient);
    public List<Patient> getAllPatients();
    public Patient getPatientById(int id);
    public Patient deletePatient(int id);
    public List<Patient> getPatientByPracticeId(long id);
    public Patient updatePatient(Patient patient);

}
