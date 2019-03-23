package com.itstep.literature.dao.impl;

import com.itstep.literature.jdbc.ServerConnector;
import com.itstep.literature.dao.AuthorDAO;
import com.itstep.literature.model.Author;
import com.itstep.literature.jdbc.ServerQuery;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * класс реализует интерфейс AuthorDAO, получает данные из таблиц БД MySQL
 * через запросы из файла mysql_queries.properties с использованием JDBC.
 *
 * @author Слижова Олеся
 */
public class AuthorDAOImpl implements AuthorDAO {

    /**
     * переопределеный метод, получает автора книги по входному параметру
     *
     * @param id, уникальное имя, порядковый номер автора книги
     * @return результат запроса getOneAuthor из файла mysql_queries.properties
     */
    @Override
    public Author getOne(Long id) {

        PreparedStatement preparedStatement = null;
        Connection connection = ServerConnector.getInstance().getConnection();
        ResultSet resultSet = null;
        Author author = new Author();

        try {
            String query = ServerQuery.getInstance().getQuery("getOneAuthor");
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                author.setId(resultSet.getLong(1));
                author.setName(resultSet.getString(2));
                author.setLastName(resultSet.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(preparedStatement, resultSet);
        }
        return author;
    }

    /**
     * переопределеный метод, получает список авторов по входному параметру
     *
     * @return результат запроса getAllAuthors из файла mysql_queries.properties
     */
    @Override
    public List<Author> findAll() {

        PreparedStatement preparedStatement = null;
        Connection connection = ServerConnector.getInstance().getConnection();
        ResultSet resultSet = null;
        List<Author> authorsList = new ArrayList<>();

        try {
            String query = ServerQuery.getInstance().getQuery("getAllAuthors");
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Author author = getAuthor(resultSet);
                authorsList.add(author);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(preparedStatement, resultSet);
        }
        return authorsList;
    }

    @Override
    public List<Author> findAllByBookId(Long id) {

        PreparedStatement preparedStatement = null;
        Connection connection = ServerConnector.getInstance().getConnection();
        ResultSet resultSet = null;
        List<Author> authorsList = new ArrayList<>();

        try {
            String query = ServerQuery.getInstance().getQuery("getAllAuthorsByBookId");
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Author author = getAuthor(resultSet);
                authorsList.add(author);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(preparedStatement, resultSet);
        }
        return authorsList;
    }

    private Author getAuthor(ResultSet resultSet) {

        try {
            Author author = new Author();
            author.setId(resultSet.getLong(1));
            author.setName(resultSet.getString(2));
            author.setLastName(resultSet.getString(3));
            return author;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Long save(Author author) {
        PreparedStatement preparedStatement = null;
        Connection connection = ServerConnector.getInstance().getConnection();
        ResultSet resultSet = null;
        try {
            String query = ServerQuery.getInstance().getQuery("saveAuthor");
            preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, author.getName());
            preparedStatement.setString(2, author.getLastName());
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
    public Author update(Author author) {

        PreparedStatement preparedStatement = null;
        Connection connection = ServerConnector.getInstance().getConnection();
        ResultSet resultSet = null;
        try {
            String query = ServerQuery.getInstance().getQuery("updateAuthor");
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, author.getId());
            preparedStatement.setString(2, author.getName());
            preparedStatement.setString(3, author.getLastName());
            preparedStatement.setLong(4, author.getId());
            if (preparedStatement.executeUpdate() > 0) {
                return getOne(author.getId());
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
            String query = ServerQuery.getInstance().getQuery("removeAuthor");
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
