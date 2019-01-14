package hu.simplesoft.dualis.library.data.dao;

import java.util.List;

import hu.simplesoft.dualis.library.exception.PersistException;
import hu.simplesoft.dualis.library.service.dto.LibraryDto;

public interface LibraryDao {
    void createLibrary(LibraryDto libraryDto) throws PersistException;

    void updateLibrary(LibraryDto libraryDto) throws PersistException;

    void deleteLibrary(long libraryId) throws PersistException;
    
    LibraryDto getLibraryById(long libraryId) throws PersistException;

    List<LibraryDto> getAllLibraries() throws PersistException;
}
