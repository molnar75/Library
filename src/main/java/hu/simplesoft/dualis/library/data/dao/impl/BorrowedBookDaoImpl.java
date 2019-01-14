package hu.simplesoft.dualis.library.data.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.simplesoft.dualis.library.data.dao.BorrowedBookDao;
import hu.simplesoft.dualis.library.data.entity.BorrowedBookEntity;
import hu.simplesoft.dualis.library.data.mapper.BorrowedBookMapper;
import hu.simplesoft.dualis.library.data.repository.BorrowedBookRepository;
import hu.simplesoft.dualis.library.data.validator.ObjectValidator;
import hu.simplesoft.dualis.library.exception.NoElementException;
import hu.simplesoft.dualis.library.exception.PersistEcxeption;
import hu.simplesoft.dualis.library.service.dto.BorrowedBookDto;

@Service
public class BorrowedBookDaoImpl implements BorrowedBookDao {

    @Autowired
    private BorrowedBookRepository borrowedBookRepository;
    
    @Transactional
    @Override
    public void createBorrowedBook(BorrowedBookDto borrowedBookDto) throws PersistEcxeption {
        BorrowedBookEntity newBorrowedBookEntity = BorrowedBookMapper.BorrowedBookDtoToEntity(borrowedBookDto);
        this.borrowedBookRepository.createBorrowedBook(newBorrowedBookEntity);
    }

    @Transactional
    @Override
    public void updateBorrowedBook(BorrowedBookDto borrowedBookDto) throws PersistEcxeption {
        BorrowedBookEntity borrowedBookEntityForUpdate = this.borrowedBookRepository.getBorrowedBookById(borrowedBookDto.getId());
        ObjectValidator.entityIsNull(borrowedBookEntityForUpdate, borrowedBookDto.getId());
        BorrowedBookEntity newBorrowedBookEntity = BorrowedBookMapper.BorrowedBookDtoToEntity(borrowedBookDto);

        borrowedBookEntityForUpdate = updateNewEntity(borrowedBookEntityForUpdate, newBorrowedBookEntity);
         
        this.borrowedBookRepository.updateBorrowedBook(borrowedBookEntityForUpdate);
    }

    @Transactional
    @Override
    public void deleteBorrowedBook(long borrowedBookId) throws PersistEcxeption {
        BorrowedBookEntity borrowedBookEntityForDelete = this.borrowedBookRepository.getBorrowedBookById(borrowedBookId);
        ObjectValidator.entityIsNull(borrowedBookEntityForDelete, borrowedBookId);
        this.borrowedBookRepository.deleteBorrowedBook(borrowedBookEntityForDelete);
    }

    @Override
    public List<BorrowedBookDto> getAllBorrowedBooks() throws NoElementException {
        List<BorrowedBookEntity> allBorrowedBookEntities = this.borrowedBookRepository.getAllBorrowedBooks();
        List<BorrowedBookDto> allBorrowedBooksDto = BorrowedBookMapper.getAllBorrowedBooksToDto(allBorrowedBookEntities);

        return allBorrowedBooksDto;
    }

    @Override
    public BorrowedBookDto getBorrowedBookById(long borrowedBookId) throws PersistEcxeption {
        BorrowedBookEntity foundEntity = this.borrowedBookRepository.getBorrowedBookById(borrowedBookId);

        return BorrowedBookMapper.BorrowedBookEntityToDto(foundEntity);
    }
    
    private BorrowedBookEntity updateNewEntity(BorrowedBookEntity borrowedBookEntityForUpdate, BorrowedBookEntity newBorrowedBookEntity) {
        borrowedBookEntityForUpdate.setBook(newBorrowedBookEntity.getBook());
        borrowedBookEntityForUpdate.setBorrowDate(newBorrowedBookEntity.getBorrowDate());
        borrowedBookEntityForUpdate.setBringBackDate(newBorrowedBookEntity.getBringBackDate());
        borrowedBookEntityForUpdate.setLibrary(newBorrowedBookEntity.getLibrary());
        borrowedBookEntityForUpdate.setUser(newBorrowedBookEntity.getUser());
        
        return borrowedBookEntityForUpdate;
    }
}
