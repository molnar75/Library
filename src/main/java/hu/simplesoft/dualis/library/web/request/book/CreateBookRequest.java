package hu.simplesoft.dualis.library.web.request.book;

import java.util.Date;

import javax.validation.constraints.NotBlank;

import hu.simplesoft.dualis.library.service.dto.AuthorDto;
import hu.simplesoft.dualis.library.service.dto.LibraryDto;

public class CreateBookRequest {

    @NotBlank
    private String title;
    
    @NotBlank
    private Date publishDate;
    
    @NotBlank
    private AuthorDto author;
    
    @NotBlank
    private LibraryDto library;

    public CreateBookRequest() {
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
