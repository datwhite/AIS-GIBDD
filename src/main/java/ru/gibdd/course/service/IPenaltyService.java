package ru.gibdd.course.service;

import ru.gibdd.course.entity.Penalty;

import java.util.List;

public interface IPenaltyService {
    List<Penalty> findAll();
}
