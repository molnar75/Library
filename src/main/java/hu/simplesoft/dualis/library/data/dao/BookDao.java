package hu.simplesoft.dualis.library.data.dao;

import java.util.List;

import hu.simplesoft.dualis.library.exception.PersistException;
import hu.simplesoft.dualis.library.service.dto.BookDto;

public interface BookDao {
    
    void createBook(BookDto bookDto) throws PersistException;

    void updateBook(BookDto bookDto) throws PersistException;

    void deleteBook(long bookId) throws PersistException;
    
    BookDto getBookById(long bookId) throws PersistException;
    
    List<BookDto> getAllBooks() throws PersistException;
}
