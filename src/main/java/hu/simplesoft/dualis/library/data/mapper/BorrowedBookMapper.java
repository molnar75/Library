package hu.simplesoft.dualis.library.data.mapper;

import hu.simplesoft.dualis.library.data.entity.BorrowedBookEntity;
import hu.simplesoft.dualis.library.service.dto.BorrowedBookDto;

public class BorrowedBookMapper {
    
    public static BorrowedBookEntity BorrowedBookDtoToEntity(BorrowedBookDto borrowedBookDto) {
        BorrowedBookEntity borrowedBookEntity = new BorrowedBookEntity();
        
        borrowedBookEntity.setId(borrowedBookDto.getId());
        borrowedBookEntity.setBorrowDate(borrowedBookDto.getBorrowedDate());
        borrowedBookEntity.setBringBackDate(borrowedBookDto.getBringBackDate());
        borrowedBookEntity.setBook(BookMapper.BookDtoToEntity(borrowedBookDto.getBook()));
        borrowedBookEntity.setUser(UserMapper.UserDtoToEntity(borrowedBookDto.getUser()));
        borrowedBookEntity.setLibrary(LibraryMapper.LibraryDtoToEntity(borrowedBookDto.getLibrary()));
        
        return borrowedBookEntity;
    }
    
    public static BorrowedBookDto BorrowedBookEntityToDto(BorrowedBookEntity borrowedBookEntity) {
        BorrowedBookDto borrowedBookDto = new BorrowedBookDto();
 
        borrowedBookDto.setId(borrowedBookEntity.getId());
        borrowedBookDto.setBorrowedDate(borrowedBookEntity.getBorrowDate());
        borrowedBookDto.setBringBackDate(borrowedBookEntity.getBringBackDate());
        borrowedBookDto.setBook(BookMapper.BookEntityToDto(borrowedBookEntity.getBook()));
        borrowedBookDto.setUser(UserMapper.UserEntityToDto(borrowedBookEntity.getUser()));
        borrowedBookDto.setLibrary(LibraryMapper.LibraryEntityToDto(borrowedBookEntity.getLibrary()));
        
        return borrowedBookDto;
    }

}
