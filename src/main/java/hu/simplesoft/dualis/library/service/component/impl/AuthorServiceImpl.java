package hu.simplesoft.dualis.library.service.component.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.simplesoft.dualis.library.data.dao.AuthorDao;
import hu.simplesoft.dualis.library.exception.PersistException;
import hu.simplesoft.dualis.library.service.component.AuthorService;
import hu.simplesoft.dualis.library.service.dto.AuthorDto;
import hu.simplesoft.dualis.library.service.exception.ServiceException;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorDao authorDao;
    
    @Override
    public void createAuthor(AuthorDto authorDto) throws ServiceException {
        try {
            this.authorDao.createAuthor(authorDto);
        } catch (PersistException e) {
            throw new ServiceException(e);
        }      
    }

    @Override
    public void updateAuthor(AuthorDto authorDto) throws ServiceException {
        try {
            this.authorDao.updateAuthor(authorDto);
        } catch (PersistException e) {
            throw new ServiceException(e);
        }    
    }

    @Override
    public void deleteAuthor(long authorId) throws ServiceException {
        try {
            this.authorDao.deleteAuthor(authorId);
        } catch (PersistException e) {
            throw new ServiceException(e);
        }     
    }

    @Override
    public AuthorDto getAuthorById(long authorId) throws ServiceException {
        AuthorDto foundAuthorDto;
        try {
            foundAuthorDto = this.authorDao.getAuthorById(authorId);
        } catch (PersistException e) {
            throw new ServiceException(e);
        } 
        return foundAuthorDto;
    }

    @Override
    public List<AuthorDto> getAllAuthors() throws ServiceException {
        List<AuthorDto> allAuthorsDto;
        try {
            allAuthorsDto = this.authorDao.getAllAuthors();
        } catch (PersistException e) {
            throw new ServiceException(e);
        } 
        return allAuthorsDto;
    }
}
