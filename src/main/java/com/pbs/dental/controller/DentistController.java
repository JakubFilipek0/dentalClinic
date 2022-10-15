package com.pbs.dental.controller;

import com.pbs.dental.service.DentistService;
import com.pbs.dental.model.Dentist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class DentistController {

    private DentistService dentistService;

    @Autowired
    public DentistController(DentistService dentistService) {
        this.dentistService = dentistService;
    }

    @GetMapping(path = "/dentist/all")
    List<Dentist> getAllDentists() {
        return dentistService.getDentists();
    }

    @GetMapping(path = "/dentist/{dentistId}")
    ResponseEntity<Dentist> getDentist(@PathVariable Long dentistId) {
        return ResponseEntity.of(dentistService.getDentist(dentistId));
    }

    @PostMapping(path = "/dentist/addDentist")
    ResponseEntity<Dentist> createDentist(@RequestBody Dentist dentist) {
        Dentist createdDentist = dentistService.setDentist(dentist);
        return new ResponseEntity<>(createdDentist, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/dentist/{dentistId}")
    ResponseEntity<Dentist> deleteDentist(@PathVariable Long dentistId) {
        return dentistService.getDentist(dentistId).map(p -> {
            dentistService.deleteDentist(dentistId);
            return new ResponseEntity<Dentist>(HttpStatus.OK);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping(path = "/dentist/{dentistId}")
    ResponseEntity<Dentist> updateDentist(@RequestBody Dentist dentist) {
        Dentist updatedDentist = dentistService.setDentist(dentist);
        return new ResponseEntity<>(updatedDentist, HttpStatus.CREATED);
    };
}
