package hu.simplesoft.dualis.library.data.dao;

import java.util.List;

import hu.simplesoft.dualis.library.exception.PersistException;
import hu.simplesoft.dualis.library.service.dto.AuthorDto;

public interface AuthorDao {

    void createAuthor(AuthorDto authorDto) throws PersistException;

    void updateAuthor(AuthorDto authorDto) throws PersistException;

    void deleteAuthor(long authorId) throws PersistException;
    
    AuthorDto getAuthorById(long authorId) throws PersistException;
    
    List<AuthorDto> getAllAuthors() throws PersistException;
}
