package com.itstep.literature.dto;

import java.util.List;

public class AuthorBookDTO {

    private Long id;
    private String name;
    private String lastName;
    private List<BookDTO> bookDTOList;

    public AuthorBookDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<BookDTO> getBookDTOList() {
        return bookDTOList;
    }

    public void setBookDTOList(List<BookDTO> bookDTOList) {
        this.bookDTOList = bookDTOList;
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();
        for (BookDTO bookDTO : bookDTOList) {
            b.append("\t" + bookDTO + "\n");
        }
        return "Author: " + id + " " + name + " " + lastName + "\n    " + "Book: " + "\n" + b.toString();
    }
}
