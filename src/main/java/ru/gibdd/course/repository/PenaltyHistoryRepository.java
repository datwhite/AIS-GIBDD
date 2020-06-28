package ru.gibdd.course.repository;

import org.springframework.data.repository.CrudRepository;
import ru.gibdd.course.entity.PenaltyHistory;

public interface PenaltyHistoryRepository extends CrudRepository<PenaltyHistory, String> {
}
