package hu.simplesoft.dualis.library.data.dao;

import java.util.List;

import hu.simplesoft.dualis.library.exception.NoElementException;
import hu.simplesoft.dualis.library.exception.PersistEcxeption;
import hu.simplesoft.dualis.library.service.dto.LibraryDto;

public interface LibraryDao {
    void createLibrary(LibraryDto libraryDto) throws PersistEcxeption;

    void updateLibrary(LibraryDto libraryDto) throws PersistEcxeption;

    void deleteLibrary(long libraryId) throws PersistEcxeption;
    
    LibraryDto getLibraryById(long libraryId) throws PersistEcxeption;

    List<LibraryDto> getAllLibraries() throws NoElementException;
}
