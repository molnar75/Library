package hu.simplesoft.dualis.library.data.dao.impl;

import java.util.List;

import hu.simplesoft.dualis.library.data.dao.AuthorDao;
import hu.simplesoft.dualis.library.service.dto.AuthorDto;

public class AuthorDaoImpl implements AuthorDao{

    public boolean createAuthor(AuthorDto authorDto) {
        boolean isSuccess = false;
        try {
            //try to create

            isSuccess = true;
        } catch (RuntimeException e) {
            
        }
                
        return isSuccess;
    }

    public boolean updateAuthor(AuthorDto authorDto) {
        boolean isSuccess = false;
        try {
            //try to update

            isSuccess = true;
        } catch (RuntimeException e) {
            
        }
                
        return isSuccess;
    }

    public boolean deleteAuthor(long authorId) {
        boolean isSuccess = false;
        try {
            //try to delete

            isSuccess = true;
        } catch (RuntimeException e) {
            
        }
                
        return isSuccess;
    }

    public boolean getAuthorById(long authorId) {
        boolean isSuccess = false;
        try {
            //try to get author by id 

            isSuccess = true;
        } catch (RuntimeException e) {
            
        }
                
        return isSuccess;
    }

    public List<AuthorDto> getAllAuthors() {
        // TODO Auto-generated method stub
        return null;
    }

}
