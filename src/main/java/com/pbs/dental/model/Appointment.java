package com.pbs.dental.model;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appointmentId;
    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false, referencedColumnName = "patientId")
    private Patient patient;
    @ManyToOne
    @JoinColumn(name = "dentist_id", nullable = false, referencedColumnName = "dentistId")
    private Dentist dentist;
    private LocalDateTime dateAndHourOfAppointment;
    private String purpose;
    private String status;

    public Appointment(Patient patient, Dentist dentist, LocalDateTime dateAndHourOfAppointment, String purpose, String status) {
        this.patient = patient;
        this.dentist = dentist;
        this.dateAndHourOfAppointment = dateAndHourOfAppointment;
        this.purpose = purpose;
        this.status = status;
    }

    public Long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
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

    public LocalDateTime getDateAndHourOfAppointment() {
        return dateAndHourOfAppointment;
    }

    public void setDateAndHourOfAppointment(LocalDateTime dateAndHourOfAppointment) {
        this.dateAndHourOfAppointment = dateAndHourOfAppointment;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "appointmentId=" + appointmentId +
                ", patient=" + patient +
                ", dentist=" + dentist +
                ", dateAndHourOfAppointment=" + dateAndHourOfAppointment +
                ", purpose='" + purpose + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
