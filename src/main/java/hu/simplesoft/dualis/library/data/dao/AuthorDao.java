package hu.simplesoft.dualis.library.data.dao;

import java.util.List;

import hu.simplesoft.dualis.library.exception.NoElementException;
import hu.simplesoft.dualis.library.exception.PersistEcxeption;
import hu.simplesoft.dualis.library.service.dto.AuthorDto;

public interface AuthorDao {

    void createAuthor(AuthorDto authorDto) throws PersistEcxeption;

    void updateAuthor(AuthorDto authorDto) throws PersistEcxeption;

    void deleteAuthor(long authorId) throws PersistEcxeption;
    
    AuthorDto getAuthorById(long authorId) throws PersistEcxeption;
    
    List<AuthorDto> getAllAuthors() throws NoElementException;
}
