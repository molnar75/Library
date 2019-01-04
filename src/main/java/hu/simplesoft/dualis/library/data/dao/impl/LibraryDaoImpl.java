package hu.simplesoft.dualis.library.data.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import hu.simplesoft.dualis.library.data.dao.LibraryDao;
import hu.simplesoft.dualis.library.data.entity.LibraryEntity;
import hu.simplesoft.dualis.library.data.mapper.LibraryMapper;
import hu.simplesoft.dualis.library.service.dto.LibraryDto;

@Repository
@Transactional
public class LibraryDaoImpl implements LibraryDao {
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean createLibrary(LibraryDto libraryDto) {
        boolean isSuccess = false;
        LibraryEntity newLibraryEntity = LibraryMapper.LibraryDtoToEntity(libraryDto);
        
        try {
            this.entityManager.persist(newLibraryEntity);

            isSuccess = true;
        } catch (RuntimeException e) {
            //LOG
        }
             
        return isSuccess;
    }

    @Override
    public boolean updateLibrary(LibraryDto libraryDto) {
        boolean isSuccess = false;
        LibraryEntity libraryEntityForUpdate = this.entityManager.find(LibraryEntity.class, libraryDto.getId());
        LibraryEntity newLibraryEntity = LibraryMapper.LibraryDtoToEntity(libraryDto);

        if (libraryEntityForUpdate != null) {
            try {
                libraryEntityForUpdate.setAddress(newLibraryEntity.getAddress());
                libraryEntityForUpdate.setName(newLibraryEntity.getName());
                
                isSuccess = true;
            } catch (RuntimeException e) {
                //LOG
            }
        }
               
        return isSuccess;
    }

    @Override
    public boolean deleteLibrary(long libraryId) {
        boolean isSuccess = false;
        LibraryEntity libraryEntityForDelete = this.entityManager.find(LibraryEntity.class, libraryId);
        
        try {
            this.entityManager.remove(libraryEntityForDelete);

            isSuccess = true;
        } catch (RuntimeException e) {
            //LOG
        }
              
        return isSuccess;
    }

    @Override
    public List<LibraryDto> getAllLibraries() {
        TypedQuery<LibraryEntity> queryForAllLibraries = this.entityManager.createQuery("SELECT  h FROM libraries h", LibraryEntity.class);
        List<LibraryEntity> allLibraryEntities = queryForAllLibraries.getResultList();
        List<LibraryDto> allLibrariesDto = LibraryMapper.getAllLibrariesToDto(allLibraryEntities);

        return allLibrariesDto;
    }
    
    @Override
    public LibraryDto getLibraryById(long libraryId) {
        LibraryEntity foundEntity = this.entityManager.find(LibraryEntity.class, libraryId);

        return LibraryMapper.LibraryEntityToDto(foundEntity);
    }

}
