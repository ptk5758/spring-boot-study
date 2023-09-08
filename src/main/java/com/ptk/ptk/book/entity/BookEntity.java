package com.ptk.ptk.book.entity;

import com.ptk.ptk.book.dto.BookDTO;

import javax.persistence.*;

@Entity
@Table(name = "book")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String subject;

    @Column
    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public BookEntity() {}

    public BookEntity(Long id, String subject, String content) {
        this.id = id;
        this.subject = subject;
        this.content = content;
    }

    @Override
    public String toString() {
        return "BookEntity{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", content='" + content + '\'' +
                '}';
    }


    public static BookEntity toBookEntity(BookDTO bookDTO) {
        return new BookEntity(bookDTO.getId(), bookDTO.getSubject(), bookDTO.getContent());
    }

    public static BookEntity toUpdateBookEntity(BookDTO bookDTO) {
        return new BookEntity(bookDTO.getId(), bookDTO.getSubject(), bookDTO.getContent());
    }
}
