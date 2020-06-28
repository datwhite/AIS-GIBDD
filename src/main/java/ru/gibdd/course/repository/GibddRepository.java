package ru.gibdd.course.repository;

import org.springframework.data.repository.CrudRepository;
import ru.gibdd.course.entity.Gibdd;

public interface GibddRepository extends CrudRepository<Gibdd, String> {
}
