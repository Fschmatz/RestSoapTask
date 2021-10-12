package com.fschmatz.RestSoapTask.model;

import javax.validation.constraints.NotEmpty;

public class Book {

    private int id;

    @NotEmpty //somente o titulo não pode ser nulo
    private String title;
    private String author;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id =" + id +
                ", title ='" + title + '\'' +
                ", author ='" + author + '\'' +
                '}';
    }
}
