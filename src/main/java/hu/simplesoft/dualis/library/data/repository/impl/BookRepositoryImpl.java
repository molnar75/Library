package hu.simplesoft.dualis.library.data.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import hu.simplesoft.dualis.library.data.entity.BookEntity;
import hu.simplesoft.dualis.library.data.repository.BookRepository;
import hu.simplesoft.dualis.library.exception.NoElementException;
import hu.simplesoft.dualis.library.exception.PersistEcxeption;

@Repository
public class BookRepositoryImpl implements BookRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void createBook(BookEntity newBookEntity) throws PersistEcxeption {
        try {
            this.entityManager.persist(newBookEntity);
        } catch (RuntimeException e) {
            throw new PersistEcxeption("Couldn't create the book", e);
        }
    }

    @Override
    public void updateBook(BookEntity bookEntityForUpdate, BookEntity newBookEntity) throws PersistEcxeption {
        try {
            bookEntityForUpdate.setAuthor(newBookEntity.getAuthor());
            bookEntityForUpdate.setLibrary(newBookEntity.getLibrary());
            bookEntityForUpdate.setPublishDate(newBookEntity.getPublishDate());
            bookEntityForUpdate.setTitle(newBookEntity.getTitle());

            this.entityManager.merge(bookEntityForUpdate);
        } catch (RuntimeException e) {
            throw new PersistEcxeption("Couldn't update the book!", e);
        }
    }

    @Override
    public void deleteBook(BookEntity bookEntityForDelete) throws PersistEcxeption {
        try {
            this.entityManager.remove(bookEntityForDelete);
        } catch (RuntimeException e) {
            throw new PersistEcxeption("Couldn't delete the book!", e);
        }
    }

    @Override
    public BookEntity getBookById(long bookId) throws PersistEcxeption {
        BookEntity foundEntity;

        try {
            foundEntity = this.entityManager.find(BookEntity.class, bookId);
        } catch (RuntimeException e) {
            throw new PersistEcxeption("Couldn't find the book!", e);
        }

        return foundEntity;
    }

    @Override
    public List<BookEntity> getAllBooks() throws NoElementException {
        TypedQuery<BookEntity> queryForAllBooks;
        List<BookEntity> allBookEntities;
        try {
            queryForAllBooks = this.entityManager.createQuery("SELECT  h FROM books h", BookEntity.class);
            allBookEntities = queryForAllBooks.getResultList();
        } catch (RuntimeException e) {
            throw new NoElementException("Couldn't get all books!", e);
        }

        return allBookEntities;
    }
}
