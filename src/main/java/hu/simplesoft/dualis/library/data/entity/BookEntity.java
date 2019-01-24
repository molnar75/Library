package hu.simplesoft.dualis.library.data.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

@Entity(name = "Book")
@Table(name = "books")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    
    @NonNull
    @Column(name = "Title")
    private String title;
    
    @NonNull
    @Column(name = "Publish_date")
    private Date publishDate;

    @ManyToOne
    @JoinColumn(name = "Author_id")
    private AuthorEntity author;
    
    @ManyToOne
    @JoinColumn(name = "Library_id")
    private LibraryEntity library;

    public long getId() {
        return id;
    }

    
    public void setId(long id) {
        this.id = id;
    }

    
    public String getTitle() {
        return title;
    }

    
    public void setTitle(String title) {
        this.title = title;
    }


    
    public Date getPublishDate() {
        return publishDate;
    }


    
    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }


    
    public AuthorEntity getAuthor() {
        return author;
    }


    
    public void setAuthor(AuthorEntity author) {
        this.author = author;
    }


    
    public LibraryEntity getLibrary() {
        return library;
    }


    
    public void setLibrary(LibraryEntity library) {
        this.library = library;
    }
    
    


}
