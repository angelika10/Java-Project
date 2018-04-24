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


        libraryRepository.createLibrary("Biblioteka UW");
        libraryRepository.createLibrary("Biblioteka UKSW");

        Library libPw = libraryRepository.getLibrary(0);
        Library libPJATK = new Library("Bliliteka PJATK", "Koszykowa 86, 02-008 Warszawa", 20);
        Library libPW = new Library("Bliliteka PW", "Koszykowa 86, 02-008 Warszawa", 30);

         Book bok1 = new Book("jflasjdf", "dfs", 345);
        //bookRepository.createBook(bok1);
        bookRepository. createBook("Filary Ziemi", "Ken Follett ", 800,libPJATK );
        bookRepository.createBook("Dziesięć poniżej zera", "Whitney Barbetti ", 300, libPJATK);
        bookRepository. createBook("Trupia Farma. Nowe śledztwa", "Bill Bass", 400,libPW );
        bookRepository.createBook("Zabić Sarai", "J.A. Redmerski ", 500, libPW);

    }

}
