package hu.simplesoft.dualis.library.service.dto;

import java.util.Date;

import hu.simplesoft.dualis.library.data.entity.AuthorEntity;
import hu.simplesoft.dualis.library.data.entity.LibraryEntity;

public class BookDto {

    private String title;
    private Date publishDate;
    private AuthorEntity author;
    private LibraryEntity library;
    
    public BookDto() {
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
