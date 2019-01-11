package hu.simplesoft.dualis.library.data.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import hu.simplesoft.dualis.library.data.dao.BorrowedBookDao;
import hu.simplesoft.dualis.library.data.entity.BorrowedBookEntity;
import hu.simplesoft.dualis.library.data.mapper.BorrowedBookMapper;
import hu.simplesoft.dualis.library.data.repository.BorrowedBookRepository;
import hu.simplesoft.dualis.library.exception.NoElementException;
import hu.simplesoft.dualis.library.exception.PersistEcxeption;
import hu.simplesoft.dualis.library.service.dto.BorrowedBookDto;

@Repository
@Transactional
public class BorrowedBookDaoImpl implements BorrowedBookDao {

    private BorrowedBookRepository borrowedBookRepository;
    
    @Override
    public void createBorrowedBook(BorrowedBookDto borrowedBookDto) throws PersistEcxeption {
        BorrowedBookEntity newBorrowedBookEntity = BorrowedBookMapper.BorrowedBookDtoToEntity(borrowedBookDto);
        this.borrowedBookRepository.createBorrowedBook(newBorrowedBookEntity);

    }

    @Override
    public void updateBorrowedBook(BorrowedBookDto borrowedBookDto) throws PersistEcxeption {
        BorrowedBookEntity borrowedBookEntityForUpdate = this.borrowedBookRepository.getBorrowedBookById(borrowedBookDto.getId());
        BorrowedBookEntity newBorrowedBookEntity = BorrowedBookMapper.BorrowedBookDtoToEntity(borrowedBookDto);

        if (borrowedBookEntityForUpdate != null) {
            this.borrowedBookRepository.updateBorrowedBook(borrowedBookEntityForUpdate, newBorrowedBookEntity);
        }
    }

    @Override
    public void deleteBorrowedBook(long borrowedBookId) throws PersistEcxeption {
        BorrowedBookEntity borrowedBookEntityForDelete = this.borrowedBookRepository.getBorrowedBookById(borrowedBookId);
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

}
