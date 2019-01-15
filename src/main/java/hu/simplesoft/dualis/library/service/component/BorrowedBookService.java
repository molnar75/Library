package hu.simplesoft.dualis.library.service.component;

import java.util.List;

import hu.simplesoft.dualis.library.service.dto.BorrowedBookDto;
import hu.simplesoft.dualis.library.service.exception.ServiceException;

public interface BorrowedBookService {

    void createBorrowedBook(BorrowedBookDto borrowedBookDto) throws ServiceException;

    void updateBorrowedBook(BorrowedBookDto borrowedBookDto) throws ServiceException;

    void deleteBorrowedBook(long borrowedBookId) throws ServiceException;
    
    BorrowedBookDto getBorrowedBookById(long borrowedBookId) throws ServiceException ;

    List<BorrowedBookDto> getAllBorrowedBooks() throws ServiceException;
}
