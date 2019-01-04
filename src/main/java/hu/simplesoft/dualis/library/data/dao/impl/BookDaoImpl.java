package hu.simplesoft.dualis.library.data.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import hu.simplesoft.dualis.library.data.dao.BookDao;
import hu.simplesoft.dualis.library.data.entity.BookEntity;
import hu.simplesoft.dualis.library.data.mapper.BookMapper;
import hu.simplesoft.dualis.library.service.dto.BookDto;

@Repository
@Transactional
public class BookDaoImpl implements BookDao {
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean createBook(BookDto bookDto) {
        boolean isSuccess = false;
        BookEntity newBookEntity = BookMapper.BookDtoToEntity(bookDto);
       
        try {
            this.entityManager.persist(newBookEntity);

            isSuccess = true;
        } catch (RuntimeException e) {
            //LOG
        }
                
        return isSuccess;
    }

    @Override
    public boolean updateBook(BookDto bookDto) {
        boolean isSuccess = false;
        BookEntity bookEntityForUpdate = this.entityManager.find(BookEntity.class, bookDto.getId());
        BookEntity newBookEntity = BookMapper.BookDtoToEntity(bookDto);

        if (bookEntityForUpdate != null) {
            try {
                bookEntityForUpdate.setAuthor(newBookEntity.getAuthor());
                bookEntityForUpdate.setLibrary(newBookEntity.getLibrary());
                bookEntityForUpdate.setPublishDate(newBookEntity.getPublishDate());
                bookEntityForUpdate.setTitle(newBookEntity.getTitle());
    
                isSuccess = true;
            } catch (RuntimeException e) {
                //LOG
            }
        }
                
        return isSuccess;
    }

    @Override
    public boolean deleteBook(long bookId) {
        boolean isSuccess = false;
        BookEntity bookEntityForDelete = this.entityManager.find(BookEntity.class, bookId);
        
        try {
            this.entityManager.remove(bookEntityForDelete);

            isSuccess = true;
        } catch (RuntimeException e) {
            //LOG
        }
                
        return isSuccess;
    }

    @Override
    public List<BookDto> getAllBooks() {
        TypedQuery<BookEntity> queryForAllBooks = this.entityManager.createQuery("SELECT  h FROM books h", BookEntity.class);
        List<BookEntity> allBookEntities = queryForAllBooks.getResultList();
        List<BookDto> allBooksDto = BookMapper.getAllBooksToDto(allBookEntities);

        return allBooksDto;
    }

    @Override
    public BookDto getBookById(long bookId) {
        BookEntity foundEntity = this.entityManager.find(BookEntity.class, bookId);

        return BookMapper.BookEntityToDto(foundEntity);
    }

}
