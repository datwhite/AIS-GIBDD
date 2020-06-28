package ru.gibdd.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gibdd.course.entity.GibddEmployee;

public interface GibddEmployeeRepository extends JpaRepository<GibddEmployee, Long> {
    GibddEmployee findByCertificate(String Certificate);
}
