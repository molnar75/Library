package hu.simplesoft.dualis.library.data.dao;

import java.util.List;

import hu.simplesoft.dualis.library.service.dto.AuthorDto;

public interface AuthorDao {

    boolean createAuthor(AuthorDto authorDto);

    boolean updateAuthor(AuthorDto authorDto);

    boolean deleteAuthor(long authorId);
    
    AuthorDto getAuthorById(long authorId);
    
    List<AuthorDto> getAllAuthors();
}
