package com.ptk.ptk.book;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/book")
public class BookController {
    @GetMapping
    public String getBook() {
        return "Hello World";
    }

}
