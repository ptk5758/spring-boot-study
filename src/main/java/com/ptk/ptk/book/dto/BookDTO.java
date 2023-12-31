package com.ptk.ptk.book.dto;

import com.ptk.ptk.book.entity.BookEntity;

public class BookDTO {
    private Long id;
    private String subject;
    private String content;

    public BookDTO(Long id, String subject, String content) {
        this.id = id;
        this.subject = subject;
        this.content = content;
    }

    public long getId() {
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

    @Override
    public String toString() {
        return "BookDTO{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public static BookDTO toBookDTO(BookEntity entity) {
        return new BookDTO(entity.getId(), entity.getSubject(), entity.getContent());

    }

}
