package com.projektSpring.projektSpring.domain.repository;

import com.projektSpring.projektSpring.domain.Book;
import com.projektSpring.projektSpring.domain.Library;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Collection;

public class DBBookRepository implements BookRepository {



    @PersistenceContext
    private EntityManager em;


    @Override
    @Transactional
    public void createBook(Book book) {
        em.merge(book);
    }

    @Override
    @Transactional
    public void createBook(String name, String author, int numbersOfPages, Library library) {
        Book book = new Book(name, author, numbersOfPages, library);
        em.persist(book);
    }


    @Override
    public Collection<Book> getAllBook() {
        return em.createQuery("from Book", Book.class).getResultList();
    }

    @Override
    public Book getBook(Integer id) {
        return em.find(Book.class, id);
    }


    @Override
    @Transactional
    public void deleteBook(Integer id) {
        //em.remove(id);
        Book book = em.find(Book.class, id);
        em.remove(book);

    }

    @Transactional
    @Modifying
    @Query("update Book b set b.name = ?1, b.author = ?2,  b.numbersOfPage = ?3, b.isHired = ?4, b.Library = ?5  where b.id = ?6")
    public Book updateBook2(Book book) {
        return em.merge(book);

    }
    @Transactional
    public void updateBook(int id, Book book) {
        Book book1 = em.find(Book.class, id);
        String autor  = book.getAuthor();
        String nazwa = book.getName();
        Library library = book.getLibrary();
        int number = book.getNumbersOfPage();
        book1.setAuthor(autor);
        book1.setLibrary(library);
        book1.setName(nazwa);
        book1.setNumbersOfPage(number);

        em.merge(book);
        //em.persist(book1);
    }



}
