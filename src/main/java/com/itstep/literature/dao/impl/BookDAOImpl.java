package com.itstep.literature.dao.impl;

import com.itstep.literature.dao.BookDAO;
import com.itstep.literature.jdbc.ServerConnector;
import com.itstep.literature.jdbc.ServerQuery;
import com.itstep.literature.model.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * класс реализует интерфейс BookDAO, получает данные из таблиц БД MySQL,
 * с использованием JDBC.
 *
 * @author Слижова Олеся
 */
public class BookDAOImpl implements BookDAO {

    private Connection connection = ServerConnector.getInstance().getConnection();

    @Override
    public Book getOne(Long id) {

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Book book = new Book();

        try {
            String query = ServerQuery.getInstance().getQuery("getOneBook");
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                book.setId(resultSet.getLong(1));
                book.setName(resultSet.getString(2));
                book.setGenre(resultSet.getString(3));
                book.setDescription(resultSet.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(preparedStatement, resultSet);
        }
        return book;
    }

    @Override
    public List<Book> getOneByName(String name) {

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Book> books = new ArrayList<>();

        try {
            String query = ServerQuery.getInstance().getQuery("getBookByName");
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Book book = getBook(resultSet);
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(preparedStatement, resultSet);
        }
        return books;
    }

    @Override
    public List<Book> getOneByGenre(String genre) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Book> books = new ArrayList<>();

        try {
            String query = ServerQuery.getInstance().getQuery("getBookByGenre");
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, genre);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Book book = getBook(resultSet);
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(preparedStatement, resultSet);
        }
        return books;
    }

    @Override
    public List<Book> getOneByDescription(String partDescription) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Book> books = new ArrayList<>();

        try {
            String query = ServerQuery.getInstance().getQuery("getBooksByDescription");
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, partDescription);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Book book = getBook(resultSet);
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(preparedStatement, resultSet);
        }
        return books;
    }

    /**
     * переопределеный метод, получает все книги, написанные определенный автором по входному параметру
     *
     * @param id, уникальное имя, порядковый номер автора книги
     * @return результат запроса "getAllBooksByAuthorId" в БД
     */
    @Override
    public List<Book> findAllByAuthorId(Long id) {

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Book> books = new ArrayList<>();

        try {
            String query = ServerQuery.getInstance().getQuery("getAllBooksByAuthorId");
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Book book = getBook(resultSet);
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(preparedStatement, resultSet);
        }
        return books;
    }

    @Override
    public Long save(Book book) {

        PreparedStatement preparedStatement = null;
        Connection connection = ServerConnector.getInstance().getConnection();
        ResultSet resultSet = null;

        try {
            String query = ServerQuery.getInstance().getQuery("saveBook");
            preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, book.getName());
            preparedStatement.setString(2, book.getGenre());
            preparedStatement.setString(3, book.getDescription());
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                return resultSet.getLong(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(preparedStatement, resultSet);
        }
        return null;
    }

    @Override
    public void setBook(Long authorId, Long bookId) {
        PreparedStatement preparedStatement = null;
        Connection connection = ServerConnector.getInstance().getConnection();
        ResultSet resultSet = null;
        try {
            String query = ServerQuery.getInstance().getQuery("setBook");
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, authorId);
            preparedStatement.setLong(2, bookId);
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(preparedStatement, resultSet);
        }
    }

    @Override
    public Book update(Book book) {
        PreparedStatement preparedStatement = null;
        Connection connection = ServerConnector.getInstance().getConnection();
        ResultSet resultSet = null;
        try {
            String query = ServerQuery.getInstance().getQuery("updateBook");
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, book.getId());
            preparedStatement.setString(2, book.getName());
            preparedStatement.setString(3, book.getGenre());
            preparedStatement.setString(4, book.getDescription());
            preparedStatement.setLong(5, book.getId());
            if (preparedStatement.executeUpdate() > 0) {
                return getOne(book.getId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(preparedStatement, resultSet);
        }
        return null;
    }

    @Override
    public boolean remove(Long id) {
        PreparedStatement preparedStatement = null;
        Connection connection = ServerConnector.getInstance().getConnection();
        ResultSet resultSet = null;

        try {
            String query = ServerQuery.getInstance().getQuery("removeBook");
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);

            if (preparedStatement.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(preparedStatement, resultSet);
        }
        return false;
    }

    /**
     * метод обеспечивает построчный доступ к результатам запросов,
     * прописанного в файле mysql_queries.properties
     *
     * @param resultSet
     * @return данные книги из запроса
     */
    private Book getBook(ResultSet resultSet) {

        try {
            Book book = new Book();
            book.setId(resultSet.getLong(1));
            book.setName(resultSet.getString(2));
            book.setGenre(resultSet.getString(3));
            book.setDescription(resultSet.getString(4));
            return book;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * метод закрывает соединение
     *
     * @param preparedStatement
     * @param resultSet
     */
    private void close(PreparedStatement preparedStatement, ResultSet resultSet) {

        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
