package hu.simplesoft.dualis.library.data.dao.impl;

import java.util.List;

import hu.simplesoft.dualis.library.data.dao.BookDao;
import hu.simplesoft.dualis.library.service.dto.BookDto;

public class BookDaoImpl implements BookDao {

    public boolean createBook(BookDto bookDto) {
        boolean isSuccess = false;
        try {
            //try to create

            isSuccess = true;
        } catch (RuntimeException e) {
            
        }
                
        return isSuccess;
    }

    public boolean updateBook(BookDto bookDto) {
        boolean isSuccess = false;
        try {
            //try to update

            isSuccess = true;
        } catch (RuntimeException e) {
            
        }
                
        return isSuccess;
    }

    public boolean deleteBook(long bookId) {
        boolean isSuccess = false;
        try {
            //try to delete

            isSuccess = true;
        } catch (RuntimeException e) {
            
        }
                
        return isSuccess;
    }

    public List<BookDto> getAllBooks() {
        // TODO Auto-generated method stub
        return null;
    }

    public boolean getBookById(long bookId) {
        boolean isSuccess = false;
        try {
            //try to get book by id

            isSuccess = true;
        } catch (RuntimeException e) {
            
        }
                
        return isSuccess;
    }

}
