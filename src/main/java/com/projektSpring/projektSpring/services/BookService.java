package com.projektSpring.projektSpring.services;

import com.projektSpring.projektSpring.domain.Book;
import com.projektSpring.projektSpring.domain.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return new ArrayList<>(bookRepository.getAllBook());
    }

    public Book getBook(Integer id){
        return bookRepository.getBook(id);
    }

    public void saveBook(Book book){
        bookRepository.createBook(book);
    }

    public void deleteBook(Integer id){
        bookRepository.deleteBook(id);
    }

    public void upadteBook(Book book){
        bookRepository.updateBook(book.getId(), book );
    }
    public Book upadteBook2(Book book){
      return  bookRepository.updateBook2(book);
    }


}
