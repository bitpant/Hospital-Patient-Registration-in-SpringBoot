package com.patient.registration.patientDetails.repository;

import com.patient.registration.patientDetails.beans.Practice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Brijesh.Pant on 18-9-2019.
 * JpaRepository class for PraticeRepository
 */
@Repository
public interface PraticeRepository extends JpaRepository<Practice, Long> {
}
