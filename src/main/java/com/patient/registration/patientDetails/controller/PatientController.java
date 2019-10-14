package com.patient.registration.patientDetails.controller;

import com.patient.registration.patientDetails.beans.Patient;
import com.patient.registration.patientDetails.beans.Practice;
import com.patient.registration.patientDetails.exceptions.PatientNotFoundException;
import com.patient.registration.patientDetails.serviceinterfaces.PatientServiceInt;
import com.patient.registration.patientDetails.serviceinterfaces.PracticeServiceInt;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


/**
 * Created by Brijesh.Pant on 18-9-2019.
 * Controller class is used to get request and send response back
 */
@RestController
public class PatientController {

    private Logger logger = LogManager.getLogger(PatientController.class);


    @Autowired
    private PatientServiceInt patientService;

    @Autowired
    private PracticeServiceInt practiceService;

    //To get all patients list
    @GetMapping("/patient/getAllPatient")
    public List<Patient> getAllpatient() {
        logger.info("To get all patients list");
        return patientService.getAllPatients();
    }


    //To get all practice list
    //@RequestMapping(method = RequestMethod.GET ,  value="/practices")
    @GetMapping("/practices/getAllPractice")
    public List<Practice> getAllpractice() {
        logger.info("To get all practice list");
        return practiceService.getAllPractice();
    }


    @GetMapping("/patient/getPatientById/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable int id) {
        logger.info("To get one patients by given id");
        Patient patient = patientService.getPatientById(id);
        //to give proper exception message if given patient is not present in database
        if (patient == null) {
            logger.error(" Patient by given id is not found:" + id);
            throw new PatientNotFoundException("id- " + id);
        }

        return new ResponseEntity<Patient>(patient, new HttpHeaders(), HttpStatus.OK);
    }

    //To get  patients List by given practice list
    @GetMapping("/patient/getPatientByPracticeId/{id}")
    public List<Patient> getPatientByPracticeId(@PathVariable Long id) {
        return patientService.getPatientByPracticeId(id);
    }

    //To add new Patient already present patient in list
    //this method will first check practice with given practice id exist or not
    @PostMapping("/patient/addPatients")
    public ResponseEntity<Object> addPatients(@RequestBody Patient user) {
        Patient patient = patientService.addPatient(user);

        if (patient == null) {
            logger.error(" Given Practice is not found:");
            throw new PatientNotFoundException("id- " + user.getPatientId());
        }
        //to given proper created messgae with created location id
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(patient.getPatientId()).toUri();

        return ResponseEntity.created(location).build();

    }

    //To add new update already present patient in list
    //this method will first check practice with given practice id exist or not
    @PutMapping(value = "/patient/updatePatients")
    public ResponseEntity<Object> updatePatients(@RequestBody Patient user) {
        Patient patient = patientService.updatePatient(user);
        if (patient == null) {
            logger.error(" Given Practice is not found:");
            throw new PatientNotFoundException("id- " + user.getPatientId());
        }
        //to given proper created messgae with created location
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(patient.getPatientId()).toUri();

        return ResponseEntity.created(location).build();

    }

    //To delete patient by given id
    //this method will first check practice with given practice id exist or not
    @DeleteMapping("/patient/deletePatient/{id}")
    public Patient deletePatient(@PathVariable int id) {
        Patient patient = patientService.deletePatient(id);
        if (patient == null) {
            logger.error(" Given Practice is not found:");
            throw new PatientNotFoundException("id- " + id);
        }
        return patient;
    }

}
