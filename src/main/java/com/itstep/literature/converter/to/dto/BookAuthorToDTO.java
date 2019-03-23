package com.itstep.literature.converter.to.dto;

import com.itstep.literature.converter.AbstractConverter;
import com.itstep.literature.converter.Converter;
import com.itstep.literature.dto.AuthorDTO;
import com.itstep.literature.dto.BookAuthorDTO;
import com.itstep.literature.model.Author;
import com.itstep.literature.model.Book;
import com.itstep.literature.service.AuthorService;
import com.itstep.literature.service.impl.AuthorServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class BookAuthorToDTO extends AbstractConverter<Book, BookAuthorDTO> {

    private AuthorService authorService = new AuthorServiceImpl();

    private Converter<Author, AuthorDTO> authorToDTO = new AuthorToDTO();

    @Override
    public void convert(Book source, BookAuthorDTO target) {

        target.setId(source.getId());
        target.setName(source.getName());
        target.setGenre(source.getGenre());
        target.setDescription(source.getDescription());

        List<Author> authorList = authorService.findAllByBookId(source.getId());
        List<AuthorDTO> authorDTOList = new ArrayList<>(authorList.size());
        for (Author a : authorList) {
            authorDTOList.add(authorToDTO.convert(a));
        }
        target.setAuthorDTOList(authorDTOList);

    }
}
