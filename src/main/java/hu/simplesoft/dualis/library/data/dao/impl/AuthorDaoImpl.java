package hu.simplesoft.dualis.library.data.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import hu.simplesoft.dualis.library.data.dao.AuthorDao;
import hu.simplesoft.dualis.library.data.entity.AuthorEntity;
import hu.simplesoft.dualis.library.data.mapper.AuthorMapper;
import hu.simplesoft.dualis.library.service.dto.AuthorDto;

@Repository
@Transactional
class AuthorDaoImpl implements AuthorDao{
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean createAuthor(AuthorDto authorDto) {
        boolean isSuccess = false;
        
        AuthorEntity newAuthorEntity = AuthorMapper.AuthorDtoToEntity(authorDto);
        
        try {
            this.entityManager.persist(newAuthorEntity);

            isSuccess = true;
        } catch (RuntimeException e) {
            //LOG
        }
                
        return isSuccess;
    }

    @Override
    public boolean updateAuthor(AuthorDto authorDto) {
        boolean isSuccess = false;
        AuthorEntity authorEntityForUpdate = this.entityManager.find(AuthorEntity.class, authorDto.getId());
        AuthorEntity newAuthorEntity = AuthorMapper.AuthorDtoToEntity(authorDto);

        if (authorEntityForUpdate != null) {
            try {
                authorEntityForUpdate.setBirthDate(newAuthorEntity.getBirthDate());
                authorEntityForUpdate.setName(newAuthorEntity.getName());
    
                isSuccess = true;
            } catch (RuntimeException e) {
                //LOG
            }
        }
        return isSuccess;
    }

    @Override
    public boolean deleteAuthor(long authorId) {
        boolean isSuccess = false;
        AuthorEntity authorEntityForDelete = this.entityManager.find(AuthorEntity.class, authorId);
        
        try {
            this.entityManager.remove(authorEntityForDelete);

            isSuccess = true;
        } catch (RuntimeException e) {
            //LOG
        }
                
        return isSuccess;
    }

    @Override
    public AuthorDto getAuthorById(long authorId) {
        AuthorEntity foundEntity = this.entityManager.find(AuthorEntity.class, authorId);

        return AuthorMapper.AuthorEntityToDto(foundEntity);
    }

    @Override
    public List<AuthorDto> getAllAuthors() {
        TypedQuery<AuthorEntity> queryForAllAuthors = this.entityManager.createQuery("SELECT  h FROM authors h", AuthorEntity.class);
        List<AuthorEntity> allAuthorEntities = queryForAllAuthors.getResultList();
        List<AuthorDto> allAuthorsDto = AuthorMapper.getAllAuthorsToDto(allAuthorEntities);

        return allAuthorsDto;
    }

}
