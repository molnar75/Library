package hu.simplesoft.dualis.library.data.repository;

import java.util.List;

import hu.simplesoft.dualis.library.data.entity.BookEntity;
import hu.simplesoft.dualis.library.exception.NoElementException;
import hu.simplesoft.dualis.library.exception.PersistException;

public interface BookRepository {
    
    void createBook(BookEntity newBookEntity) throws PersistException;

    void updateBook(BookEntity bookEntityForUpdate) throws PersistException;

    void deleteBook(BookEntity bookEntityForDelete) throws PersistException;

    BookEntity getBookById(long bookId) throws PersistException;

    List<BookEntity> getAllBooks() throws NoElementException;

}
