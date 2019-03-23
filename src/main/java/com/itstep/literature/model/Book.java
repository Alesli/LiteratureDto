package com.itstep.literature.model;

/**
 * модель данных book / книга
 *
 * @author Слижова Олеся
 */

public class Book {

    private Long id;
    private String name;
    private String genre;
    private String description;

    public Book() {
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
        return "Book: " + id + ", " + name + ", " + genre + ", " + description;
    }
}
