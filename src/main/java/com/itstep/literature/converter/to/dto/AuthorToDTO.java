package com.itstep.literature.converter.to.dto;

import com.itstep.literature.converter.AbstractConverter;
import com.itstep.literature.dto.AuthorDTO;
import com.itstep.literature.model.Author;

public class AuthorToDTO extends AbstractConverter<Author, AuthorDTO> {

    @Override
    public void convert(Author source, AuthorDTO target) {

        target.setId(source.getId());
        target.setName(source.getName());
        target.setLastName(source.getLastName());
    }
}
