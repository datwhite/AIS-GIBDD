package ru.gibdd.course.repository;

import org.springframework.data.repository.CrudRepository;
import ru.gibdd.course.entity.Penalty;

public interface PhysicalRepository extends CrudRepository<Penalty, Long> {
}
