package hu.simplesoft.dualis.library.data.repository;

import java.util.List;

import hu.simplesoft.dualis.library.data.entity.BorrowedBookEntity;
import hu.simplesoft.dualis.library.exception.NoElementException;
import hu.simplesoft.dualis.library.exception.PersistEcxeption;

public interface BorrowedBookRepository {

    void createBorrowedBook(BorrowedBookEntity newBorrowedBookEntity) throws PersistEcxeption;

    void updateBorrowedBook(BorrowedBookEntity borrowedBookEntityForUpdate) throws PersistEcxeption;

    void deleteBorrowedBook(BorrowedBookEntity borrowedBookEntityForDelete) throws PersistEcxeption;

    BorrowedBookEntity getBorrowedBookById(long borrowedBookId) throws PersistEcxeption;

    List<BorrowedBookEntity> getAllBorrowedBooks() throws NoElementException;
}
