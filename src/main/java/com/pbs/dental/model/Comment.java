package com.pbs.dental.model;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;
    //komentarz do zmiany
    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false, referencedColumnName = "patientId")
    private Patient patient;
    @OneToOne
    @JoinColumn(name = "appointment_id", referencedColumnName = "appointmentId")
    private Appointment appointment;
    private String content;
    private Float rate;

    public Comment(Patient patient, Appointment appointment, String content, Float rate) {
        this.patient = patient;
        this.appointment = appointment;
        this.content = content;
        this.rate = rate;
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", patient=" + patient +
                ", appointment=" + appointment +
                ", content='" + content + '\'' +
                ", rate=" + rate +
                '}';
    }
}
