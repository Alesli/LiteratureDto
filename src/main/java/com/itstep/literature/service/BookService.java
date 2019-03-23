package com.itstep.literature.service;

import com.itstep.literature.model.Book;

import java.util.List;

/**
 * интерфейс выводит книги по id автора,
 * данные в последующем используются в Facade
 *
 * @author Слижова Олеся
 */
public interface BookService {

    Book getOne(Long id);

    List<Book> getOneByName(String name);

    List<Book> getOneByGenre(String genre);

    List<Book> getOneByDescription (String partDescription);

    List<Book> findAllByAuthorId(Long id);

    Book save(Book book);

    void setBook(Long authorId, Long bookId);

    Book update(Book book);

    boolean remove(Long id);
}
