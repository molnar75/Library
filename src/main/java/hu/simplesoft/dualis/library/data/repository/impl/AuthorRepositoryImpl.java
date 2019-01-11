package hu.simplesoft.dualis.library.data.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import hu.simplesoft.dualis.library.data.entity.AuthorEntity;
import hu.simplesoft.dualis.library.data.repository.AuthorRepository;
import hu.simplesoft.dualis.library.exception.NoElementException;
import hu.simplesoft.dualis.library.exception.PersistEcxeption;

@Repository
public class AuthorRepositoryImpl implements AuthorRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void createAuthor(AuthorEntity newAuthorEntity) throws PersistEcxeption {
        try {
            this.entityManager.persist(newAuthorEntity);
        } catch (RuntimeException e) {
            throw new PersistEcxeption("Couldn't create the author", e);
        }
    }

    @Override
    public void updateAuthor(AuthorEntity authorEntityForUpdate, AuthorEntity newAuthorEntity) throws PersistEcxeption {
        try {
            authorEntityForUpdate.setBirthDate(newAuthorEntity.getBirthDate());
            authorEntityForUpdate.setName(newAuthorEntity.getName());

            this.entityManager.merge(authorEntityForUpdate);
        } catch (RuntimeException e) {
            throw new PersistEcxeption("Couldn't update the author!", e);
        }
    }

    @Override
    public void deleteAuthor(AuthorEntity authorEntityForDelete) throws PersistEcxeption {
        try {
            this.entityManager.remove(authorEntityForDelete);
        } catch (RuntimeException e) {
            throw new PersistEcxeption("Couldn't delete the author!", e);
        }
    }

    @Override
    public AuthorEntity getAuthorById(long authorId) throws PersistEcxeption {
        AuthorEntity foundEntity;
        
        try {
            foundEntity = this.entityManager.find(AuthorEntity.class, authorId);
        } catch (RuntimeException e) {
            throw new PersistEcxeption("Couldn't find the author!", e);
        }

        return foundEntity;
    }

    @Override
    public List<AuthorEntity> getAllAuthors() throws NoElementException {
        TypedQuery<AuthorEntity> queryForAllAuthors;
        List<AuthorEntity> allAuthorEntities;
        try {
            queryForAllAuthors = this.entityManager.createQuery("SELECT  h FROM authors h", AuthorEntity.class);
            allAuthorEntities = queryForAllAuthors.getResultList();
        } catch (RuntimeException e) {
            throw new NoElementException("Couldn't get all addresses!", e);
        }

        return allAuthorEntities;
    }

}
