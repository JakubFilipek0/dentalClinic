package com.pbs.dental.Service;

import com.pbs.dental.model.Dentist;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface DentistService {
    Dentist setDentist(Dentist dentist);
    Optional<Dentist> getDentist(Long dentistId);
    List<Dentist> getDentists();
    void deleteDentist(Long dentistId);
}
