package com.patient.registration.patientDetails.repository;

import com.patient.registration.patientDetails.beans.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Brijesh.Pant on 18-9-2019.
 * JpaRepository class for PatientRepository
 */
@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findBypraticeid(long praticeId);


}