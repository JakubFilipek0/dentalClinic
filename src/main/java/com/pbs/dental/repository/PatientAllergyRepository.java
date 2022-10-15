package com.pbs.dental.repository;

import com.pbs.dental.model.PatientAllergy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientAllergyRepository extends JpaRepository<PatientAllergy, Long> {
}
