package com.pbs.dental.controller;

import com.pbs.dental.service.AppointmentService;
import com.pbs.dental.model.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class AppointmentController {

    private AppointmentService appointmentService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping(path = "/appointment/all")
    List<Appointment> getAllAppointments() {
        return appointmentService.getAppointments();
    }

    @GetMapping(path = "/appointment/{appointmentId}")
    ResponseEntity<Appointment> getAppointment(@PathVariable Long appointmentId) {
        return ResponseEntity.of(appointmentService.getAppointment(appointmentId));
    }

    @PostMapping(path = "/appointment/addAppointment")
    ResponseEntity<Appointment> createAppointment(@RequestBody Appointment appointment) {
        Appointment createdAppointment = appointmentService.setAppointment(appointment);
        return new ResponseEntity<>(createdAppointment, HttpStatus.OK);
    }

    @DeleteMapping(path = "appointment/{appointmentId}")
    ResponseEntity<Appointment> deleteAppointment(@PathVariable Long appointmentId) {
        return appointmentService.getAppointment(appointmentId).map(p -> {
            appointmentService.deleteAppointment(appointmentId);
            return new ResponseEntity<Appointment>(HttpStatus.OK);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping(path = "/appointment/{appointmentId}")
    ResponseEntity<Appointment> updateAppointment(@RequestBody Appointment appointment) {
        Appointment updatedAppointment = appointmentService.setAppointment(appointment);
        return new ResponseEntity<>(updatedAppointment, HttpStatus.OK);
    }
}
