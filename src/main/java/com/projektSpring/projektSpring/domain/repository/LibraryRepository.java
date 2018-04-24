package com.projektSpring.projektSpring.domain.repository;

import com.projektSpring.projektSpring.domain.Book;
import com.projektSpring.projektSpring.domain.Library;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.*;

@Repository
public class LibraryRepository {

    @PersistenceContext
    private EntityManager em;


    @Transactional
    public void createLibrary(String name){
        Library newLibrary = new Library(name);
        em.persist(newLibrary);
    }



    public  List<Library> showAllLibrary(){
        return em.createQuery("from Library", Library.class).getResultList();
    }


    public List<String> nameAllLibraries(){

        List<Library> allLibraries = em.createQuery("from Library", Library.class).getResultList();
        List<String> nameAll = new ArrayList<>();
        for (Library library: allLibraries){
           String name =  library.getName();
            nameAll.add(name);
        }
        return nameAll;
    }

    public Library getLibrary(Integer id){ return em.find(Library.class, id);
    }


    @Transactional
    public void update(Library library) {
        em.merge(library);
    }

    @Transactional
    public void deleteLibrary(Library library) {
        em.remove(library);
    }
}
