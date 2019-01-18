package hu.simplesoft.dualis.library.web.mapper;

import hu.simplesoft.dualis.library.service.dto.BorrowedBookDto;
import hu.simplesoft.dualis.library.web.request.borrowedbook.CreateBorrowedBookRequest;
import hu.simplesoft.dualis.library.web.request.borrowedbook.UpdateBorrowedBookRequest;

public class BorrowedBookRequestMapper {

    public static BorrowedBookDto CreateBorrowedBookRequestToBorrowedBookDto(CreateBorrowedBookRequest createBorrowedBookRequest) {
        BorrowedBookDto borrowedBookDto = new BorrowedBookDto();

      
        borrowedBookDto.setBorrowedDate(createBorrowedBookRequest.getBorrowedDate());
        borrowedBookDto.setBringBackDate(createBorrowedBookRequest.getBringBackDate());
        borrowedBookDto.setUser(createBorrowedBookRequest.getUser());
        borrowedBookDto.setLibrary(createBorrowedBookRequest.getLibrary());
        borrowedBookDto.setBook(createBorrowedBookRequest.getBook());
        
        return borrowedBookDto;
    }
    
    public static BorrowedBookDto UpdateBorrowedBookRequestToBorrowedBookDto(UpdateBorrowedBookRequest updateBorrowedBookRequest) {
        BorrowedBookDto borrowedBookDto = new BorrowedBookDto();
        
        borrowedBookDto.setId(updateBorrowedBookRequest.getId());
        borrowedBookDto.setBorrowedDate(updateBorrowedBookRequest.getBorrowedDate());
        borrowedBookDto.setBringBackDate(updateBorrowedBookRequest.getBringBackDate());
        borrowedBookDto.setUser(updateBorrowedBookRequest.getUser());
        borrowedBookDto.setLibrary(updateBorrowedBookRequest.getLibrary());
        borrowedBookDto.setBook(updateBorrowedBookRequest.getBook());
        
        return borrowedBookDto;
    }
}
