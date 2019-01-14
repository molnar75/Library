package hu.simplesoft.dualis.library.data.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.simplesoft.dualis.library.data.dao.BookDao;
import hu.simplesoft.dualis.library.data.entity.BookEntity;
import hu.simplesoft.dualis.library.data.mapper.BookMapper;
import hu.simplesoft.dualis.library.data.repository.BookRepository;
import hu.simplesoft.dualis.library.data.validator.ObjectValidator;
import hu.simplesoft.dualis.library.exception.PersistException;
import hu.simplesoft.dualis.library.service.dto.BookDto;

@Service
public class BookDaoImpl implements BookDao {
    
    @Autowired
    private BookRepository bookRepository;

    @Transactional
    @Override
    public void createBook(BookDto bookDto) throws PersistException {
        BookEntity newBookEntity = BookMapper.BookDtoToEntity(bookDto);
        this.bookRepository.createBook(newBookEntity);
    }

    @Transactional
    @Override
    public void updateBook(BookDto bookDto) throws PersistException {
        BookEntity bookEntityForUpdate = this.bookRepository.getBookById(bookDto.getId());
        ObjectValidator.entityIsNull(bookEntityForUpdate, bookDto.getId());
        BookEntity newBookEntity = BookMapper.BookDtoToEntity(bookDto);
           
        bookEntityForUpdate = updateNewEntity(bookEntityForUpdate, newBookEntity);
            
        this.bookRepository.updateBook(bookEntityForUpdate);
    }

    @Transactional
    @Override
    public void deleteBook(long bookId) throws PersistException {
        BookEntity bookEntityForDelete = this.bookRepository.getBookById(bookId);
        ObjectValidator.entityIsNull(bookEntityForDelete, bookId);
        this.bookRepository.deleteBook(bookEntityForDelete);
    }

    @Override
    public List<BookDto> getAllBooks() throws PersistException {
        List<BookEntity> allBookEntities = this.bookRepository.getAllBooks();
        List<BookDto> allBooksDto = BookMapper.getAllBooksToDto(allBookEntities);

        return allBooksDto;
    }

    @Override
    public BookDto getBookById(long bookId) throws PersistException {
        BookEntity foundEntity = this.bookRepository.getBookById(bookId);

        return BookMapper.BookEntityToDto(foundEntity);
    }

    private BookEntity updateNewEntity(BookEntity bookEntityForUpdate,BookEntity newBookEntity) {
        bookEntityForUpdate.setAuthor(newBookEntity.getAuthor());
        bookEntityForUpdate.setLibrary(newBookEntity.getLibrary());
        bookEntityForUpdate.setPublishDate(newBookEntity.getPublishDate());
        bookEntityForUpdate.setTitle(newBookEntity.getTitle());
        
        return bookEntityForUpdate;
    }
}
