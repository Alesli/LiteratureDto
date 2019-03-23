package com.itstep.literature.service.impl;

import com.itstep.literature.dao.BookDAO;
import com.itstep.literature.dao.impl.BookDAOImpl;
import com.itstep.literature.model.Book;
import com.itstep.literature.service.BookService;

import java.util.List;

/**
 * класс реализует интерфейс BookService, получает данные DAO слоя
 *
 * @author Слижова Олеся
 */
public class BookServiceImpl implements BookService {

    private BookDAO bookDAO = new BookDAOImpl();

    @Override
    public Book getOne(Long id) {
        return bookDAO.getOne(id);
    }

    @Override
    public List<Book> getOneByName(String name) {
        return bookDAO.getOneByName("%" + name + "%");
    }

    @Override
    public List<Book> getOneByGenre(String genre) {
        return bookDAO.getOneByGenre("%" + genre + "%");
    }

    @Override
    public List<Book> getOneByDescription(String partDescription) {
        return bookDAO.getOneByDescription("%" + partDescription + "%");
    }

    /**
     * переопределеный метод, получает все книги, написанные определенный автором по входному параметру
     *
     * @param id, уникальное имя, порядковый номер автора книги
     * @return результат метода getAllBooksByAuthorId из класса BookDAOImpl
     */
    @Override
    public List<Book> findAllByAuthorId(Long id) {
        return bookDAO.findAllByAuthorId(id);
    }

    @Override
    public Book save(Book book) {
        return getOne(bookDAO.save(book));
    }

    @Override
    public void setBook(Long authorId, Long bookId) {
        bookDAO.setBook(authorId, bookId);
    }

    @Override
    public Book update(Book book) {
        return bookDAO.update(book);
    }

    @Override
    public boolean remove(Long id) {
        return bookDAO.remove(id);
    }
}
