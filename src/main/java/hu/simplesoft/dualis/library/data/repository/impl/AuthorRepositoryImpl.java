package hu.simplesoft.dualis.library.data.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import hu.simplesoft.dualis.library.data.entity.AuthorEntity;
import hu.simplesoft.dualis.library.data.repository.AuthorRepository;
import hu.simplesoft.dualis.library.exception.NoElementException;
import hu.simplesoft.dualis.library.exception.PersistException;

@Repository
public class AuthorRepositoryImpl implements AuthorRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void createAuthor(AuthorEntity newAuthorEntity) throws PersistException {
        try {
            this.entityManager.persist(newAuthorEntity);
        } catch (RuntimeException e) {
            throw new PersistException("Couldn't create the author", e);
        }
    }

    @Override
    public void updateAuthor(AuthorEntity authorEntityForUpdate) throws PersistException {
        try {
            this.entityManager.merge(authorEntityForUpdate);
        } catch (RuntimeException e) {
            throw new PersistException("Couldn't update the author!", e);
        }
    }

    @Override
    public void deleteAuthor(AuthorEntity authorEntityForDelete) throws PersistException {
        try {
            this.entityManager.remove(authorEntityForDelete);
        } catch (RuntimeException e) {
            throw new PersistException("Couldn't delete the author!", e);
        }
    }

    @Override
    public AuthorEntity getAuthorById(long authorId) throws PersistException {
        AuthorEntity foundEntity;
        
        try {
            foundEntity = this.entityManager.find(AuthorEntity.class, authorId);
        } catch (RuntimeException e) {
            throw new PersistException("Couldn't find the author!", e);
        }

        return foundEntity;
    }

    @Override
    public List<AuthorEntity> getAllAuthors() throws NoElementException {
        TypedQuery<AuthorEntity> queryForAllAuthors;
        List<AuthorEntity> allAuthorEntities;
        try {
            queryForAllAuthors = this.entityManager.createQuery("SELECT  a FROM Authors a", AuthorEntity.class);
            allAuthorEntities = queryForAllAuthors.getResultList();
        } catch (RuntimeException e) {
            throw new NoElementException("Couldn't get all addresses!", e);
        }

        return allAuthorEntities;
    }

}
