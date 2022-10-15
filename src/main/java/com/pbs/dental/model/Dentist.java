package com.pbs.dental.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor
public class Dentist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dentistId;
    private String firstName;
    private String lastName;
    private String jobName;
    private LocalDate dateOfBirth;
    private String email;
    private String phoneNumber;
    private String password;

    @OneToMany(mappedBy = "dentist", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<BlogPost> blogPostList;

    @OneToMany(mappedBy = "dentist", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Tooth> toothList;

    @OneToMany(mappedBy = "dentist", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Appointment> appointmentList;

    public Dentist(String firstName, String lastName, String jobName, LocalDate dateOfBirth, String email, String phoneNumber, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.jobName = jobName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public Long getDentistId() {
        return dentistId;
    }

    public void setDentistId(Long dentistId) {
        this.dentistId = dentistId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<BlogPost> getBlogPostList() {
        return blogPostList;
    }

    public void setBlogPostList(List<BlogPost> blogPostList) {
        this.blogPostList = blogPostList;
    }

    public List<Tooth> getToothList() {
        return toothList;
    }

    public void setToothList(List<Tooth> toothList) {
        this.toothList = toothList;
    }

    public List<Appointment> getAppointmentList() {
        return appointmentList;
    }

    public void setAppointmentList(List<Appointment> appointmentList) {
        this.appointmentList = appointmentList;
    }

    @Override
    public String toString() {
        return "Dentist{" +
                "dentistId=" + dentistId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", jobName='" + jobName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", password='" + password + '\'' +
                ", blogPostList=" + blogPostList +
                ", toothList=" + toothList +
                ", appointmentList=" + appointmentList +
                '}';
    }
}
