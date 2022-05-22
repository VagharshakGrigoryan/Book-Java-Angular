package com.example.bookbackend.model;

import javax.persistence.*;

@Entity
@Table( name = "books" )
public class Book {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private long id;

    @Column( name = "title" )
    private String title;

    @Column( name = "language" )
    private String language;

    @Column( name = "price" )
    private Double price;

    public Book() {

    }

    public Book(long id, String title, String language, Double price) {
        this.id = id;
        this.title = title;
        this.language = language;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
