package com.patient.registration.patientDetails.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Objects;

/**
 * Created by Brijesh.Pant on 18-9-2019.
 * practice bean
 */
@Entity
public class Practice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long practiceId;
    private String practiceName;
    @OneToMany
    @JsonIgnore
    List<Patient> patientList;

    public List<Patient> getPatientList() {
        return patientList;
    }

    public void setPatientList(List<Patient> patientList) {
        this.patientList = patientList;
    }

    /**
     * @param practiceName
     * @param practiceId
     */
    public Practice(Long practiceId,@Size(min = 3, message = "") String practiceName) {
        this.practiceName = practiceName;
        this.practiceId=practiceId;
    }

    public Practice(@Size(min = 3, message = "") String practiceName, List<Patient> patientList) {
        this.practiceName = practiceName;
        this.patientList = patientList;
    }

    public Practice() {
    }

    public Practice(@Size(min = 3, message = "") String practiceName) {
        this.practiceName = practiceName;
    }

    /**
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Practice practice = (Practice) o;
        return practiceId == practice.practiceId;
    }

    /**
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(practiceId);
    }

    /**
     * @return
     */
    public long getPracticeId() {
        return practiceId;
    }

    /**
     * @param practiceId
     */
    public void setPracticeId(long practiceId) {
        this.practiceId = practiceId;
    }

    /**
     * @return
     */
    public String getPracticeName() {
        return practiceName;
    }

    /**
     * @param praticeName
     */
    public void setPracticeName(String praticeName) {
        this.practiceName = praticeName;
    }

    @Override
    public String toString() {
        return "Practice{" +
                "praticeId=" + practiceId +
                ", praticeName='" + practiceName + '\'' +
                ", patientList=" + patientList +
                '}';
    }
}
