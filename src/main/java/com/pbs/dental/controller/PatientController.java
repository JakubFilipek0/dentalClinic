package com.pbs.dental.controller;

import com.pbs.dental.Service.PatientService;
import com.pbs.dental.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class PatientController {

    private PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping(path = "/patient/all")
    List<Patient> getAllPatients() {
        return patientService.getPatients();
    }

    @GetMapping(path = "/patient/{patientId}")
    ResponseEntity<Patient> getPatient(@PathVariable Long patientId) {
        return ResponseEntity.of(patientService.getPatient(patientId));
    }

    @PostMapping(path = "/patient/addPatient")
    ResponseEntity<Patient> createPatient(@RequestBody Patient patient) {
        Patient createdPatient = patientService.setPatient(patient);
        return new ResponseEntity<>(createdPatient, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/patient/{patientId}")
    ResponseEntity<Patient> deletePatient(@PathVariable Long patientId) {
        return patientService.getPatient(patientId).map(p -> {
            patientService.deletePatient(patientId);
            return new ResponseEntity<Patient>(HttpStatus.OK);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping(path = "/patient/{patientId}")
    ResponseEntity<Patient> updatePatient(@RequestBody Patient patient, @PathVariable Long patientId) {
        Patient updatePatient = patientService.setPatient(patient);
        return new ResponseEntity<>(updatePatient, HttpStatus.CREATED);
    }
}
