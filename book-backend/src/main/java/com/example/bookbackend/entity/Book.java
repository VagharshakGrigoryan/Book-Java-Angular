package com.example.bookbackend.entity;

import javax.persistence.*;

@Entity
@Table( name = "book" )
public class Book {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private long id;

    @Column( name = "title" )
    private String title;

    @Column( name = "language" )
    private String language;

    @Column( name = "description" )
    private String description;

    @Column( name = "price" )
    private Double price;

    @ManyToOne
    @JoinColumn( name = "author" )
    private Author author;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Book() {
    }

    public Book(long id, String title, String language, Double price, Author author,String description) {
        this.id = id;
        this.title = title;
        this.language = language;
        this.price = price;
        this.author = author;
        this.description = description;

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

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
