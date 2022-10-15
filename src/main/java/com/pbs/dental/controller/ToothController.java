package com.pbs.dental.controller;

import com.pbs.dental.service.ToothService;
import com.pbs.dental.model.Tooth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class ToothController {

    private ToothService toothService;

    @Autowired
    public ToothController(ToothService toothService) {
        this.toothService = toothService;
    }

    @GetMapping(path = "/tooth/all")
    List<Tooth> getAllTeeth() {
        return toothService.getTeeth();
    }

    @GetMapping(path = "/tooth/{toothId}")
    ResponseEntity<Tooth> getTooth(@PathVariable Long toothId) {
        return ResponseEntity.of(toothService.getTooth(toothId));
    }

    @PostMapping(path = "/tooth/addTooth")
    ResponseEntity<Tooth> createTooth(@RequestBody Tooth tooth) throws IOException {
//        Tooth createdTooth = toothService.setTooth(tooth);
//        return new ResponseEntity<>(createdTooth, HttpStatus.OK);
        Tooth createdTooth = toothService.setTooth(tooth);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{toothId").buildAndExpand(createdTooth.getToothId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(path = "/tooth/{toothId}")
    ResponseEntity<Tooth> deleteTooth(@PathVariable Long toothId) {
        return toothService.getTooth(toothId).map(p -> {
            toothService.deleteTooth(toothId);
            return new ResponseEntity<Tooth>(HttpStatus.OK);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping(path = "/tooth/{toothId}")
    ResponseEntity<Tooth> updatedTooth(@RequestBody Tooth tooth) {
        Tooth updatedTooth = toothService.setTooth(tooth);
        return new ResponseEntity<>(updatedTooth, HttpStatus.OK);
    }
}
