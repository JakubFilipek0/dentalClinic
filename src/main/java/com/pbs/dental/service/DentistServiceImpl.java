package com.pbs.dental.service;

import com.pbs.dental.repository.DentistRepository;
import com.pbs.dental.model.Dentist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DentistServiceImpl implements DentistService {

    private DentistRepository dentistRepository;

    @Autowired
    public DentistServiceImpl(DentistRepository dentistRepository) {
        this.dentistRepository = dentistRepository;
    }

    @Override
    public Dentist setDentist(Dentist dentist) {
        return dentistRepository.save(dentist);
    }

    @Override
    public Optional<Dentist> getDentist(Long dentistId) {
        return dentistRepository.findById(dentistId);
    }

    @Override
    public List<Dentist> getDentists() {
        return dentistRepository.findAll();
    }

    @Override
    public void deleteDentist(Long dentistId) {
        dentistRepository.deleteById(dentistId);
    }
}
