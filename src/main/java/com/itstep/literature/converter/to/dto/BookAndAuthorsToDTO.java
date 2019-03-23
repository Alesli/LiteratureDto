package com.itstep.literature.converter.to.dto;

import com.itstep.literature.dao.AuthorDAO;
import com.itstep.literature.dao.impl.AuthorDAOImpl;
import com.itstep.literature.dto.AuthorDTO;
import com.itstep.literature.dto.BookAuthorDTO;
import com.itstep.literature.model.Author;
import com.itstep.literature.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookAndAuthorsToDTO {

    private AuthorDAO authorDAO = new AuthorDAOImpl();

    public BookAuthorDTO getBookAuthorDTO(Book book) {

        BookAuthorDTO bookAuthorDTO = new BookAuthorDTO();
        bookAuthorDTO.setId(book.getId());
        bookAuthorDTO.setName(book.getName());
        bookAuthorDTO.setGenre(book.getGenre());
        bookAuthorDTO.setDescription(book.getDescription());

        List<Author> authorList = authorDAO.findAllByBookId(book.getId());
        List<AuthorDTO> authorDTOList = new ArrayList<>(authorList.size());
        for (Author author : authorList) {

            AuthorDTO authorDTO = new AuthorDTO();
            authorDTO.setId(author.getId());
            authorDTO.setName(author.getName());
            authorDTO.setLastName(author.getLastName());

            authorDTOList.add(authorDTO);
        }

        bookAuthorDTO.setAuthorDTOList(authorDTOList);

        return bookAuthorDTO;
    }
}
