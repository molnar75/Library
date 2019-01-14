package hu.simplesoft.dualis.library.data.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import hu.simplesoft.dualis.library.data.dao.LibraryDao;
import hu.simplesoft.dualis.library.data.entity.LibraryEntity;
import hu.simplesoft.dualis.library.data.mapper.LibraryMapper;
import hu.simplesoft.dualis.library.data.repository.LibraryRepository;
import hu.simplesoft.dualis.library.data.validator.ObjectValidator;
import hu.simplesoft.dualis.library.exception.IsNullException;
import hu.simplesoft.dualis.library.exception.NoElementException;
import hu.simplesoft.dualis.library.exception.PersistEcxeption;
import hu.simplesoft.dualis.library.service.dto.LibraryDto;

@Transactional
public class LibraryDaoImpl implements LibraryDao {

    @Autowired
    private LibraryRepository libraryRepository;

    @Override
    public void createLibrary(LibraryDto libraryDto) throws PersistEcxeption {
        LibraryEntity newLibraryEntity = LibraryMapper.LibraryDtoToEntity(libraryDto);
        this.libraryRepository.createLibrary(newLibraryEntity);
    }

    @Override
    public void updateLibrary(LibraryDto libraryDto) throws PersistEcxeption, IsNullException {
        LibraryEntity libraryEntityForUpdate = this.libraryRepository.getLibraryById(libraryDto.getId());
        ObjectValidator.entityIsNull(libraryEntityForUpdate, libraryDto.getId());
        LibraryEntity newLibraryEntity = LibraryMapper.LibraryDtoToEntity(libraryDto);

        libraryEntityForUpdate = updateNewEntity(libraryEntityForUpdate, newLibraryEntity);

        this.libraryRepository.updateLibrary(libraryEntityForUpdate);
    }

    @Override
    public void deleteLibrary(long libraryId) throws PersistEcxeption, IsNullException {
        LibraryEntity libraryEntityForDelete = this.libraryRepository.getLibraryById(libraryId);
        ObjectValidator.entityIsNull(libraryEntityForDelete, libraryId);
        this.libraryRepository.deleteLibrary(libraryEntityForDelete);
    }

    @Override
    public List<LibraryDto> getAllLibraries() throws NoElementException {
        List<LibraryEntity> allLibraryEntities = this.libraryRepository.getAllLibraries();
        List<LibraryDto> allLibrariesDto = LibraryMapper.getAllLibrariesToDto(allLibraryEntities);

        return allLibrariesDto;
    }

    @Override
    public LibraryDto getLibraryById(long libraryId) throws PersistEcxeption {
        LibraryEntity foundEntity = this.libraryRepository.getLibraryById(libraryId);

        return LibraryMapper.LibraryEntityToDto(foundEntity);
    }

    private LibraryEntity updateNewEntity(LibraryEntity libraryEntityForUpdate, LibraryEntity newLibraryEntity) {
        libraryEntityForUpdate.setAddress(newLibraryEntity.getAddress());
        libraryEntityForUpdate.setName(newLibraryEntity.getName());

        return libraryEntityForUpdate;
    }
}
