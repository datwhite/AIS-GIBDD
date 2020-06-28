package ru.gibdd.course.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
//import java.sql.Date;


@Entity
@Table(name = "Penalty")
public class Penalty {
    @Id
    @Column(name = "Decree_number")
    public String decreeNumber;

    @Column(name = "Certificate_number")
    private String Certificate_number;

    @Column(name = "Camera_number")
    private Long Camera_number;

    @Column(name = "Article")
    private String Article;

    @Column(name = "Date_time_penalty")
    private Date Date_time_penalty;

    @Column(name = "Date_time_payment")
    private Date Date_time_payment;

    @Column(name = "Penalty_size")
    private String Penalty_size;

    @Column(name = "Paid")
    private boolean Paid;

    @Column(name = "Photo")
    private String Photo;

    @Column(name = "Place_of_violation")
    private String Place_of_violation;

    @OneToOne(mappedBy = "penalty", cascade = CascadeType.ALL)
    private PenaltyHistory penaltyHistory;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "Article", insertable=false, updatable=false)
    private CoAO coAO;

    public PenaltyHistory getPenaltyHistory() {
        return penaltyHistory;
    }

    public void setPenaltyHistory(PenaltyHistory penaltyHistory) {
        this.penaltyHistory = penaltyHistory;
    }

    public CoAO getCoAO() {
        return coAO;
    }

    public void setCoAO(CoAO coAO) {
        this.coAO = coAO;
    }

    public String getDecreeNumber() {
        return decreeNumber;
    }

    public void setDecreeNumber(String decreeNumber) {
        this.decreeNumber = decreeNumber;
    }

    public String getCertificate_number() {
        return Certificate_number;
    }

    public void setCertificate_number(String certificate_number) {
        Certificate_number = certificate_number;
    }

    public Long getCamera_number() {
        return Camera_number;
    }

    public void setCamera_number(Long camera_number) {
        Camera_number = camera_number;
    }

    public String getArticle() {
        return Article;
    }

    public void setArticle(String article) {
        Article = article;
    }

    public Date getDate_time_penalty() {
        return Date_time_penalty;
    }

    public void setDate_time_penalty(Date date_time_penalty) {
        Date_time_penalty = date_time_penalty;
    }

    public Date getDate_time_payment() {
        return Date_time_payment;
    }

    public void setDate_time_payment(Date date_time_payment) {
        Date_time_payment = date_time_payment;
    }

    public String getPenalty_size() {
        return Penalty_size;
    }

    public void setPenalty_size(String penalty_size) {
        Penalty_size = penalty_size;
    }

    public boolean isPaid() {
        return Paid;
    }

    public void setPaid(boolean paid) {
        Paid = paid;
    }

    public String getPhoto() {
        return Photo;
    }

    public void setPhoto(String photo) {
        Photo = photo;
    }

    public String getPlace_of_violation() {
        return Place_of_violation;
    }

    public void setPlace_of_violation(String place_of_violation) {
        Place_of_violation = place_of_violation;
    }

    public Penalty() {
    }

    public Penalty(String decreeNumber, String certificate_number, Long camera_number, String article, Date date_time_penalty, String penalty_size, boolean paid, String place_of_violation) {
        this.decreeNumber = decreeNumber;
        Certificate_number = certificate_number;
        Camera_number = camera_number;
        Article = article;
        Date_time_penalty = date_time_penalty;
        Penalty_size = penalty_size;
        Paid = paid;
        Place_of_violation = place_of_violation;
    }


}
