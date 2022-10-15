package com.pbs.dental.service;

import com.pbs.dental.repository.PatientAllergyRepository;
import com.pbs.dental.model.PatientAllergy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientAllergyServiceImpl implements PatientAllergyService {

    private PatientAllergyRepository patientAllergyRepository;

    @Autowired
    public PatientAllergyServiceImpl(PatientAllergyRepository patientAllergyRepository) {
        this.patientAllergyRepository = patientAllergyRepository;
    }

    @Override
    public PatientAllergy setPatientAllergy(PatientAllergy patientAllergy) {
        return patientAllergyRepository.save(patientAllergy);
    }

    @Override
    public Optional<PatientAllergy> getPatientAllergy(Long patientAllergyId) {
        return patientAllergyRepository.findById(patientAllergyId);
    }

    @Override
    public List<PatientAllergy> getPatientAllergys() {
        return patientAllergyRepository.findAll();
    }

    @Override
    public void deletePatientAllergys(Long patientAllergyId) {
        patientAllergyRepository.deleteById(patientAllergyId);
    }
}
