package com.projektSpring.projektSpring.services;

import com.projektSpring.projektSpring.domain.Library;
import com.projektSpring.projektSpring.domain.repository.BookRepository;
import com.projektSpring.projektSpring.domain.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibraryServices {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    LibraryRepository libraryRepository;



//    public void assingLibrary(Integer id, int libraryNumber){
//       Library library =  libraryRepository.getLibrary(libraryNumber);
//        bookRepository.getBook(id).setLibrary(library);
//
//    }

    public List<Library> getAllLibrary(){
        return libraryRepository.showAllLibrary();
    }

    public List<String> getAllLibraryString(){
         return libraryRepository.nameAllLibraries();
    }
}
