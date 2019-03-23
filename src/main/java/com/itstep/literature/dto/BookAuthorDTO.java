package com.itstep.literature.dto;

import java.util.List;

public class BookAuthorDTO {

    private Long id;
    private String name;
    private String genre;
    private String description;
    private List<AuthorDTO> authorDTOList;

    public BookAuthorDTO() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAuthorDTOList(List<AuthorDTO> authorDTOList) {
        this.authorDTOList = authorDTOList;
    }

    @Override
    public String toString() {
        StringBuilder a = new StringBuilder();
        for (AuthorDTO authorDTO : authorDTOList) {
            a.append("\t" + authorDTO + "\n");
        }
        return "Book: " + id + " '" + name + "', " + genre + ". " + description + " " + "\n" + a.toString();
    }
}
