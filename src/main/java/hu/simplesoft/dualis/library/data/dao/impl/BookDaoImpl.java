package hu.simplesoft.dualis.library.data.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import hu.simplesoft.dualis.library.data.dao.BookDao;
import hu.simplesoft.dualis.library.data.entity.BookEntity;
import hu.simplesoft.dualis.library.data.mapper.BookMapper;
import hu.simplesoft.dualis.library.data.repository.BookRepository;
import hu.simplesoft.dualis.library.exception.NoElementException;
import hu.simplesoft.dualis.library.exception.PersistEcxeption;
import hu.simplesoft.dualis.library.service.dto.BookDto;

@Transactional
public class BookDaoImpl implements BookDao {
    
    private BookRepository bookRepository;

    @Override
    public void createBook(BookDto bookDto) throws PersistEcxeption {
        BookEntity newBookEntity = BookMapper.BookDtoToEntity(bookDto);
        this.bookRepository.createBook(newBookEntity);
    }

    @Override
    public void updateBook(BookDto bookDto) throws PersistEcxeption {
        BookEntity bookEntityForUpdate = this.bookRepository.getBookById(bookDto.getId());
        BookEntity newBookEntity = BookMapper.BookDtoToEntity(bookDto);

        if (bookEntityForUpdate != null) {
            bookEntityForUpdate.setAuthor(newBookEntity.getAuthor());
            bookEntityForUpdate.setLibrary(newBookEntity.getLibrary());
            bookEntityForUpdate.setPublishDate(newBookEntity.getPublishDate());
            bookEntityForUpdate.setTitle(newBookEntity.getTitle());
            
            this.bookRepository.updateBook(bookEntityForUpdate);
        }
    }

    @Override
    public void deleteBook(long bookId) throws PersistEcxeption {
        BookEntity bookEntityForDelete = this.bookRepository.getBookById(bookId);
        this.bookRepository.deleteBook(bookEntityForDelete);

    }

    @Override
    public List<BookDto> getAllBooks() throws NoElementException {
        List<BookEntity> allBookEntities = this.bookRepository.getAllBooks();
        List<BookDto> allBooksDto = BookMapper.getAllBooksToDto(allBookEntities);

        return allBooksDto;
    }

    @Override
    public BookDto getBookById(long bookId) throws PersistEcxeption {
        BookEntity foundEntity = this.bookRepository.getBookById(bookId);

        return BookMapper.BookEntityToDto(foundEntity);
    }

}
