package com.patient.registration.patientDetails.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
/**
 * Created by Brijesh.Pant on 18-9-2019.
 * this class is used to create and throw excption object according to Exceptionhandler
 */
@ControllerAdvice
@RestController
public class PatientinfoExceptionHandler extends ResponseEntityExceptionHandler {

    //this will handle all other exceptions which is not defined explicitly
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage(), request.getDescription(false), new Date());
        return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    //Specific to patients not found exceptions
    @ExceptionHandler(PatientNotFoundException.class)
    public final ResponseEntity<Object> userhandleAllException(Exception ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage(), request.getDescription(false), new Date());
        return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    //specific to validations annotations used
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage(), ex.getBindingResult().toString(), new Date());
        return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
}
