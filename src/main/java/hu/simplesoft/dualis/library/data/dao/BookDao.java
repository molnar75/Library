package hu.simplesoft.dualis.library.data.dao;

import java.util.List;

import hu.simplesoft.dualis.library.service.dto.BookDto;

public interface BookDao {
    
    boolean createBook(BookDto bookDto);

    boolean updateBook(BookDto bookDto);

    boolean deleteBook(long bookId);
    
    boolean getBookById(long bookId);
    
    List<BookDto> getAllBooks();
}
