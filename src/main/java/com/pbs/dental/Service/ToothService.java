package com.pbs.dental.Service;

import com.pbs.dental.model.Tooth;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ToothService {
    Tooth setTooth(Tooth tooth);
    Optional<Tooth> getTooth(Long toothId);
    List<Tooth> getTeeth();
    void deleteTooth(Long toothId);
}
