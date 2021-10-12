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
        books.addAll(Arrays.asList(
                new Book(0, "Blade Runner", "Phillip K. Dick"),
                new Book(1, "Raining Blood", "Zé Colmeia"),
                new Book(2, "Dick Vigarista : Uma Vida", "Muttley"),
                new Book(3, "The Spy and the Traitor", "Ben Macintyre"),
                new Book(4, "1984", "George Orwell")
        ));
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return books;
    }

    @GetMapping("/{id}")
    public Book findById(@PathVariable Integer id){
        return books.stream().filter(book -> book.getId() == id).findFirst().get();
    }

    @PostMapping
    public void createBook(@RequestBody Book book){
        books.add(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Integer id){
        books.remove(id);
    }
}
