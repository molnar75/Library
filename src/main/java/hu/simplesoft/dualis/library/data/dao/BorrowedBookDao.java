package hu.simplesoft.dualis.library.data.dao;

import java.util.List;

import hu.simplesoft.dualis.library.service.dto.BorrowedBookDto;

public interface BorrowedBookDao {
    boolean createBorrowedBook(BorrowedBookDto borrowedBookDto);

    boolean updateBorrowedBook(BorrowedBookDto borrowedBookDto);

    boolean deleteBorrowedBook(long borrowedBookId);

    List<BorrowedBookDto> getAllBorrowedBook();
}
