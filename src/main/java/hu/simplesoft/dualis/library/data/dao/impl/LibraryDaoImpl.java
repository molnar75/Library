package hu.simplesoft.dualis.library.data.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.simplesoft.dualis.library.data.dao.LibraryDao;
import hu.simplesoft.dualis.library.data.entity.LibraryEntity;
import hu.simplesoft.dualis.library.data.mapper.LibraryMapper;
import hu.simplesoft.dualis.library.data.repository.LibraryRepository;
import hu.simplesoft.dualis.library.data.validator.ObjectValidator;
import hu.simplesoft.dualis.library.exception.PersistException;
import hu.simplesoft.dualis.library.service.dto.LibraryDto;

@Service
public class LibraryDaoImpl implements LibraryDao {

    @Autowired
    private LibraryRepository libraryRepository;

    @Transactional
    @Override
    public void createLibrary(LibraryDto libraryDto) throws PersistException {
        LibraryEntity newLibraryEntity = LibraryMapper.LibraryDtoToEntity(libraryDto);
        this.libraryRepository.createLibrary(newLibraryEntity);
    }

    @Transactional
    @Override
    public void updateLibrary(LibraryDto libraryDto) throws PersistException {
        LibraryEntity libraryEntityForUpdate = this.libraryRepository.getLibraryById(libraryDto.getId());
        ObjectValidator.entityIsNull(libraryEntityForUpdate, libraryDto.getId());
        LibraryEntity newLibraryEntity = LibraryMapper.LibraryDtoToEntity(libraryDto);

        libraryEntityForUpdate = updateNewEntity(libraryEntityForUpdate, newLibraryEntity);

        this.libraryRepository.updateLibrary(libraryEntityForUpdate);
    }

    @Transactional
    @Override
    public void deleteLibrary(long libraryId) throws PersistException {
        LibraryEntity libraryEntityForDelete = this.libraryRepository.getLibraryById(libraryId);
        ObjectValidator.entityIsNull(libraryEntityForDelete, libraryId);
        this.libraryRepository.deleteLibrary(libraryEntityForDelete);
    }

    @Override
    public List<LibraryDto> getAllLibraries() throws PersistException {
        List<LibraryEntity> allLibraryEntities = this.libraryRepository.getAllLibraries();
        List<LibraryDto> allLibrariesDto = LibraryMapper.getAllLibrariesToDto(allLibraryEntities);

        return allLibrariesDto;
    }

    @Override
    public LibraryDto getLibraryById(long libraryId) throws PersistException {
        LibraryEntity foundEntity = this.libraryRepository.getLibraryById(libraryId);

        return LibraryMapper.LibraryEntityToDto(foundEntity);
    }

    private LibraryEntity updateNewEntity(LibraryEntity libraryEntityForUpdate, LibraryEntity newLibraryEntity) {
        libraryEntityForUpdate.setAddress(newLibraryEntity.getAddress());
        libraryEntityForUpdate.setName(newLibraryEntity.getName());

        return libraryEntityForUpdate;
    }
}
