package com.pbs.dental.Service;

import com.pbs.dental.model.Patient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PatientService {
    Patient setPatient(Patient patient);
    Optional<Patient> getPatient(Long patientId);
    List<Patient> getPatients();
    void deletePatient(Long patientId);
}
