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
    public List<String> getBook() {
        return exampleData;
    }

    @PostMapping
    public String postBook(@RequestBody BookDTO bookDTO) {
        bookService.save(bookDTO);
        return "Good";
    }

}
