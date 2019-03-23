package com.itstep.literature.converter.to.model;

import com.itstep.literature.converter.AbstractConverter;
import com.itstep.literature.dto.AuthorDTO;
import com.itstep.literature.model.Author;

public class AuthorToModel extends AbstractConverter<AuthorDTO, Author> {

    @Override
    public void convert(AuthorDTO source, Author target) {

        target.setId(source.getId());
        target.setName(source.getName());
        target.setLastName(source.getLastName());
    }
}
