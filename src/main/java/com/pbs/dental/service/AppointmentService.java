package com.pbs.dental.service;

import com.pbs.dental.model.Appointment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface AppointmentService {
    Appointment setAppointment(Appointment appointment);
    Optional<Appointment> getAppointment(Long appointmentId);
    List<Appointment> getAppointments();
    void deleteAppointment(Long appointmentId);
}
