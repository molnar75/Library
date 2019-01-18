package hu.simplesoft.dualis.library.web.mapper;

import hu.simplesoft.dualis.library.service.dto.BookDto;
import hu.simplesoft.dualis.library.web.request.book.CreateBookRequest;
import hu.simplesoft.dualis.library.web.request.book.UpdateBookRequest;

public class BookRequestMapper {

    public static BookDto CreateBookRequestToBookDto(CreateBookRequest createBookRequest) {
        BookDto bookDto = new BookDto();

        bookDto.setTitle(createBookRequest.getTitle());
        bookDto.setPublishDate(createBookRequest.getPublishDate());
        bookDto.setAuthor(createBookRequest.getAuthor());
        bookDto.setLibrary(createBookRequest.getLibrary());
        
        return bookDto;
    }
    
    public static BookDto UpdateBookRequestToBookDto(UpdateBookRequest updateBookRequest) {
        BookDto bookDto = new BookDto();

        bookDto.setId(updateBookRequest.getId());;
        bookDto.setTitle(updateBookRequest.getTitle());
        bookDto.setPublishDate(updateBookRequest.getPublishDate());
        bookDto.setAuthor(updateBookRequest.getAuthor());
        bookDto.setLibrary(updateBookRequest.getLibrary());
        
        return bookDto;
    }
}
