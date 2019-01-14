package hu.simplesoft.dualis.library.data.repository;

import java.util.List;

import hu.simplesoft.dualis.library.data.entity.BorrowedBookEntity;
import hu.simplesoft.dualis.library.exception.NoElementException;
import hu.simplesoft.dualis.library.exception.PersistException;

public interface BorrowedBookRepository {

    void createBorrowedBook(BorrowedBookEntity newBorrowedBookEntity) throws PersistException;

    void updateBorrowedBook(BorrowedBookEntity borrowedBookEntityForUpdate) throws PersistException;

    void deleteBorrowedBook(BorrowedBookEntity borrowedBookEntityForDelete) throws PersistException;

    BorrowedBookEntity getBorrowedBookById(long borrowedBookId) throws PersistException;

    List<BorrowedBookEntity> getAllBorrowedBooks() throws NoElementException;
}
