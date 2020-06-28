package ru.gibdd.course.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
public class GibddEmployee{
    @Id
    private Long id_employee;

    @Column(name = "Certificate_number")
    private String certificate;

    private String FIO;

    private String Rank;

    private String Post;

    @Column(name = "Password_employee")
    private String password;

    private String Department_code;

    public Long getId_employee() {
        return id_employee;
    }

    public void setId_employee(Long id_employee) {
        this.id_employee = id_employee;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public String getRank() {
        return Rank;
    }

    public void setRank(String rank) {
        Rank = rank;
    }

    public String getPost() {
        return Post;
    }

    public void setPost(String post) {
        Post = post;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDepartment_code() {
        return Department_code;
    }

    public void setDepartment_code(String department_code) {
        Department_code = department_code;
    }

    public GibddEmployee() {
    }

    public GibddEmployee(Long id_employee, String certificate, String FIO, String rank, String post, String password, String department_code) {
        this.id_employee = id_employee;
        this.certificate = certificate;
        this.FIO = FIO;
        Rank = rank;
        Post = post;
        this.password = password;
        Department_code = department_code;
    }
}
