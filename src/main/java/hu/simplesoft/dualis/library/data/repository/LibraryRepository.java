package hu.simplesoft.dualis.library.data.repository;

import java.util.List;

import hu.simplesoft.dualis.library.data.entity.LibraryEntity;
import hu.simplesoft.dualis.library.exception.NoElementException;
import hu.simplesoft.dualis.library.exception.PersistException;

public interface LibraryRepository {

    void createLibrary(LibraryEntity newLibraryEntity) throws PersistException;

    void updateLibrary(LibraryEntity libraryEntityForUpdate) throws PersistException;

    void deleteLibrary(LibraryEntity libraryEntityForDelete) throws PersistException;

    LibraryEntity getLibraryById(long libraryId) throws PersistException;

    List<LibraryEntity> getAllLibraries() throws NoElementException;
}
