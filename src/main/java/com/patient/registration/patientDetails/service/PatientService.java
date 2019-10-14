package com.patient.registration.patientDetails.service;

import com.patient.registration.patientDetails.beans.Patient;
import com.patient.registration.patientDetails.beans.Practice;
import com.patient.registration.patientDetails.repository.PatientRepository;
import com.patient.registration.patientDetails.repository.PraticeRepository;
import com.patient.registration.patientDetails.serviceinterfaces.PatientServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Brijesh.Pant on 18-9-2019.
 * Patient service which will interacte with patientRepository
 */
@Service
public class PatientService implements PatientServiceInt {
    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PraticeRepository praticeRepository;

    public PatientRepository getPatientRepository() {
        return patientRepository;
    }

    public void setPatientRepository(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<Patient> getAllPatients() {

        return patientRepository.findAll();
    }

    /*this method will first search if practice id is available or not,if not then
    it will return return null object and control will exception on based on this*/
    public Patient addPatient(Patient patient) {
        for (Practice practice : praticeRepository.findAll()) {
            if (practice.getPracticeId() == patient.getPraticeid()) {
                patientRepository.save(patient);
                return patient;
            }
        }
        return null;


    }
    /*this method will first search if patient id is available or not,if not then
        it will return return null object and control will exception on based on this*/
    public Patient updatePatient(Patient patient) {
        for (Patient patient1 : patientRepository.findAll()) {
            if (patient1.getPatientId() == patient.getPatientId()) {
                patientRepository.save(patient);
                return patient1;
            }
        }
        return null;

    }
    /*this method will first search if patient id is available or not,if not then
            it will return return null object and control will exception on based on this*/
    public Patient getPatientById(int id) {

        for (Patient patient : patientRepository.findAll()) {
            if (patient.getPatientId() == id)
                return patient;
        }
        return null;
    }
    /*this method will first search if patient id is available or not,if not then
            it will return return null object and control will exception on based on this*/
    public Patient deletePatient(int id) {
        for (Patient patient : patientRepository.findAll()) {
            if (patient.getPatientId() == id) {
                patientRepository.delete(patient);
                return patient;
            }
        }
        return null;

    }

    public List<Patient> getPatientByPracticeId(long id) {

        return patientRepository.findBypraticeid(id);
    }
}
