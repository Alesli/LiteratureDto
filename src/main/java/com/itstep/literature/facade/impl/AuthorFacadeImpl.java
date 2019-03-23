package com.itstep.literature.facade.impl;

import com.itstep.literature.converter.Converter;
import com.itstep.literature.converter.to.dto.AuthorBookToDTO;
import com.itstep.literature.converter.to.dto.AuthorToDTO;
import com.itstep.literature.converter.to.model.AuthorBookToModel;
import com.itstep.literature.converter.to.model.AuthorToModel;
import com.itstep.literature.converter.to.model.BookToModel;
import com.itstep.literature.dto.AuthorBookDTO;
import com.itstep.literature.dto.AuthorDTO;
import com.itstep.literature.dto.BookDTO;
import com.itstep.literature.facade.AuthorFacade;
import com.itstep.literature.facade.BookFacade;
import com.itstep.literature.model.Author;
import com.itstep.literature.model.Book;
import com.itstep.literature.service.AuthorService;
import com.itstep.literature.service.BookService;
import com.itstep.literature.service.impl.AuthorServiceImpl;
import com.itstep.literature.service.impl.BookServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class AuthorFacadeImpl implements AuthorFacade {

    private AuthorService authorService = new AuthorServiceImpl();
    private BookService bookService = new BookServiceImpl();
    private Converter<Author, AuthorDTO> authorToDTO = new AuthorToDTO();
    private Converter<AuthorDTO, Author> authorToModel = new AuthorToModel();
    private Converter<Author, AuthorBookDTO> authorBookToDTO = new AuthorBookToDTO();
    private Converter<AuthorBookDTO, Author> authorBookToModel = new AuthorBookToModel();
    private Converter<BookDTO, Book> bookToModel = new BookToModel();
    private BookFacade bookFacade = new BookFacadeImpl();

    /**
     * переопределенный метод, выводит автора по первичному ключу
     *
     * @param id, уникальное имя, порядковый номер автора книги
     * @return конвертирует author
     */
    @Override
    public AuthorDTO getAuthor(Long id) {
        Author author = authorService.getOne(id);
        return authorToDTO.convert(author);
    }

    /**
     * переопределенный метод, выводит всех авторов
     *
     * @return конвертирует author
     */
    @Override
    public List<AuthorDTO> getAllAuthors() {

        List<Author> authors = authorService.findAll();
        List<AuthorDTO> authorList = new ArrayList<>(authors.size());
        for (Author a : authors) {
            authorList.add(authorToDTO.convert(a));
        }
        return authorList;
    }

    @Override
    public AuthorBookDTO getAuthorBook(Long id) {

        Author author = authorService.getOne(id);
        AuthorBookDTO authorBookDTO = authorBookToDTO.convert(author);

        return authorBookDTO;
    }

    @Override
    public List<AuthorBookDTO> getAllAuthorBook() {
        List<Author> authors = authorService.findAll();
        List<AuthorBookDTO> authorList = new ArrayList<>(authors.size());
        for (Author a : authors) {
            authorList.add(authorBookToDTO.convert(a));
        }
        return authorList;
    }

    @Override
    public AuthorDTO saveAuthor(AuthorDTO authorDTO) {
        Author author = authorToModel.convert(authorDTO);
        Author newAuthor = authorService.save(author);
        return authorToDTO.convert(newAuthor);
    }

    @Override
    public AuthorBookDTO addAuthorBook(AuthorBookDTO authorBookDTO) {

        // сохранили автора
        Author author = authorBookToModel.convert(authorBookDTO);
        long authorId = authorService.save(author).getId();

        // сохраняем его книги и сетаем их ему
        List<BookDTO> bookDTOList = authorBookDTO.getBookDTOList();
        List<Book> bookList = new ArrayList<>(bookDTOList.size());
        for (BookDTO bookDTO : bookDTOList) {
            bookList.add(bookToModel.convert(bookDTO));
        }
        List<Long> bookIdList = new ArrayList<>(bookDTOList.size());
        for (Book book : bookList) {
            bookIdList.add(bookService.save(book).getId());
        }
        for (Long bookId : bookIdList) {
            bookFacade.setBook(authorId, bookId);
        }
        // возвращаем автора с его книгами
        return getAuthorBook(authorId);
    }

    @Override
    public AuthorDTO update(AuthorDTO authorDTO) {
        Author author = authorToModel.convert(authorDTO);
        Author newAuthor = authorService.update(author);
        return authorToDTO.convert(newAuthor);
    }

    @Override
    public boolean remove(Long id) {
        return authorService.remove(id);
    }
}

