package hu.simplesoft.dualis.library.data.repository;

import java.util.List;

import hu.simplesoft.dualis.library.data.entity.AuthorEntity;
import hu.simplesoft.dualis.library.exception.NoElementException;
import hu.simplesoft.dualis.library.exception.PersistException;

public interface AuthorRepository {

    void createAuthor(AuthorEntity newAuthorEntity) throws PersistException;

    void updateAuthor(AuthorEntity authorEntityForUpdate) throws PersistException;

    void deleteAuthor(AuthorEntity authorEntityForDelete) throws PersistException;

    AuthorEntity getAuthorById(long authorId) throws PersistException;

    List<AuthorEntity> getAllAuthors() throws NoElementException;
}
