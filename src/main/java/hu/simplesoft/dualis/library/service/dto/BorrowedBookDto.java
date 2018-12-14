package hu.simplesoft.dualis.library.service.dto;

import java.util.Date;

import hu.simplesoft.dualis.library.data.entity.BookEntity;
import hu.simplesoft.dualis.library.data.entity.LibraryEntity;
import hu.simplesoft.dualis.library.data.entity.UserEntity;

public class BorrowedBookDto {
    
    private Date borrowedDate;
    private Date bringBackDate;
    private BookEntity book;
    private UserEntity user;
    private LibraryEntity library;
    
    public BorrowedBookDto() {
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

    
    public BookEntity getBook() {
        return book;
    }

    
    public void setBook(BookEntity book) {
        this.book = book;
    }

    
    public UserEntity getUser() {
        return user;
    }

    
    public void setUser(UserEntity user) {
        this.user = user;
    }

    
    public LibraryEntity getLibrary() {
        return library;
    }

    
    public void setLibrary(LibraryEntity library) {
        this.library = library;
    }

}
