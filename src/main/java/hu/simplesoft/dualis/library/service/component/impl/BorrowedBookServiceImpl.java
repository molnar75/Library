package hu.simplesoft.dualis.library.service.component.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.simplesoft.dualis.library.data.dao.BorrowedBookDao;
import hu.simplesoft.dualis.library.exception.PersistException;
import hu.simplesoft.dualis.library.service.component.BorrowedBookService;
import hu.simplesoft.dualis.library.service.dto.BorrowedBookDto;
import hu.simplesoft.dualis.library.service.exception.ServiceException;

@Service
public class BorrowedBookServiceImpl implements BorrowedBookService {

    @Autowired
    private BorrowedBookDao borrowedBookDao;
    
    @Override
    public void createBorrowedBook(BorrowedBookDto borrowedBookDto) throws ServiceException {
        try {
            this.borrowedBookDao.createBorrowedBook(borrowedBookDto);
        } catch (PersistException e) {
            throw new ServiceException(e);
        }     
    }

    @Override
    public void updateBorrowedBook(BorrowedBookDto borrowedBookDto) throws ServiceException {
        try {
            this.borrowedBookDao.updateBorrowedBook(borrowedBookDto);
        } catch (PersistException e) {
            throw new ServiceException(e);
        }  
    }

    @Override
    public void deleteBorrowedBook(long borrowedBookId) throws ServiceException {
        try {
            this.borrowedBookDao.deleteBorrowedBook(borrowedBookId);
        } catch (PersistException e) {
            throw new ServiceException(e);
        } 
    }

    @Override
    public BorrowedBookDto getBorrowedBookById(long borrowedBookId) throws ServiceException {
        BorrowedBookDto foundBorrowedBookDto;
        try {
            foundBorrowedBookDto = this.borrowedBookDao.getBorrowedBookById(borrowedBookId);
        } catch (PersistException e) {
            throw new ServiceException(e);
        } 
        return foundBorrowedBookDto;
    }

    @Override
    public List<BorrowedBookDto> getAllBorrowedBooks() throws ServiceException {
        List<BorrowedBookDto> allBorrowedBooksDto;
        try {
            allBorrowedBooksDto = this.borrowedBookDao.getAllBorrowedBooks();
        } catch (PersistException e) {
            throw new ServiceException(e);
        } 
        return allBorrowedBooksDto;
    }
}
