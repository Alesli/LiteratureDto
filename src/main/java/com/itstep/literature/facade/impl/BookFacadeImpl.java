package com.itstep.literature.facade.impl;

import com.itstep.literature.converter.Converter;
import com.itstep.literature.converter.to.dto.*;
import com.itstep.literature.converter.to.model.AuthorToModel;
import com.itstep.literature.converter.to.model.BookToModel;
import com.itstep.literature.dto.AuthorBookDTO;
import com.itstep.literature.dto.AuthorDTO;
import com.itstep.literature.dto.BookAuthorDTO;
import com.itstep.literature.dto.BookDTO;
import com.itstep.literature.facade.BookFacade;
import com.itstep.literature.model.Author;
import com.itstep.literature.model.Book;
import com.itstep.literature.service.AuthorService;
import com.itstep.literature.service.BookService;
import com.itstep.literature.service.impl.AuthorServiceImpl;
import com.itstep.literature.service.impl.BookServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class BookFacadeImpl implements BookFacade {

    private BookService bookService = new BookServiceImpl();
    private Converter<Book, BookDTO> bookToDTO = new BookToDTO();
    private Converter<BookDTO, Book> bookToModel = new BookToModel();
    private Converter<Book, BookAuthorDTO> bookAuthorToDTO = new BookAuthorToDTO();

    @Override
    public BookAuthorDTO getBook(Long id) {

        Book book = bookService.getOne(id);
        BookAuthorDTO bookAuthorDTO = new BookAndAuthorsToDTO().getBookAuthorDTO(book);

//        BookAuthorDTO bookAuthorDTO = bookAuthorToDTO.convert(book);

        return bookAuthorDTO;
    }

    @Override
    public List<BookAuthorDTO> getBooksByName(String name) {
        List<Book> books = bookService.getOneByName(name);
        if (books == null) {
            return new ArrayList<>();
        } else {

            List<BookAuthorDTO> bookAuthorDTO = new ArrayList<>(books.size());
            for (Book b : books) {
                bookAuthorDTO.add(bookAuthorToDTO.convert(b));
            }
            return bookAuthorDTO;
        }
    }

    @Override
    public List<BookAuthorDTO> getBooksByGenre(String genre) {
        List<Book> books = bookService.getOneByGenre(genre);
        List<BookAuthorDTO> bookAuthorDTO = new ArrayList<>(books.size());
        for (Book b : books) {
            bookAuthorDTO.add(bookAuthorToDTO.convert(b));
        }
        return bookAuthorDTO;
    }

    @Override
    public List<BookAuthorDTO> getBooksByDescription(String partDescription) {
        List<Book> books = bookService.getOneByDescription(partDescription);
        List<BookAuthorDTO> bookADTO = new ArrayList<>(books.size());
        for (Book b : books) {
            bookADTO.add(bookAuthorToDTO.convert(b));
        }
        return bookADTO;

    }

    @Override
    public BookDTO saveBook(BookDTO bookDTO) {
        Book book = bookToModel.convert(bookDTO);
        Book newBook = bookService.save(book);
        return bookToDTO.convert(newBook);
    }

    @Override
    public void setBook(Long authorId, Long bookId) {
        bookService.setBook(authorId, bookId);
    }

    @Override
    public BookDTO update(BookDTO bookDTO) {
        Book book = bookToModel.convert(bookDTO);
        Book newBook = bookService.update(book);
        return bookToDTO.convert(newBook);
    }

    @Override
    public boolean remove(Long id) {
        return bookService.remove(id);
    }
}
