package hu.simplesoft.dualis.library.data.dao;

import java.util.List;

import hu.simplesoft.dualis.library.service.dto.BorrowedBookDto;

public interface BorrowedBookDao {
    
    boolean createBorrowedBook(BorrowedBookDto borrowedBookDto);

    boolean updateBorrowedBook(BorrowedBookDto borrowedBookDto);

    boolean deleteBorrowedBook(long borrowedBookId);
    
    BorrowedBookDto getBorrowedBookById(long borrowedBookId);

    List<BorrowedBookDto> getAllBorrowedBooks();
}
