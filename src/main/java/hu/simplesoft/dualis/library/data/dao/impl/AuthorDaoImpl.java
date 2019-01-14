package hu.simplesoft.dualis.library.data.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.simplesoft.dualis.library.data.dao.AuthorDao;
import hu.simplesoft.dualis.library.data.entity.AuthorEntity;
import hu.simplesoft.dualis.library.data.mapper.AuthorMapper;
import hu.simplesoft.dualis.library.data.repository.AuthorRepository;
import hu.simplesoft.dualis.library.data.validator.ObjectValidator;
import hu.simplesoft.dualis.library.exception.PersistException;
import hu.simplesoft.dualis.library.service.dto.AuthorDto;

@Service
class AuthorDaoImpl implements AuthorDao {

    @Autowired
    private AuthorRepository authorRepository;

    @Transactional
    @Override
    public void createAuthor(AuthorDto authorDto) throws PersistException {
        AuthorEntity newAuthorEntity = AuthorMapper.AuthorDtoToEntity(authorDto);
        this.authorRepository.createAuthor(newAuthorEntity);
    }

    @Transactional
    @Override
    public void updateAuthor(AuthorDto authorDto) throws PersistException {
        AuthorEntity authorEntityForUpdate = this.authorRepository.getAuthorById(authorDto.getId());
        ObjectValidator.entityIsNull(authorEntityForUpdate, authorDto.getId());
        AuthorEntity newAuthorEntity = AuthorMapper.AuthorDtoToEntity(authorDto);

        authorEntityForUpdate = updateNewEntity(authorEntityForUpdate, newAuthorEntity);

        this.authorRepository.updateAuthor(authorEntityForUpdate);
    }

    @Transactional
    @Override
    public void deleteAuthor(long authorId) throws PersistException {
        AuthorEntity authorEntityForDelete = this.authorRepository.getAuthorById(authorId);
        ObjectValidator.entityIsNull(authorEntityForDelete, authorId);
        this.authorRepository.deleteAuthor(authorEntityForDelete);
    }

    @Override
    public AuthorDto getAuthorById(long authorId) throws PersistException {
        AuthorEntity foundEntity = this.authorRepository.getAuthorById(authorId);
        
        return AuthorMapper.AuthorEntityToDto(foundEntity);
    }

    @Override
    public List<AuthorDto> getAllAuthors() throws PersistException {
        List<AuthorEntity> allAuthorEntities = this.authorRepository.getAllAuthors();
        List<AuthorDto> allAuthorsDto = AuthorMapper.getAllAuthorsToDto(allAuthorEntities);

        return allAuthorsDto;
    }

    private AuthorEntity updateNewEntity(AuthorEntity authorEntityForUpdate, AuthorEntity newAuthorEntity) {
        authorEntityForUpdate.setBirthDate(newAuthorEntity.getBirthDate());
        authorEntityForUpdate.setName(newAuthorEntity.getName());

        return authorEntityForUpdate;
    }

}
