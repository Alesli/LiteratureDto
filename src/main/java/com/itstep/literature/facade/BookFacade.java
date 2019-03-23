package com.itstep.literature.facade;

import com.itstep.literature.dto.BookAuthorDTO;
import com.itstep.literature.dto.BookDTO;
import com.itstep.literature.model.Book;

import java.util.List;

public interface BookFacade {

    /*
     * нигде не пользуемся BookDTO
     * так как автор может быть без книг (ну в душе он автор, а вот издатели так не считают)
     * а вот книга без автора не может существовать
     */

    BookAuthorDTO getBook(Long id);

    List<BookAuthorDTO> getBooksByName(String name);

    List<BookAuthorDTO> getBooksByGenre(String genre);

    List<BookAuthorDTO> getBooksByDescription(String partDescription);

    BookDTO saveBook(BookDTO bookDTO);

    void setBook(Long authorId, Long bookId);

    BookDTO update(BookDTO bookDTO);

    boolean remove(Long id);
}
