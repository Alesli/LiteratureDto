package com.itstep.literature.facade;

import com.itstep.literature.dto.AuthorBookDTO;
import com.itstep.literature.dto.AuthorDTO;

import java.util.List;

public interface AuthorFacade {

    AuthorDTO getAuthor(Long id);

    List<AuthorDTO> getAllAuthors();

    AuthorBookDTO getAuthorBook(Long id);

    List<AuthorBookDTO> getAllAuthorBook();

    AuthorDTO saveAuthor(AuthorDTO authorDTO);

    AuthorBookDTO addAuthorBook(AuthorBookDTO authorBookDTO);

    AuthorDTO update(AuthorDTO authorDTO);

    boolean remove(Long id);
}
