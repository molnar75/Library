package hu.simplesoft.dualis.library.data.dao.impl;

import java.util.List;

import hu.simplesoft.dualis.library.data.dao.BorrowedBookDao;
import hu.simplesoft.dualis.library.service.dto.BorrowedBookDto;

public class BorrowedBookDaoImpl implements BorrowedBookDao {

    public boolean createBorrowedBook(BorrowedBookDto borrowedBookDto) {
        boolean isSuccess = false;
        try {
            //try to create

            isSuccess = true;
        } catch (RuntimeException e) {
            
        }
                
        return isSuccess;
    }

    public boolean updateBorrowedBook(BorrowedBookDto borrowedBookDto) {
        boolean isSuccess = false;
        try {
            //try to update

            isSuccess = true;
        } catch (RuntimeException e) {
            
        }
                
        return isSuccess;
    }

    public boolean deleteBorrowedBook(long borrowedBookId) {
        boolean isSuccess = false;
        try {
            //try to delete

            isSuccess = true;
        } catch (RuntimeException e) {
            
        }
                
        return isSuccess;
    }

    public List<BorrowedBookDto> getAllBorrowedBooks() {
        // TODO Auto-generated method stub
        return null;
    }

    public boolean getBorrowedBookById(long borrowedBookId) {
        boolean isSuccess = false;
        try {
            //try to get borrowed book by id

            isSuccess = true;
        } catch (RuntimeException e) {
            
        }
                
        return isSuccess;
    }

}
