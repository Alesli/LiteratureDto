package com.itstep.literature.dto;

public class BookDTO {

    private Long id;
    private String name;
    private String genre;
    private String description;

    public BookDTO() {
    }

    public BookDTO(Long id, String name, String genre, String description) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.description = description;
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return id + " '" + name + "', " + genre + ". " + description;
    }
}
