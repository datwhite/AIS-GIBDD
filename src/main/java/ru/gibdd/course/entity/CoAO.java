package ru.gibdd.course.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CoAO")
public class CoAO {
    @Id
    @Column(name = "Article")
    private String Article;

    @Column(name = "Description")
    private String Description;

    @Column(name = "short_description")
    private String short_description;

    public CoAO() {
    }

    public CoAO(String article, String description, String short_description) {
        Article = article;
        Description = description;
        this.short_description = short_description;
    }

    public String getArticle() {
        return Article;
    }

    public void setArticle(String article) {
        Article = article;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getShort_description() {
        return short_description;
    }

    public void setShort_description(String short_description) {
        this.short_description = short_description;
    }
}
