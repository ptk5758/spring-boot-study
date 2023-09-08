package com.ptk.ptk.book.service;

import com.ptk.ptk.book.dto.BookDTO;
import com.ptk.ptk.book.entity.BookEntity;
import com.ptk.ptk.book.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookDTO> findAll(){
        List<BookDTO> bookDTOs = new ArrayList<>();
        List<BookEntity> bookEntities = bookRepository.findAll();
        for (BookEntity entity : bookEntities) {
            bookDTOs.add(BookDTO.toBookDTO(entity));
        }
        return bookDTOs;
    }

    public void save(BookDTO bookDTO) {
//        System.out.println("save!");
//        System.out.println(bookDTO.toString());
        BookEntity bookEntity = BookEntity.toBookEntity(bookDTO);
        System.out.println(bookEntity.toString());
        bookRepository.save(bookEntity);
    }

}
