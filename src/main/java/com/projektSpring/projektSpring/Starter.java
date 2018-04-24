package com.projektSpring.projektSpring;

import com.projektSpring.projektSpring.domain.Book;
import com.projektSpring.projektSpring.domain.Library;
import com.projektSpring.projektSpring.domain.repository.BookRepository;
import com.projektSpring.projektSpring.domain.repository.LibraryRepository;
import com.projektSpring.projektSpring.services.LibraryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;


@Component
public class Starter implements CommandLineRunner {

    @Autowired
    LibraryRepository libraryRepository;

    @Autowired
    BookRepository bookRepository;

    @Override
    @Transactional
    public void run(String... strings) throws Exception{


        libraryRepository.createLibrary("Biblioteka PW");
        libraryRepository.createLibrary("Biblioteka UW");
        libraryRepository.createLibrary("Biblioteka UKSW");

        Library libPw = libraryRepository.getLibrary(0);
        Library libUW = new Library("Bliliteka pjatk", "sfasf", 44);
        Library libUW2 = new Library("Bliliteka pw", "fghfhfch", 44);

         Book bok1 = new Book("jflasjdf", "dfs", 345);
        //bookRepository.createBook(bok1);
        bookRepository. createBook("Potop", "Sienkiewicz", 800,libUW );
        bookRepository.createBook("Ogniem i mieczem", "Kowalski", 300, libUW2);
        bookRepository. createBook("thydtrh", "hdtfghdt", 800,libUW );
        bookRepository.createBook("Ohgtgxh hgdf", "bhtdfthb", 300, libUW2);

    }

}
