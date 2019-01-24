package hu.simplesoft.dualis.library.data.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import hu.simplesoft.dualis.library.data.entity.BorrowedBookEntity;
import hu.simplesoft.dualis.library.data.repository.BorrowedBookRepository;
import hu.simplesoft.dualis.library.exception.NoElementException;
import hu.simplesoft.dualis.library.exception.PersistException;

@Repository
public class BorrowedBookRepositoryImpl implements BorrowedBookRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void createBorrowedBook(BorrowedBookEntity newBorrowedBookEntity) throws PersistException {
        try {
            this.entityManager.persist(newBorrowedBookEntity);
        } catch (RuntimeException e) {
            throw new PersistException("Couldn't create the borrowed book", e);
        }
    }

    @Override
    public void updateBorrowedBook(BorrowedBookEntity borrowedBookEntityForUpdate) throws PersistException {
        try {
            this.entityManager.merge(borrowedBookEntityForUpdate);
        } catch (RuntimeException e) {
            throw new PersistException("Couldn't update the borrowed book!", e);
        }
    }

    @Override
    public void deleteBorrowedBook(BorrowedBookEntity borrowedBookEntityForDelete) throws PersistException {
        try {
            this.entityManager.remove(borrowedBookEntityForDelete);
        } catch (RuntimeException e) {
            throw new PersistException("Couldn't delete the borrowed book!", e);
        }
    }

    @Override
    public BorrowedBookEntity getBorrowedBookById(long borrowedBookId) throws PersistException {
        BorrowedBookEntity foundEntity;

        try {
            foundEntity = this.entityManager.find(BorrowedBookEntity.class, borrowedBookId);
        } catch (RuntimeException e) {
            throw new PersistException("Couldn't find the borrowed book!", e);
        }

        return foundEntity;
    }

    @Override
    public List<BorrowedBookEntity> getAllBorrowedBooks() throws NoElementException {
        TypedQuery<BorrowedBookEntity> queryForAllBorrowedBooks;
        List<BorrowedBookEntity> allBorrowedBookEntities;
        try {
            queryForAllBorrowedBooks = this.entityManager.createQuery("SELECT  a FROM BorrowedBooks a", BorrowedBookEntity.class);
            allBorrowedBookEntities = queryForAllBorrowedBooks.getResultList();
        } catch (RuntimeException e) {
            throw new NoElementException("Couldn't get all borrowed books!", e);
        }

        return allBorrowedBookEntities;
    }
}
