package hu.simplesoft.dualis.library.web.request.borrowedbook;

import java.util.Date;

import javax.validation.constraints.NotBlank;

import hu.simplesoft.dualis.library.service.dto.BookDto;
import hu.simplesoft.dualis.library.service.dto.LibraryDto;
import hu.simplesoft.dualis.library.service.dto.UserDto;

public class CreateBorrowedBookRequest {

    @NotBlank
    private Date borrowedDate;
    
    @NotBlank
    private Date bringBackDate;
    
    @NotBlank
    private BookDto book;
    
    @NotBlank
    private UserDto user;
    
    @NotBlank
    private LibraryDto library;

    public Date getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(Date borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public Date getBringBackDate() {
        return bringBackDate;
    }

    public void setBringBackDate(Date bringBackDate) {
        this.bringBackDate = bringBackDate;
    }

    public BookDto getBook() {
        return book;
    }

    public void setBook(BookDto book) {
        this.book = book;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public LibraryDto getLibrary() {
        return library;
    }

    public void setLibrary(LibraryDto library) {
        this.library = library;
    }
}
