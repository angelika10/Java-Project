package com.projektSpring.projektSpring.domain.repository;

import com.projektSpring.projektSpring.domain.Book;
import com.projektSpring.projektSpring.domain.Library;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class InMemoryRepository implements BookRepository {

    Map<Integer, Book> books = new HashMap<>();

    public InMemoryRepository() { }

    @Override
    public void createBook(String name, String author, int numbersOfPages, Library  library){
        Book newBook = new Book(name, author, numbersOfPages, library);
        newBook.setId(getNewId());
        books.put(newBook.getId(), newBook);
    }


    @Override
    public void createBook(Book book) {
      book.setId(getNewId());
      books.put(book.getId(), book);
    }

    @Override
    public Collection<Book> getAllBook() {
        return books.values();
    }

    @Override
    public Book getBook(Integer id) {
        return books.get(id);
    }

    @Override
    public void deleteBook(Integer id){
        books.remove(id);
    }

    @Override
    public void updateBook(int id, Book book){
        books.put(id, book);
        System.out.println( "id"+ id);
        System.out.println(getKeyFromValue(books, book));
        System.out.println(books);
    }

    @Override
    public Book updateBook2(Book book) {
        return null;
    }



    public static Object getKeyFromValue(Map hm, Object value) {
        for (Object o : hm.keySet()) {
            if (hm.get(o).equals(value)) {
                return o;
            }
        }
        return null;
    }



    public int getNewId(){
        if(books.isEmpty()){
            return 0;
        }else{
            Integer integer = books.keySet().stream().max((o1, o2) -> o1.compareTo(o2)).get();
            return integer+1;
        }
    }



}
