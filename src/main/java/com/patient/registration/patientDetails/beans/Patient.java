package com.patient.registration.patientDetails.beans;

import com.fasterxml.jackson.annotation.JsonFormat;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Objects;


/**
 * Created by Brijesh.Pant on 18-9-2019.
 * Patient Bean
 */
@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long patientId;
    private String patientName;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date patientDOB;
    private String patientAddress;
    private long patientMobile;
    private long praticeid;

    public long getPatientId() {
        return patientId;
    }

    /**
     * @param patientId
     */
    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }


    /**
     * @return
     */
    public String getPatientName() {
        return patientName;
    }

    /**
     * @param patientName
     */
    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    /**
     * @return
     */
    public Date getPatientDOB() {
        return patientDOB;
    }

    /**
     * @param patientDOB
     */
    public void setPatientDOB(Date patientDOB) {
        this.patientDOB = patientDOB;
    }

    /**
     * @return
     */
    public String getPatientAddress() {
        return patientAddress;
    }

    /**
     * @param patientAddress
     */
    public void setPatientAddress(String patientAddress) {
        this.patientAddress = patientAddress;
    }

    /**
     * @return
     */
    public long getPatientMobile() {
        return patientMobile;
    }

    /**
     * @param patientMobile
     */
    public void setPatientMobile(long patientMobile) {
        this.patientMobile = patientMobile;
    }

    public long getPraticeid() {
        return praticeid;
    }

    public void setPraticeid(long praticeid) {
        this.praticeid = praticeid;
    }

    public Patient() {
    }

    /**
     * @param patientName
     * @param patientDOB
     * @param patientAddress
     * @param patientMobile
     * @param pratice
     */
    public Patient(@Size(min = 3) String patientName, Date patientDOB, String patientAddress, long patientMobile, long pratice) {
        this.patientName = patientName;
        this.patientDOB = patientDOB;
        this.patientAddress = patientAddress;
        this.patientMobile = patientMobile;
        this.praticeid = pratice;
    }

    public Patient(long patientId, @Size(min = 3) String patientName, Date patientDOB, String patientAddress, long patientMobile, long pratice) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.patientDOB = patientDOB;
        this.patientAddress = patientAddress;
        this.patientMobile = patientMobile;
        this.praticeid = pratice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return patientId == patient.patientId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(patientId);
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patientId=" + patientId +
                ", patientName='" + patientName + '\'' +
                ", patientDOB=" + patientDOB +
                ", patientAddress='" + patientAddress + '\'' +
                ", patientMobile=" + patientMobile +
                ", praticeid=" + praticeid +
                '}';
    }
}
