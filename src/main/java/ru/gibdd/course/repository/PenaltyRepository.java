package ru.gibdd.course.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.gibdd.course.entity.Penalty;
import ru.gibdd.course.pojo.PenaltyByDriverLicense;

import java.util.List;

public interface PenaltyRepository extends CrudRepository<Penalty, String> {


    List<Penalty> findByDecreeNumber(String decreeNumber);

    @Query("SELECT p.decreeNumber, c.short_description, ph.Driver_license_phys FROM Penalty p, CoAO c, PenaltyHistory ph WHERE ph.Driver_license_phys = ?1  AND p.decreeNumber = ph.decreeNumber AND p.Article = c.Article AND p.Paid = 'false'")
    Iterable<Penalty> findPenaltyByDriverLicense(String Driver_license_phys);

    @Query("SELECT p.decreeNumber, c.short_description, ph.Driver_license_phys FROM Penalty p, CoAO c, PenaltyHistory ph WHERE ph.Driver_license_phys = ?1  AND p.decreeNumber = ph.decreeNumber AND p.Article = c.Article")
    Iterable<Penalty> findAllPenaltyByDriverLicense(String Driver_license_phys);

    @Query("SELECT p.decreeNumber, c.short_description, ph.Driver_license_phys FROM Penalty p, CoAO c, PenaltyHistory ph WHERE ph.INN = ?1  AND p.decreeNumber = ph.decreeNumber AND p.Article = c.Article AND p.Paid = 'false'")
    Iterable<Penalty> findPenaltyByINN(String INN);

    @Query("SELECT p.decreeNumber, c.short_description, ph.State_number FROM Penalty p, CoAO c, PenaltyHistory ph WHERE ph.State_number = ?1  AND p.decreeNumber = ph.decreeNumber AND p.Article = c.Article AND p.Paid = 'false'")
    Iterable<Penalty> findPenaltyByStateNumber(String State_number);

    @Query("SELECT p.decreeNumber, c.short_description, ph.State_number FROM Penalty p, CoAO c, PenaltyHistory ph WHERE ph.State_number = ?1  AND p.decreeNumber = ph.decreeNumber AND p.Article = c.Article")
    Iterable<Penalty> findAllPenaltyByStateNumber(String State_number);

    @Query("SELECT NEW ru.gibdd.course.pojo.PenaltyByDriverLicense(p.Paid, p.Date_time_payment, p.Date_time_penalty, p.Place_of_violation, p.Penalty_size, p.Article, c.short_description, p.decreeNumber)\n" +
            "FROM Penalty p \n" +
            "INNER JOIN PenaltyHistory ph ON p.decreeNumber = ph.decreeNumber \n" +
            "INNER JOIN CoAO c ON p.Article = c.Article \n" +
            "WHERE p.decreeNumber = ?1")
    Iterable<PenaltyByDriverLicense> findPenaltyInfoByDecreeNumber(String decreeNumber);

}
