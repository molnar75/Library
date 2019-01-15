package hu.simplesoft.dualis.library.service.component.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.simplesoft.dualis.library.data.dao.LibraryDao;
import hu.simplesoft.dualis.library.exception.PersistException;
import hu.simplesoft.dualis.library.service.component.LibraryService;
import hu.simplesoft.dualis.library.service.dto.LibraryDto;
import hu.simplesoft.dualis.library.service.exception.ServiceException;

@Service
public class LibraryServiceImpl implements LibraryService {

    @Autowired
    private LibraryDao libraryDao;
    
    @Override
    public void createLibrary(LibraryDto libraryDto) throws ServiceException {
        try {
            this.libraryDao.createLibrary(libraryDto);
        } catch (PersistException e) {
            throw new ServiceException(e);
        } 
    }

    @Override
    public void updateLibrary(LibraryDto libraryDto) throws ServiceException {
        try {
            this.libraryDao.updateLibrary(libraryDto);
        } catch (PersistException e) {
            throw new ServiceException(e);
        } 
    }

    @Override
    public void deleteLibrary(long libraryId) throws ServiceException {
        try {
            this.libraryDao.deleteLibrary(libraryId);
        } catch (PersistException e) {
            throw new ServiceException(e);
        } 
    }

    @Override
    public LibraryDto getLibraryById(long libraryId) throws ServiceException {
        LibraryDto foundLibraryDto;
        try {
            foundLibraryDto = this.libraryDao.getLibraryById(libraryId);
        } catch (PersistException e) {
            throw new ServiceException(e);
        } 
        return foundLibraryDto;
    }

    @Override
    public List<LibraryDto> getAllLibraries() throws ServiceException {
        List<LibraryDto> allLibrariesDto;
        try {
            allLibrariesDto = this.libraryDao.getAllLibraries();
        } catch (PersistException e) {
            throw new ServiceException(e);
        } 
        return allLibrariesDto;
    }
}
