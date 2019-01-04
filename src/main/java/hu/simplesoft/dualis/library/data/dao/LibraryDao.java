package hu.simplesoft.dualis.library.data.dao;

import java.util.List;

import hu.simplesoft.dualis.library.service.dto.LibraryDto;

public interface LibraryDao {
    boolean createLibrary(LibraryDto libraryDto);

    boolean updateLibrary(LibraryDto libraryDto);

    boolean deleteLibrary(long libraryId);
    
    LibraryDto getLibraryById(long libraryId);

    List<LibraryDto> getAllLibraries();
}
