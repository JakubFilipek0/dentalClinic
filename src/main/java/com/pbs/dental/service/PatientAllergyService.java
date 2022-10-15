package com.pbs.dental.service;

import com.pbs.dental.model.PatientAllergy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PatientAllergyService {
    PatientAllergy setPatientAllergy(PatientAllergy patientAllergy);
    Optional<PatientAllergy> getPatientAllergy(Long patientAllergyId);
    List<PatientAllergy> getPatientAllergys();
    void deletePatientAllergys(Long patientAllergyId);
}
