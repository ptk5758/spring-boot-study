package com.ptk.ptk.book.service;

import com.ptk.ptk.book.dto.BookDTO;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    public void Test() {
        System.out.println("dsadas");
    }

    public void save(BookDTO bookDTO) {
        System.out.println("save!");
        System.out.println(bookDTO.toString());
    }

}
