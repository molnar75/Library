package hu.simplesoft.dualis.library.data.dao;

import java.util.List;

import hu.simplesoft.dualis.library.exception.PersistException;
import hu.simplesoft.dualis.library.service.dto.BorrowedBookDto;

public interface BorrowedBookDao {
    
    void createBorrowedBook(BorrowedBookDto borrowedBookDto) throws PersistException;

    void updateBorrowedBook(BorrowedBookDto borrowedBookDto) throws PersistException;

    void deleteBorrowedBook(long borrowedBookId) throws PersistException;
    
    BorrowedBookDto getBorrowedBookById(long borrowedBookId) throws PersistException ;

    List<BorrowedBookDto> getAllBorrowedBooks() throws PersistException;
}
