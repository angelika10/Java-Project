package com.projektSpring.projektSpring.domain;

import javax.persistence.*;
import java.util.List;


public class User {


    private int id;


    private String name;


   // private List<Book> books;

    public User() {
    }

    public User(int id, String name) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public List<Book> getBooks() {
//        return books;
//    }
//
//    public void setBooks(List<Book> books) {
//        this.books = books;
//    }
}
