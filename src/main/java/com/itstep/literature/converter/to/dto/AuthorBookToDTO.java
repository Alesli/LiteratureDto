package com.itstep.literature.converter.to.dto;

import com.itstep.literature.converter.AbstractConverter;
import com.itstep.literature.converter.Converter;
import com.itstep.literature.dto.AuthorBookDTO;
import com.itstep.literature.dto.BookDTO;
import com.itstep.literature.model.Author;
import com.itstep.literature.model.Book;
import com.itstep.literature.service.BookService;
import com.itstep.literature.service.impl.BookServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class AuthorBookToDTO extends AbstractConverter<Author, AuthorBookDTO> {

    private BookService bookService = new BookServiceImpl();

    private Converter<Book, BookDTO> bookToDTO = new BookToDTO();

    @Override
    public void convert(Author source, AuthorBookDTO target) {

        target.setId(source.getId());
        target.setName(source.getName());
        target.setLastName(source.getLastName());

        List<Book> bookList = bookService.findAllByAuthorId(source.getId());
        List<BookDTO> bookDTOList = new ArrayList<>(bookList.size());
        for (Book b : bookList) {
            bookDTOList.add(bookToDTO.convert(b));
        }
        target.setBookDTOList(bookDTOList);
    }
}
