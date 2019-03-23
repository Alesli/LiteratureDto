package com.itstep.literature.service;

import com.itstep.literature.model.Author;

import java.util.List;

/**
 * контракт сервис-слоя
 *
 * @author Слижова Олеся
 */
public interface AuthorService {

    Author getOne(Long id);

    List<Author> findAll();

    List<Author> findAllByBookId(Long id);

    Author save(Author author);

    Author update(Author author);

    boolean remove(Long id);
}
