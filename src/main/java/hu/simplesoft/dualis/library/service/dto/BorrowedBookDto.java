package hu.simplesoft.dualis.library.service.dto;

import java.util.Date;

public class BorrowedBookDto {
    
    private long id;
    private Date borrowedDate;
    private Date bringBackDate;
    private BookDto book;
    private UserDto user;
    private LibraryDto library;
    
    public BorrowedBookDto() {
    }

    
    
    public long getId() {
        return id;
    }


    
    public void setId(long id) {
        this.id = id;
    }


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
