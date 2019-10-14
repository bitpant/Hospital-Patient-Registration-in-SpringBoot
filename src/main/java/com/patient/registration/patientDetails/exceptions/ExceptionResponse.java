package com.patient.registration.patientDetails.exceptions;

import java.util.Date;

/**
 * Created by Brijesh.Pant on 18-9-2019.
 * this class is used to set excption message in proper formats
 */
public class ExceptionResponse {
    private String message;
    private String details;
    private Date timestamp;

    //This class is used to create proper format for exception message which will be thrown to user
    public ExceptionResponse() {
    }

    public ExceptionResponse(String message, String details, Date timestamp) {
        super();
        this.message = message;
        this.details = details;
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}

