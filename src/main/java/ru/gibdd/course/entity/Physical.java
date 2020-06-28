package ru.gibdd.course.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Physical {
    @Id
    @Column(name = "id_phys")
    private Long idPhys;

    @Column(name = "FIO_phys")
    private String fio;

    @Column(name = "Driver_license_phys")
    private String license;

    @Column(name = "Passport_ser_num_phys")
    private String passport;

    @Column(name = "Phone_num_phys")
    private String phoneNumber;

    @Column(name = "Date_of_birth")
    private Date dateBirth;

    private Boolean sex;

    public Long getIdPhys() {
        return idPhys;
    }

    public void setIdPhys(Long idPhys) {
        this.idPhys = idPhys;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public Physical() {
    }

    public Physical(Long idPhys, String fio, String license, String passport, String phoneNumber, Date dateBirth, Boolean sex) {
        this.idPhys = idPhys;
        this.fio = fio;
        this.license = license;
        this.passport = passport;
        this.phoneNumber = phoneNumber;
        this.dateBirth = dateBirth;
        this.sex = sex;
    }
}
