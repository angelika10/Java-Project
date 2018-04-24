package com.projektSpring.projektSpring.controller;

import com.projektSpring.projektSpring.domain.Book;
import com.projektSpring.projektSpring.domain.Library;
import com.projektSpring.projektSpring.services.BookService;
import com.projektSpring.projektSpring.services.LibraryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
public class BookController {

    @Autowired
    BookService bookService;

    @Autowired
    LibraryServices libraryServices;

    @RequestMapping("/books")
    public String getBooks(Model model){
        List<Book> allBooks = bookService.getAllBooks();
        model.addAttribute("books", allBooks);
        return "books";
    }

    @RequestMapping("/book")
    public String getBook(@RequestParam("id") int id, Model model){
        List<String> allLibrariesName = libraryServices.getAllLibraryString();
        Book book = bookService.getBook(id);
        model.addAttribute("book", book);
        model.addAttribute("libraries", allLibrariesName);
        model.addAttribute("id", book.getId());
        return "book";
    }

    @RequestMapping("/newbook")
    public String createBook(Model model){
        List<String> allLibrariesName = libraryServices.getAllLibraryString();
        model.addAttribute("book", new Book());
        model.addAttribute("libraries", allLibrariesName);
        return "bookform";
    }

    @RequestMapping(value="/books", method = RequestMethod.POST)
    public String saveBook(@Valid Book book, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            System.out.println("There were errors");
            bindingResult.getAllErrors().forEach(error -> {
                        System.out.println(error.getObjectName() + " " + error.getDefaultMessage());
                    }
            );
            return "bookform";
        }else {
        bookService.saveBook(book);
        return "redirect:/books";
    }}

    @RequestMapping(value="/book/delete/{id}")
    public String deleteBook(@PathVariable("id") Integer id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }



    @RequestMapping(value="/book", method = RequestMethod.POST)
    public String editBook(@Valid Book book,@Valid Integer id, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            System.out.println("There were errors");
            bindingResult.getAllErrors().forEach(error -> {
                        System.out.println(error.getObjectName() + " " + error.getDefaultMessage());
                    }
            );
            return "book";
        }else {
            bookService.upadteBook(book);
            return "redirect:/books";
        }}
}
