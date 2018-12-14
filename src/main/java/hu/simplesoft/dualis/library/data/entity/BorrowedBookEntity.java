package hu.simplesoft.dualis.library.data.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

@Entity(name = "BorrowedBooks")
@Table(name = "borrowed_books")
public class BorrowedBookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    
    @NonNull
    @Column(name = "Borrow_date")
    private Date borrowDate;
    
    @Column(name = "Bring_back_date")
    private Date bringBackDate;
    
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Book_id")
    private BookEntity book;
    
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "User_id")
    private UserEntity user;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Library_id")
    private LibraryEntity library;

    
    public long getId() {
        return id;
    }

    
    public void setId(long id) {
        this.id = id;
    }

    
    public Date getBorrowDate() {
        return borrowDate;
    }

    
    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
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
