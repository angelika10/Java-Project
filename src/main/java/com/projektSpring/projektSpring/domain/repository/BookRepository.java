package com.projektSpring.projektSpring.domain.repository;

import com.projektSpring.projektSpring.domain.Book;
import com.projektSpring.projektSpring.domain.Library;

import java.util.Collection;

public interface BookRepository {

    void createBook(Book book);
    void createBook(String name, String author, int numbersOfPages, Library  library);
//    void createBook(String name, String author, int numbersOfPages);

    Collection<Book> getAllBook();

    Book getBook(Integer id);



    void deleteBook(Integer id);
    void updateBook(int id, Book book);

     Book updateBook2( Book book);
}
