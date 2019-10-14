package com.patient.registration.patientDetails.service;

import com.patient.registration.patientDetails.beans.Practice;
import com.patient.registration.patientDetails.repository.PraticeRepository;
import com.patient.registration.patientDetails.serviceinterfaces.PracticeServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * Created by Brijesh.Pant on 18-9-2019.
 * Patient service which will interacte with praticeRepository
 */
@Service
public class PracticeService implements PracticeServiceInt {

    @Autowired
    private PraticeRepository praticeRepository;


    public void setPraticeRepository(PraticeRepository praticeRepository) {
        this.praticeRepository = praticeRepository;
    }

    public List<Practice> getAllPractice() {
        return praticeRepository.findAll();
    }




}
