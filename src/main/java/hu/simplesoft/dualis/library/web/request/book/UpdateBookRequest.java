package hu.simplesoft.dualis.library.web.request.book;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import hu.simplesoft.dualis.library.service.dto.AuthorDto;
import hu.simplesoft.dualis.library.service.dto.LibraryDto;

public class UpdateBookRequest {

    @NotNull
    private long id;
    
    @NotBlank
    private String title;
    
    @NotNull
    private Date publishDate;
    
    @NotNull
    private AuthorDto author;
    
    @NotNull
    private LibraryDto library;

    public UpdateBookRequest() {
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
