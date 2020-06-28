package ru.gibdd.course.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.gibdd.course.entity.Penalty;
import ru.gibdd.course.repository.PenaltyRepository;

import java.util.List;

public class PenaltyService implements IPenaltyService {
    @Autowired
    private PenaltyRepository penaltyRepository;

    @Override
    public List<Penalty> findAll() {
        return (List<Penalty>) penaltyRepository.findAll();
    }
}
