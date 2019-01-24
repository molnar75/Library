package hu.simplesoft.dualis.library.web.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.simplesoft.dualis.library.service.component.BorrowedBookService;
import hu.simplesoft.dualis.library.service.dto.BorrowedBookDto;
import hu.simplesoft.dualis.library.service.exception.ServiceException;
import hu.simplesoft.dualis.library.web.mapper.BorrowedBookRequestMapper;
import hu.simplesoft.dualis.library.web.request.borrowedbook.CreateBorrowedBookRequest;
import hu.simplesoft.dualis.library.web.request.borrowedbook.UpdateBorrowedBookRequest;

@RequestMapping("borrowedBook")
@RestController
public class BorrowedBookController {

    public BorrowedBookController(){
    }
    
    @Autowired
    private BorrowedBookService borrowedBookService;
    
    @PostMapping("createBorrowedBook")
    public void createBorrowedBook(@Valid @RequestBody CreateBorrowedBookRequest createBorrowedBookRequest) throws ServiceException {
        BorrowedBookDto borrowedBookDto = BorrowedBookRequestMapper.CreateBorrowedBookRequestToBorrowedBookDto(createBorrowedBookRequest);
        this.borrowedBookService.createBorrowedBook(borrowedBookDto);
    }
    
    @PostMapping("updateBorrowedBook")
    public void updateBorrowedBook(@Valid @RequestBody UpdateBorrowedBookRequest updateBorrowedBookRequest) throws ServiceException {
        BorrowedBookDto borrowedBookDto = BorrowedBookRequestMapper.UpdateBorrowedBookRequestToBorrowedBookDto(updateBorrowedBookRequest);    
        this.borrowedBookService.updateBorrowedBook(borrowedBookDto);
    }
    
    @PostMapping("deleteBorrowedBook/{id}")
    public void deleteBorrowedBook(@NotNull
        @Min(value = 1) @PathVariable("id") long idRequest) throws ServiceException {
        this.borrowedBookService.deleteBorrowedBook(idRequest);
    }
    
    @GetMapping("getBorrowedBookById/{id}")
    public BorrowedBookDto getBorrowedBookById(@NotNull
        @Min(value = 1) @PathVariable("id") long idRequest) throws ServiceException {
        return this.borrowedBookService.getBorrowedBookById(idRequest);
    }
    
    @GetMapping("getAllBorrowedBooks")
    public List<BorrowedBookDto> getAllBorrowedBooks() throws ServiceException  {
        return this.borrowedBookService.getAllBorrowedBooks();
    }
}
