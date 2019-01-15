package hu.simplesoft.dualis.library.service.component.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.simplesoft.dualis.library.data.dao.BookDao;
import hu.simplesoft.dualis.library.exception.PersistException;
import hu.simplesoft.dualis.library.service.component.BookService;
import hu.simplesoft.dualis.library.service.dto.BookDto;
import hu.simplesoft.dualis.library.service.exception.ServiceException;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;
    
    @Override
    public void createBook(BookDto bookDto) throws ServiceException {
        try {
            this.bookDao.createBook(bookDto);
        } catch (PersistException e) {
            throw new ServiceException(e);
        } 
    }

    @Override
    public void updateBook(BookDto bookDto) throws ServiceException {
        try {
            this.bookDao.updateBook(bookDto);
        } catch (PersistException e) {
            throw new ServiceException(e);
        }   
    }

    @Override
    public void deleteBook(long bookId) throws ServiceException {
        try {
            this.bookDao.deleteBook(bookId);
        } catch (PersistException e) {
            throw new ServiceException(e);
        } 
    }

    @Override
    public BookDto getBookById(long bookId) throws ServiceException {
        BookDto foundBookDto;
        try {
            foundBookDto = this.bookDao.getBookById(bookId);
        } catch (PersistException e) {
            throw new ServiceException(e);
        } 
        return foundBookDto;
    }

    @Override
    public List<BookDto> getAllBooks() throws ServiceException {
        List<BookDto> allBooksDto;
        try {
            allBooksDto = this.bookDao.getAllBooks();
        } catch (PersistException e) {
            throw new ServiceException(e);
        } 
        return allBooksDto;
    }
}
