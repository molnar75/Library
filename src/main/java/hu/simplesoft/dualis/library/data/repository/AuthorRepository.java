package hu.simplesoft.dualis.library.data.repository;

import java.util.List;

import hu.simplesoft.dualis.library.data.entity.AuthorEntity;
import hu.simplesoft.dualis.library.exception.NoElementException;
import hu.simplesoft.dualis.library.exception.PersistEcxeption;

public interface AuthorRepository {

    void createAuthor(AuthorEntity newAuthorEntity) throws PersistEcxeption;

    void updateAuthor(AuthorEntity authorEntityForUpdate) throws PersistEcxeption;

    void deleteAuthor(AuthorEntity authorEntityForDelete) throws PersistEcxeption;

    AuthorEntity getAuthorById(long authorId) throws PersistEcxeption;

    List<AuthorEntity> getAllAuthors() throws NoElementException;
}
