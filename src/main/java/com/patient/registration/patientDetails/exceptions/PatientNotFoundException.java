package com.patient.registration.patientDetails.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Brijesh.Pant on 18-9-2019.
 * this class is used to create exception if patient is not found
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class PatientNotFoundException extends RuntimeException {
    public PatientNotFoundException(String id) {
        super(id);
    }
}
