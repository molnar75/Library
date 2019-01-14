package hu.simplesoft.dualis.library.data.dao;

import java.util.List;

import hu.simplesoft.dualis.library.exception.PersistEcxeption;
import hu.simplesoft.dualis.library.service.dto.BookDto;

public interface BookDao {
    
    void createBook(BookDto bookDto) throws PersistEcxeption;

    void updateBook(BookDto bookDto) throws PersistEcxeption;

    void deleteBook(long bookId) throws PersistEcxeption;
    
    BookDto getBookById(long bookId) throws PersistEcxeption;
    
    List<BookDto> getAllBooks() throws PersistEcxeption;
}
