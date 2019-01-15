package hu.simplesoft.dualis.library.service.component;

import java.util.List;

import hu.simplesoft.dualis.library.service.dto.LibraryDto;
import hu.simplesoft.dualis.library.service.exception.ServiceException;

public interface LibraryService {

    void createLibrary(LibraryDto libraryDto) throws ServiceException;

    void updateLibrary(LibraryDto libraryDto) throws ServiceException;

    void deleteLibrary(long libraryId) throws ServiceException;
    
    LibraryDto getLibraryById(long libraryId) throws ServiceException;

    List<LibraryDto> getAllLibraries() throws ServiceException;
}
