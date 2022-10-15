package com.pbs.dental.model;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public class PatientAllergy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientAllergyId;
    private String substance;
    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false, referencedColumnName = "patientId")
    private Patient patient;

    public PatientAllergy(String substance) {
        this.substance = substance;
    }

    public Long getPatientAllergyId() {
        return patientAllergyId;
    }

    public void setPatientAllergyId(Long patientAllergyId) {
        this.patientAllergyId = patientAllergyId;
    }

    public String getSubstance() {
        return substance;
    }

    public void setSubstance(String substance) {
        this.substance = substance;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public String toString() {
        return "PatientAllergy{" +
                "patientAllergyId=" + patientAllergyId +
                ", substance='" + substance + '\'' +
                ", patient=" + patient +
                '}';
    }
}
