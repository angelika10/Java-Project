package com.projektSpring.projektSpring.controller;

import com.projektSpring.projektSpring.domain.Book;
import com.projektSpring.projektSpring.domain.Library;
import com.projektSpring.projektSpring.services.BookService;
import com.projektSpring.projektSpring.services.LibraryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.List;

@Controller
public class LibraryController {

    @Autowired
    BookService bookService;

    @Autowired
    LibraryServices libraryServices;

    @RequestMapping("/assignLibrary")
    public String assignLibrary(@RequestParam("bookId") Integer id, Model model){
        Book book = bookService.getBook(id);
        List<Library> libraryList = libraryServices.getAllLibrary();
        model.addAttribute("book", book);
        model.addAttribute("librariesNames", libraryList);
        return "assignLibrary";
    }

//    @RequestMapping(value = "/assignLibrary", method = RequestMethod.POST)
//    public String assignLibrary(Book book, BindingResult result) {
//        System.out.println(result);
//        bookService.upadteBook(book);
//        return "redirect:/books";
//    }
}
