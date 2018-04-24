package com.projektSpring.projektSpring.config;

import com.projektSpring.projektSpring.domain.repository.BookRepository;
import com.projektSpring.projektSpring.domain.repository.DBBookRepository;
import com.projektSpring.projektSpring.domain.repository.InMemoryRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class MianConfig {


    @Bean(name = "inMemoryBookRepository")
    @Profile("dev")
    public BookRepository createInMemoryRepo(){
        BookRepository repo = new InMemoryRepository();
        return repo;
    }

    @Bean(name = "DBBookRepository")
    @Profile("db")
    public BookRepository createDByRepo(){
        BookRepository repo = new DBBookRepository();
        return repo;
    }
}
