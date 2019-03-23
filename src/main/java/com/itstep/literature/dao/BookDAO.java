package com.itstep.literature.dao;

import com.itstep.literature.model.Book;

import java.util.List;

/**
 * интерфейс, обеспечивающий доступ к базе данных Mysql
 *
 * @author Слижова Олеся
 */
public interface BookDAO {

    Book getOne(Long id);

    List<Book> getOneByName(String name);

    List<Book> getOneByGenre(String genre);

    List<Book> getOneByDescription (String partDescription);

    List<Book> findAllByAuthorId(Long AuthorId);

    Long save(Book book);

    void setBook(Long authorId, Long bookId);

    Book update(Book book);

    boolean remove(Long id);
}
