package com.fschmatz.RestSoapTask.controller;


import com.fschmatz.RestSoapTask.model.Book;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private List<Book> books = new ArrayList<>();

    //valores sendo forçados em lista
    public BookController() {
        Book b1 = new Book();
        b1.setId(0);
        b1.setTitle("Blade Runner");
        b1.setAuthor("Phillip K. Dick");

        Book b2 = new Book();
        b2.setId(1);
        b2.setTitle("Dick Vigarista : Uma Vida");
        b2.setAuthor("Muttley");

        Book b3 = new Book();
        b3.setId(2);
        b3.setTitle("The Spy and the Traitor");
        b3.setAuthor("Ben Macintyre");

        Book b4 = new Book();
        b4.setId(3);
        b4.setTitle("1984");
        b4.setAuthor("George Orwell");


        books.addAll(Arrays.asList(
                b1, b2, b3, b4
        ));
    }


    @GetMapping
    public List<Book> getAllBooks() {
        return books;
    }

    @GetMapping("/{id}")
    public Book findById(@PathVariable Integer id) {
        return books.stream().filter(book -> book.getId() == id).findFirst().get();
    }

    @PostMapping
    public void createBook(@RequestBody Book book) {
        books.add(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Integer id) {
        books.remove(id);
    }


    public Book findByIdSoap(@PathVariable Integer id) {
        return books.stream().filter(bookSoap -> bookSoap.getId() == id).findFirst().get();
    }
}
