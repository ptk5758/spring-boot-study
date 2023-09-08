package com.ptk.ptk.book.controller;

import com.ptk.ptk.book.dto.BookDTO;
import com.ptk.ptk.book.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/book")
public class BookController {

    private static List<String> exampleData = List.of("책1", "책2");

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<BookDTO> getBook() {
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public BookDTO findById(@PathVariable Long id) {
        return bookService.findById(id);
    }

    @PostMapping
    public String postBook(@RequestBody BookDTO bookDTO) {
        bookService.save(bookDTO);
        return "Good";
    }

}
