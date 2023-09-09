package com.ptk.ptk.book.controller;

import com.ptk.ptk.book.dto.BookDTO;
import com.ptk.ptk.book.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @PostMapping("/update")
    public String updateBook(@RequestBody BookDTO bookDTO) {
        // System.out.println(bookDTO.toString());
        bookService.update(bookDTO);
        return "Good";
    }

    @PostMapping
    public String postBook(@RequestBody BookDTO bookDTO) {
        bookService.save(bookDTO);
        return "Good";
    }

    @GetMapping("/delete/{id}")
    public Map<String, String> deleteById(@PathVariable Long id) {
        Map map = new HashMap();
        map.put("msg", "Good");
        bookService.deleteById(id);
        return map;
    }



}
