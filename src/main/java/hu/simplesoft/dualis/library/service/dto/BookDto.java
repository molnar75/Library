package hu.simplesoft.dualis.library.service.dto;

import java.util.Date;

public class BookDto {

    private long id;
    private String title;
    private Date publishDate;
    private AuthorDto author;
    private LibraryDto library;
    
    public BookDto() {
    }

    
    
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

    
    public AuthorDto getAuthor() {
        return author;
    }

    
    public void setAuthor(AuthorDto author) {
        this.author = author;
    }

    
    public LibraryDto getLibrary() {
        return library;
    }

    
    public void setLibrary(LibraryDto library) {
        this.library = library;
    }
    
}
