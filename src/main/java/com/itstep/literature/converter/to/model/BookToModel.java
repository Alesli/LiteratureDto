package com.itstep.literature.converter.to.model;

import com.itstep.literature.converter.AbstractConverter;
import com.itstep.literature.dto.BookDTO;
import com.itstep.literature.model.Book;

public class BookToModel extends AbstractConverter<BookDTO, Book> {

    @Override
    public void convert(BookDTO source, Book target) {

        target.setId(source.getId());
        target.setName(source.getName());
        target.setGenre(source.getGenre());
        target.setDescription(source.getDescription());
    }
}
