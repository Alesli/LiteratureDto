package com.itstep.literature;

import com.itstep.literature.dto.AuthorBookDTO;
import com.itstep.literature.dto.AuthorDTO;
import com.itstep.literature.dto.BookAuthorDTO;
import com.itstep.literature.dto.BookDTO;
import com.itstep.literature.facade.AuthorFacade;
import com.itstep.literature.facade.BookFacade;
import com.itstep.literature.facade.impl.AuthorFacadeImpl;
import com.itstep.literature.facade.impl.BookFacadeImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

//        // Выводит одного автора без книги
//        AuthorFacade authorFacade = new AuthorFacadeImpl();
//        AuthorDTO authorDTO = authorFacade.getAuthor(5L);
//        System.out.println(authorDTO);
//
//        //-----------------------------------------------------------------
//        //Выводит всех авторов без книг
//        AuthorFacade authorFacade = new AuthorFacadeImpl();
//        List<AuthorDTO> author = authorFacade.getAllAuthors();
//        for (AuthorDTO author1 : author) {
//            System.out.println(author1);
//        }
//
//        //-----------------------------------------------------------------
//        // Выводит одного автора по id с книгами
//        AuthorFacade authorFacade = new AuthorFacadeImpl();
//        AuthorBookDTO authorBookDTO = authorFacade.getAuthorBook(4L);
//        System.out.println(authorBookDTO);
//
//        //-----------------------------------------------------------------
//        // Выводит всех авторов с их книгами
        AuthorFacade authorFacade = new AuthorFacadeImpl();
        List<AuthorBookDTO> authorBookDTOS = authorFacade.getAllAuthorBook();
        for (AuthorBookDTO authorBookDTO : authorBookDTOS) {
            System.out.println(authorBookDTO);
        }
//        //------------------------------------------------------------------
//        // Выводит книгу с ее авторами по id книги
//        BookFacade bookFacade = new BookFacadeImpl();
//        BookAuthorDTO bookAuthorDTO = bookFacade.getBook(12L);
//        System.out.println(bookAuthorDTO);
//
//        //------------------------------------------------------------------
//        //Поиск книги по названию
//        BookFacade bookFacade = new BookFacadeImpl();
//        List<BookAuthorDTO> bookAuthorDTO = bookFacade.getBooksByName("Чистовик");
//        for (BookAuthorDTO baDTO : bookAuthorDTO) {
//
//            System.out.println("Поиск книги по названию \n" + baDTO);
//        }
//        // -----------------------------------------------------------------
//
//        BookFacade bookFacade = new BookFacadeImpl();
//
//        //  Поиск книги по жанру
//        List<BookAuthorDTO> bookAuthorDTO = bookFacade.getBooksByGenre("ф_нтези");
//        for (BookAuthorDTO baDTO : bookAuthorDTO) {
//            System.out.println("Поиск книги по жанру \n" + baDTO);
//        }
//
//        // Поиск книги по имени
//        List<BookAuthorDTO> bookAuthorDTOList = bookFacade.getBooksByName("еднее");
//        for (BookAuthorDTO item : bookAuthorDTOList) {
//            System.out.println("Поиск книги по имени \n" + item);
//        }
//
//        // Поиск книги по описанию
//        List<BookAuthorDTO> bookADTOList = bookFacade.getBooksByDescription("смерт_");
//        for (BookAuthorDTO item : bookADTOList) {
//            System.out.println("Поиск книги по описанию \n" + item);
//        }
//
//        //-----------------------------------------------------------------------------
//        // Сохранение автора
//        AuthorFacade authorFacade = new AuthorFacadeImpl();
//
//        AuthorDTO authorDTO = new AuthorDTO();
//        authorDTO.setName("name");
//        authorDTO.setLastName("lastname");
//        AuthorDTO result = authorFacade.saveAuthor(authorDTO);
//        System.out.println(result);
//
//        // -----------------------------------------------------------------
//        // Сохранение автора с книгами
//
//        AuthorFacade authorFacade = new AuthorFacadeImpl();
//
//        List<BookDTO> bookDTOList = new ArrayList<>();
//        Collections.addAll(bookDTOList,
//                new BookDTO(1L, "Стрелок", "фэнтези", "1 том цикла о Тёмной Башне"),
//                new BookDTO(2L, "Извлечение троих", "фэнтези", "2 том цикла о Тёмной Башне"),
//                new BookDTO(3L, "Бесплодные земли", "фэнтези", "3 том цикла о Тёмной Башне"),
//                new BookDTO(4L, "Колдун и кристалл", "фэнтези", "4 том цикла о Тёмной Башне")
//        );
//        AuthorBookDTO authorBookDTO1 = new AuthorBookDTO();
//        authorBookDTO1.setName("Стивен");
//        authorBookDTO1.setLastName("Кинг");
//        authorBookDTO1.setBookDTOList(bookDTOList);
//        AuthorBookDTO result = authorFacade.addAuthorBook(authorBookDTO1);
//        System.out.println(result);
//
//        //-------------------------
//        // Сохранение книги
//        BookFacade bookFacade = new BookFacadeImpl();
//
//        BookDTO bookDTO = new BookDTO();
//        bookDTO.setName("Стрелок");
//        bookDTO.setGenre("фэнтези");
//        bookDTO.setDescription("1 том цикла о Тёмной Башне");
//        BookDTO res = bookFacade.saveBook(bookDTO);
//        System.out.println(res);
//
//        //-------------------------
//        // Удаление автора
//
//        AuthorFacade authorFacade = new AuthorFacadeImpl();
//        boolean authorDTO = authorFacade.remove(11L);
//        System.out.println(authorDTO);
//
//        //-------------------------
//        // Удаление книги
//
//        BookFacade bookFacade = new BookFacadeImpl();
//        boolean bookDTO = bookFacade.remove(21L);
//        System.out.println(bookDTO);
//
//        //------------------------
//        //Обновление данных автора
//
//        AuthorFacade authorFacade = new AuthorFacadeImpl();
//
//        AuthorDTO aDTO = new AuthorDTO();
//        aDTO.setId(11L);
//        aDTO.setName("Стивен");
//        aDTO.setLastName("Кинг");
//        aDTO.setId(20L);
//        AuthorDTO authorDTO = authorFacade.update(aDTO);
//        System.out.println(authorDTO);
//
//        //------------------------
//        //Обновление данных книги
//
//        BookFacade bookFacade = new BookFacadeImpl();
//
//        BookDTO bDTO = new BookDTO();
//        bDTO.setId(18L);
//        bDTO.setName("Стивен");
//        bDTO.setGenre("Кинг");
//        bDTO.setDescription("Кинг");
//        bDTO.setId(43L);
//        BookDTO bookDTO = bookFacade.update(bDTO);
//        System.out.println(bookDTO);

    }
}
