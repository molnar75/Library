package hu.simplesoft.dualis.library.data.entity;

import java.sql.Date;

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
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Book_id")
    private BookEntity book;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "User_id")
    private UserEntity user;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Library_id")
    private LibraryEntity libraries;

    
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
    
    
}
