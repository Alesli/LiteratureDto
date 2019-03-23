package com.itstep.literature.service.impl;

import com.itstep.literature.dao.AuthorDAO;
import com.itstep.literature.dao.BookDAO;
import com.itstep.literature.dao.impl.AuthorDAOImpl;
import com.itstep.literature.dao.impl.BookDAOImpl;
import com.itstep.literature.model.Author;
import com.itstep.literature.service.AuthorService;

import java.util.List;

/**
 * имплементация контракта сервис-слоя
 *
 * @author Слижова Олеся
 */
public class AuthorServiceImpl implements AuthorService {

    private AuthorDAO authorDAO = new AuthorDAOImpl();

    /**
     * переопределеный метод выводит автрора по id
     *
     * @param id, уникальное имя, порядковый номер автора книги
     * @return author, данные автора из таблицы БД
     */
    @Override
    public Author getOne(Long id) {
        return authorDAO.getOne(id);
    }

    /**
     * переопределеный метод, получает список авторов и все их книги
     *
     * @return колллекция, данные авторов и их книг из таблицы БД
     */
    @Override
    public List<Author> findAll() {
        return authorDAO.findAll();
    }

    @Override
    public List<Author> findAllByBookId(Long id) {
        return authorDAO.findAllByBookId(id);
    }

    @Override
    public Author save(Author author) {
        return getOne(authorDAO.save(author));
    }

    @Override
    public Author update(Author author) {
        return authorDAO.update(author);
    }

    @Override
    public boolean remove(Long id) {
        return authorDAO.remove(id);
    }
}
