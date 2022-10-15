package com.pbs.dental.service;

import com.pbs.dental.repository.ToothRepository;
import com.pbs.dental.model.Tooth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToothServiceImpl implements ToothService {

    private ToothRepository toothRepository;

    @Autowired
    public ToothServiceImpl(ToothRepository toothRepository) {
        this.toothRepository = toothRepository;
    }

    @Override
    public Tooth setTooth(Tooth tooth) {
        return toothRepository.save(tooth);
    }

    @Override
    public Optional<Tooth> getTooth(Long toothId) {
        return toothRepository.findById(toothId);
    }

    @Override
    public List<Tooth> getTeeth() {
        return toothRepository.findAll();
    }

    @Override
    public void deleteTooth(Long toothId) {
        toothRepository.deleteById(toothId);
    }
}
