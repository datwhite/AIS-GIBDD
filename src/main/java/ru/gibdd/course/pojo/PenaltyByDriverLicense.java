package ru.gibdd.course.pojo;

import java.util.Date;

public class PenaltyByDriverLicense {

    public boolean Paid;
    public Date Date_time_payment;
    public Date Date_time_penalty;
    public String Place_of_violation;
    public String Penalty_size;
    public String Article;
    public String short_description;
    public String decreeNumber;

    public PenaltyByDriverLicense() {
    }

    public PenaltyByDriverLicense(boolean paid, Date date_time_payment, Date date_time_penalty, String place_of_violation, String penalty_size, String article, String short_description, String decreeNumber) {
        Paid = paid;
        Date_time_payment = date_time_payment;
        Date_time_penalty = date_time_penalty;
        Place_of_violation = place_of_violation;
        Penalty_size = penalty_size;
        Article = article;
        this.decreeNumber = decreeNumber;
        this.short_description = short_description;
    }

    public String getDecreeNumber() {
        return decreeNumber;
    }

    public void setDecreeNumber(String decreeNumber) {
        this.decreeNumber = decreeNumber;
    }

    public String getShort_description() {
        return short_description;
    }

    public void setShort_description(String short_description) {
        this.short_description = short_description;
    }

    public boolean isPaid() {
        return Paid;
    }

    public void setPaid(boolean paid) {
        Paid = paid;
    }

    public Date getDate_time_payment() {
        return Date_time_payment;
    }

    public void setDate_time_payment(Date date_time_payment) {
        Date_time_payment = date_time_payment;
    }

    public Date getDate_time_penalty() {
        return Date_time_penalty;
    }

    public void setDate_time_penalty(Date date_time_penalty) {
        Date_time_penalty = date_time_penalty;
    }

    public String getPlace_of_violation() {
        return Place_of_violation;
    }

    public void setPlace_of_violation(String place_of_violation) {
        Place_of_violation = place_of_violation;
    }

    public String getPenalty_size() {
        return Penalty_size;
    }

    public void setPenalty_size(String penalty_size) {
        Penalty_size = penalty_size;
    }

    public String getArticle() {
        return Article;
    }

    public void setArticle(String article) {
        Article = article;
    }
}
