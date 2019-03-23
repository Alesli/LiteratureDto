package com.itstep.literature.dao;

import com.itstep.literature.model.Author;

import java.util.List;

/**
 * интерфейс, обеспечивающий доступ к базе данных Mysql
 *
 * @author Слижова Олеся
 */
public interface AuthorDAO {

    Author getOne(Long id);

    List<Author> findAll();

    List<Author> findAllByBookId(Long id);

    Long save(Author author);

    Author update(Author author);

    boolean remove(Long id);
}
