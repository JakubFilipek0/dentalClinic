package com.pbs.dental.model;

import lombok.NoArgsConstructor;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public class Tooth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long toothId;
    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false, referencedColumnName = "patientId")
    private Patient patient;
    @ManyToOne
    @JoinColumn(name = "dentist_id", referencedColumnName = "dentistId")
    private Dentist dentist;
    private String tooth;
    private String content;
    private String type;

    public Tooth(Patient patient, Dentist dentist, String tooth, String content, String type) {
        this.patient = patient;
        this.dentist = dentist;
        this.tooth = tooth;
        this.content = content;
        this.type = type;
    }

    public Long getToothId() {
        return toothId;
    }

    public void setToothId(Long toothId) {
        this.toothId = toothId;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Dentist getDentist() {
        return dentist;
    }

    public void setDentist(Dentist dentist) {
        this.dentist = dentist;
    }

    public String getTooth() {
        return tooth;
    }

    public void setTooth(String tooth) {
        this.tooth = tooth;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Tooth{" +
                "toothId=" + toothId +
                ", patient=" + patient +
                ", dentist=" + dentist +
                ", tooth='" + tooth + '\'' +
                ", content='" + content + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
