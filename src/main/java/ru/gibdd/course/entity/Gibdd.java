package ru.gibdd.course.entity;

import javax.persistence.*;


@Entity
public class Gibdd {
    @Id
    private String Department_code;

    private String Unit_name;
    private String Adress;
    private String Phone_number;
    private String Requisites;

    public String getDepartment_code() {
        return Department_code;
    }

    public void setDepartment_code(String department_code) {
        Department_code = department_code;
    }

    public String getUnit_name() {
        return Unit_name;
    }

    public void setUnit_name(String unit_name) {
        Unit_name = unit_name;
    }

    public String getAdress() {
        return Adress;
    }

    public void setAdress(String adress) {
        Adress = adress;
    }

    public String getPhone_number() {
        return Phone_number;
    }

    public void setPhone_number(String phone_number) {
        Phone_number = phone_number;
    }

    public String getRequisites() {
        return Requisites;
    }

    public void setRequisites(String requisites) {
        Requisites = requisites;
    }

    public Gibdd() {
    }

    public Gibdd(String department_code, String unit_name, String adress, String phone_number, String requisites) {
        Department_code = department_code;
        Unit_name = unit_name;
        Adress = adress;
        Phone_number = phone_number;
        Requisites = requisites;
    }
}
