package com.projektSpring.projektSpring.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String address;
    private int numbersOfbooks;

//    @OneToMany(mappedBy = "library")
//    private List<Book> books;


    public Library(String name, String address, int numbersOfbooks) {
        this.name = name;
        this.address = address;
        this.numbersOfbooks = numbersOfbooks;
    }
    public Library(int id, String name) {
        this.id = id;
        this.name = name;

    }

    public Library( String name) {
        this.name = name;

    }
    public Library() {
    }

//    public List<Book> getBooks() {
//        return books;
//    }
//
//    public void setBooks(List<Book> books) {
//        this.books = books;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNumbersOfbooks() {
        return numbersOfbooks;
    }

    public void setNumbersOfbooks(int numbersOfbooks) {
        this.numbersOfbooks = numbersOfbooks;
    }

    @Override
    public String toString() {
        return "Library{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", numbersOfbooks=" + numbersOfbooks +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Library library = (Library) o;
        return id == library.id;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
