package hu.simplesoft.dualis.library.service.component;

import java.util.List;

import hu.simplesoft.dualis.library.service.dto.AuthorDto;
import hu.simplesoft.dualis.library.service.exception.ServiceException;

public interface AuthorService {

    void createAuthor(AuthorDto authorDto) throws ServiceException;

    void updateAuthor(AuthorDto authorDto) throws ServiceException;

    void deleteAuthor(long authorId) throws ServiceException;
    
    AuthorDto getAuthorById(long authorId) throws ServiceException;
    
    List<AuthorDto> getAllAuthors() throws ServiceException;
}
