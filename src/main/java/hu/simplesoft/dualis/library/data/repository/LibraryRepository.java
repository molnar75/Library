package hu.simplesoft.dualis.library.data.repository;

import java.util.List;

import hu.simplesoft.dualis.library.data.entity.LibraryEntity;
import hu.simplesoft.dualis.library.exception.NoElementException;
import hu.simplesoft.dualis.library.exception.PersistEcxeption;

public interface LibraryRepository {

    void createLibrary(LibraryEntity newLibraryEntity) throws PersistEcxeption;

    void updateLibrary(LibraryEntity libraryEntityForUpdate) throws PersistEcxeption;

    void deleteLibrary(LibraryEntity libraryEntityForDelete) throws PersistEcxeption;

    LibraryEntity getLibraryById(long libraryId) throws PersistEcxeption;

    List<LibraryEntity> getAllLibraries() throws NoElementException;
}
