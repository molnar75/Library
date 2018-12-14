package hu.simplesoft.dualis.library.data.dao.impl;

import java.util.List;

import hu.simplesoft.dualis.library.data.dao.LibraryDao;
import hu.simplesoft.dualis.library.service.dto.LibraryDto;

public class LibraryDaoImpl implements LibraryDao {

    public boolean createLibrary(LibraryDto libraryDto) {
        boolean isSuccess = false;
        try {
            //try to create

            isSuccess = true;
        } catch (RuntimeException e) {
            
        }
             
        return isSuccess;
    }

    public boolean updateLibrary(LibraryDto libraryDto) {
        boolean isSuccess = false;
        try {
            //try to update

            isSuccess = true;
        } catch (RuntimeException e) {
            
        }
               
        return isSuccess;
    }

    public boolean deleteLibrary(long libraryId) {
        boolean isSuccess = false;
        try {
            //try to delete

            isSuccess = true;
        } catch (RuntimeException e) {
            
        }
              
        return isSuccess;
    }

    public List<LibraryDto> getAllLibraries() {
        // TODO Auto-generated method stub
        return null;
    }

    public boolean getLibraryById(long libraryId) {
        boolean isSuccess = false;
        try {
            //try to get library by id

            isSuccess = true;
        } catch (RuntimeException e) {
            
        }
               
        return isSuccess;
    }

}
