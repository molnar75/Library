package hu.simplesoft.dualis.library.data.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import hu.simplesoft.dualis.library.data.entity.LibraryEntity;
import hu.simplesoft.dualis.library.data.repository.LibraryRepository;
import hu.simplesoft.dualis.library.exception.NoElementException;
import hu.simplesoft.dualis.library.exception.PersistEcxeption;

@Repository
public class LibraryRepositoryImpl implements LibraryRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void createLibrary(LibraryEntity newLibraryEntity) throws PersistEcxeption {
        try {
            this.entityManager.persist(newLibraryEntity);
        } catch (RuntimeException e) {
            throw new PersistEcxeption("Couldn't create the library", e);
        }
    }

    @Override
    public void updateLibrary(LibraryEntity libraryEntityForUpdate) throws PersistEcxeption {
        try {
            this.entityManager.merge(libraryEntityForUpdate);
        } catch (RuntimeException e) {
            throw new PersistEcxeption("Couldn't update the library!", e);
        }
    }

    @Override
    public void deleteLibrary(LibraryEntity libraryEntityForDelete) throws PersistEcxeption {
        try {
            this.entityManager.remove(libraryEntityForDelete);
        } catch (RuntimeException e) {
            throw new PersistEcxeption("Couldn't delete the library!", e);
        }
    }

    @Override
    public LibraryEntity getLibraryById(long libraryId) throws PersistEcxeption {
        LibraryEntity foundEntity;

        try {
            foundEntity = this.entityManager.find(LibraryEntity.class, libraryId);
        } catch (RuntimeException e) {
            throw new PersistEcxeption("Couldn't find the library!", e);
        }
        return foundEntity;
    }

    @Override
    public List<LibraryEntity> getAllLibraries() throws NoElementException {
        TypedQuery<LibraryEntity> queryForAllLibraries;
        List<LibraryEntity> allLibraryEntities;
        try {
            queryForAllLibraries = this.entityManager.createQuery("SELECT  h FROM libraries h", LibraryEntity.class);
            allLibraryEntities = queryForAllLibraries.getResultList();
        } catch (RuntimeException e) {
            throw new NoElementException("Couldn't get all libraries!", e);
        }

        return allLibraryEntities;
    }

}