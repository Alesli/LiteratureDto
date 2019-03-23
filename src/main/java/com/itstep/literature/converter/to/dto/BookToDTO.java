package com.itstep.literature.converter.to.dto;

import com.itstep.literature.converter.AbstractConverter;
import com.itstep.literature.dto.BookDTO;
import com.itstep.literature.model.Book;

public class BookToDTO extends AbstractConverter<Book, BookDTO> {

    @Override
    public void convert(Book source, BookDTO target) {

        target.setId(source.getId());
        target.setName(source.getName());
        target.setGenre(source.getGenre());
        target.setDescription(source.getDescription());
    }
}
