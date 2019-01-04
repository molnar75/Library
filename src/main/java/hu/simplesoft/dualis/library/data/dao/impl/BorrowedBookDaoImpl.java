package hu.simplesoft.dualis.library.data.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import hu.simplesoft.dualis.library.data.dao.BorrowedBookDao;
import hu.simplesoft.dualis.library.data.entity.BorrowedBookEntity;
import hu.simplesoft.dualis.library.data.mapper.BorrowedBookMapper;
import hu.simplesoft.dualis.library.service.dto.BorrowedBookDto;

@Repository
@Transactional
public class BorrowedBookDaoImpl implements BorrowedBookDao {

    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public boolean createBorrowedBook(BorrowedBookDto borrowedBookDto) {
        boolean isSuccess = false;
        BorrowedBookEntity newBorrowedBookEntity = BorrowedBookMapper.BorrowedBookDtoToEntity(borrowedBookDto);
        
        try {
            this.entityManager.persist(newBorrowedBookEntity);

            isSuccess = true;
        } catch (RuntimeException e) {
            //LOG
        }
                
        return isSuccess;
    }

    @Override
    public boolean updateBorrowedBook(BorrowedBookDto borrowedBookDto) {
        boolean isSuccess = false;
        BorrowedBookEntity borrowedBookEntityForUpdate = this.entityManager.find(BorrowedBookEntity.class, borrowedBookDto.getId());
        BorrowedBookEntity newBorrowedBookEntity = BorrowedBookMapper.BorrowedBookDtoToEntity(borrowedBookDto);

        if (borrowedBookEntityForUpdate != null) {
            try {
                borrowedBookEntityForUpdate.setBook(newBorrowedBookEntity.getBook());
                borrowedBookEntityForUpdate.setBorrowDate(newBorrowedBookEntity.getBorrowDate());
                borrowedBookEntityForUpdate.setBringBackDate(newBorrowedBookEntity.getBringBackDate());
                borrowedBookEntityForUpdate.setLibrary(newBorrowedBookEntity.getLibrary());
                borrowedBookEntityForUpdate.setUser(newBorrowedBookEntity.getUser());
    
                isSuccess = true;
            } catch (RuntimeException e) {
                //LOG
            }
        }
                
        return isSuccess;
    }

    @Override
    public boolean deleteBorrowedBook(long borrowedBookId) {
        boolean isSuccess = false;
        BorrowedBookEntity borrowedBookEntityForDelete = this.entityManager.find(BorrowedBookEntity.class, borrowedBookId);
        
        try {
            this.entityManager.remove(borrowedBookEntityForDelete);

            isSuccess = true;
        } catch (RuntimeException e) {
            //LOG
        }
                
        return isSuccess;
    }

    @Override
    public List<BorrowedBookDto> getAllBorrowedBooks() {
        TypedQuery<BorrowedBookEntity> queryForAllBorrowedBooks = this.entityManager.createQuery("SELECT  h FROM borrowed_books h", BorrowedBookEntity.class);
        List<BorrowedBookEntity> allBorrowedBookEntities = queryForAllBorrowedBooks.getResultList();
        List<BorrowedBookDto> allBorrowedBooksDto = BorrowedBookMapper.getAllBorrowedBooksToDto(allBorrowedBookEntities);

        return allBorrowedBooksDto;
    }

    @Override
    public BorrowedBookDto getBorrowedBookById(long borrowedBookId) {
        BorrowedBookEntity foundEntity = this.entityManager.find(BorrowedBookEntity.class, borrowedBookId);

        return BorrowedBookMapper.BorrowedBookEntityToDto(foundEntity);
    }

}
