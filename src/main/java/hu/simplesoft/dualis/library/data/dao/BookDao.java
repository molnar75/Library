package hu.simplesoft.dualis.library.data.dao;

import java.util.List;

import hu.simplesoft.dualis.library.exception.IsNullException;
import hu.simplesoft.dualis.library.exception.NoElementException;
import hu.simplesoft.dualis.library.exception.PersistEcxeption;
import hu.simplesoft.dualis.library.service.dto.BookDto;

public interface BookDao {
    
    void createBook(BookDto bookDto) throws PersistEcxeption;

    void updateBook(BookDto bookDto) throws PersistEcxeption, IsNullException;

    void deleteBook(long bookId) throws PersistEcxeption, IsNullException;
    
    BookDto getBookById(long bookId) throws PersistEcxeption;
    
    List<BookDto> getAllBooks() throws NoElementException;
}
