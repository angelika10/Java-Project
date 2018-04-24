package com.projektSpring.projektSpring.domain;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String author;
    private int numbersOfPage;
    private boolean isHired = false;

//    @ManyToOne
//    @JoinColumn(name="library_id", nullable=false)
    @OneToOne(cascade = {CascadeType.ALL})
    private Library library;

    public Book() {
    }

    public Book(String name, String author, int numbersOfPage, Library library) {
        this.name = name;
        this.author = author;
        this.numbersOfPage = numbersOfPage;
        this.library = library;
    }

    public Book(String name, String author, int numbersOfPage) {
        this.name = name;
        this.author = author;
        this.numbersOfPage = numbersOfPage;
    }

    public void setLibrary(Library library) {
        System.out.println("Ustawiono bibliotekę dla książki");
        this.library = library;
    }
    public Library getLibrary() {
    return library;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", numberOfPage=" + numbersOfPage  +
                '}' ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getNumbersOfPage() {
        return numbersOfPage;
    }

    public void setNumbersOfPage(int numbersOfPage) {
        this.numbersOfPage = numbersOfPage;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public boolean isHired() {
//        return isHired;
//    }
//
//    public void setHired(boolean hired) {
//        isHired = hired;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
