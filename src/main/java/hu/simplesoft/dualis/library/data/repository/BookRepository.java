package hu.simplesoft.dualis.library.data.repository;

import java.util.List;

import hu.simplesoft.dualis.library.data.entity.BookEntity;
import hu.simplesoft.dualis.library.exception.NoElementException;
import hu.simplesoft.dualis.library.exception.PersistEcxeption;

public interface BookRepository {
    
    void createBook(BookEntity newBookEntity) throws PersistEcxeption;

    void updateBook(BookEntity bookEntityForUpdate) throws PersistEcxeption;

    void deleteBook(BookEntity bookEntityForDelete) throws PersistEcxeption;

    BookEntity getBookById(long bookId) throws PersistEcxeption;

    List<BookEntity> getAllBooks() throws NoElementException;

}
