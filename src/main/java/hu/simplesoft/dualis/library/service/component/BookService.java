package hu.simplesoft.dualis.library.service.component;

import java.util.List;

import hu.simplesoft.dualis.library.service.dto.BookDto;
import hu.simplesoft.dualis.library.service.exception.ServiceException;

public interface BookService {

    void createBook(BookDto bookDto) throws ServiceException;

    void updateBook(BookDto bookDto) throws ServiceException;

    void deleteBook(long bookId) throws ServiceException;
    
    BookDto getBookById(long bookId) throws ServiceException;
    
    List<BookDto> getAllBooks() throws ServiceException;
}
