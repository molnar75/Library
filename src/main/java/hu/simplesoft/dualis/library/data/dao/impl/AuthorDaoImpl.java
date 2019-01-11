package hu.simplesoft.dualis.library.data.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import hu.simplesoft.dualis.library.data.dao.AuthorDao;
import hu.simplesoft.dualis.library.data.entity.AuthorEntity;
import hu.simplesoft.dualis.library.data.mapper.AuthorMapper;
import hu.simplesoft.dualis.library.data.repository.AuthorRepository;
import hu.simplesoft.dualis.library.exception.NoElementException;
import hu.simplesoft.dualis.library.exception.PersistEcxeption;
import hu.simplesoft.dualis.library.service.dto.AuthorDto;

@Transactional
class AuthorDaoImpl implements AuthorDao {

    private AuthorRepository authorRepository;

    @Override
    public void createAuthor(AuthorDto authorDto) throws PersistEcxeption {
        AuthorEntity newAuthorEntity = AuthorMapper.AuthorDtoToEntity(authorDto);
        this.authorRepository.createAuthor(newAuthorEntity);
    }

    @Override
    public void updateAuthor(AuthorDto authorDto) throws PersistEcxeption {
        AuthorEntity authorEntityForUpdate = this.authorRepository.getAuthorById(authorDto.getId());
        AuthorEntity newAuthorEntity = AuthorMapper.AuthorDtoToEntity(authorDto);

        if (authorEntityForUpdate != null) {
            authorEntityForUpdate.setBirthDate(newAuthorEntity.getBirthDate());
            authorEntityForUpdate.setName(newAuthorEntity.getName());
            
            this.authorRepository.updateAuthor(authorEntityForUpdate);
        }
    }

    @Override
    public void deleteAuthor(long authorId) throws PersistEcxeption {
        AuthorEntity authorEntityForDelete = this.authorRepository.getAuthorById(authorId);
        this.authorRepository.deleteAuthor(authorEntityForDelete);
    }

    @Override
    public AuthorDto getAuthorById(long authorId) throws PersistEcxeption {
        AuthorEntity foundEntity = this.authorRepository.getAuthorById(authorId);
        return AuthorMapper.AuthorEntityToDto(foundEntity);
    }

    @Override
    public List<AuthorDto> getAllAuthors() throws NoElementException {
        List<AuthorEntity> allAuthorEntities = this.authorRepository.getAllAuthors();
        List<AuthorDto> allAuthorsDto = AuthorMapper.getAllAuthorsToDto(allAuthorEntities);

        return allAuthorsDto;
    }

}
