package com.pbs.dental.Repository;

import com.pbs.dental.model.Tooth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToothRepository extends JpaRepository<Tooth, Long> {
}