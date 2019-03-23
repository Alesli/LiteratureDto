package com.itstep.literature.converter.to.model;

import com.itstep.literature.converter.AbstractConverter;
import com.itstep.literature.dto.AuthorBookDTO;
import com.itstep.literature.model.Author;

public class AuthorBookToModel extends AbstractConverter<AuthorBookDTO, Author> {

    @Override
    public void convert(AuthorBookDTO source, Author target) {

        target.setId(source.getId());
        target.setName(source.getName());
        target.setLastName(source.getLastName());
    }
}