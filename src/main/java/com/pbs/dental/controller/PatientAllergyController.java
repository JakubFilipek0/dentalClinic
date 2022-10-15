package com.pbs.dental.controller;

import com.pbs.dental.Service.PatientAllergyService;
import com.pbs.dental.model.PatientAllergy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class PatientAllergyController {

    private PatientAllergyService patientAllergyService;

    @Autowired
    public PatientAllergyController(PatientAllergyService patientAllergyService) {
        this.patientAllergyService = patientAllergyService;
    }

    @GetMapping(path = "patientAllergy/all")
    List<PatientAllergy> getAllPatientAllergies() {
        return patientAllergyService.getPatientAllergys();
    }

    @GetMapping(path = "/patientAllergy/{patientAllergyId}")
    ResponseEntity<PatientAllergy> getPatientAllergy(@PathVariable Long patientAllergyId) {
        return ResponseEntity.of(patientAllergyService.getPatientAllergy(patientAllergyId));
    }

    @PostMapping(path = "/patientAllergy/addPatientAllergy")
    ResponseEntity<PatientAllergy> createPatientAllergy(@RequestBody PatientAllergy patientAllergy) {
        PatientAllergy createdPatientAllergy = patientAllergyService.setPatientAllergy(patientAllergy);
        return new ResponseEntity<>(createdPatientAllergy, HttpStatus.OK);
    }

    @DeleteMapping(path = "/patientAllergy/{patientAllergyId}")
    ResponseEntity<PatientAllergy> deletePatientAllergy(@PathVariable Long patientAllergyId) {
        return patientAllergyService.getPatientAllergy(patientAllergyId).map(p -> {
            patientAllergyService.deletePatientAllergys(patientAllergyId);
            return new ResponseEntity<PatientAllergy>(HttpStatus.OK);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping(path = "/patientAllergy/{patientAllergyId}")
    ResponseEntity<PatientAllergy> updatePatientAllergy(@RequestBody PatientAllergy patientAllergy) {
        PatientAllergy updatedPatientAllergy = patientAllergyService.setPatientAllergy(patientAllergy);
        return new ResponseEntity<>(updatedPatientAllergy, HttpStatus.OK);
    }
}
