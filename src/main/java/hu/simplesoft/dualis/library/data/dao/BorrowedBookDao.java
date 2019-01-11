package hu.simplesoft.dualis.library.data.dao;

import java.util.List;

import hu.simplesoft.dualis.library.exception.NoElementException;
import hu.simplesoft.dualis.library.exception.PersistEcxeption;
import hu.simplesoft.dualis.library.service.dto.BorrowedBookDto;

public interface BorrowedBookDao {
    
    void createBorrowedBook(BorrowedBookDto borrowedBookDto) throws PersistEcxeption;

    void updateBorrowedBook(BorrowedBookDto borrowedBookDto) throws PersistEcxeption;

    void deleteBorrowedBook(long borrowedBookId) throws PersistEcxeption;
    
    BorrowedBookDto getBorrowedBookById(long borrowedBookId) throws PersistEcxeption ;

    List<BorrowedBookDto> getAllBorrowedBooks() throws NoElementException;
}
