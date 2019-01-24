package hu.simplesoft.dualis.library.web.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.simplesoft.dualis.library.service.component.BookService;
import hu.simplesoft.dualis.library.service.dto.BookDto;
import hu.simplesoft.dualis.library.service.exception.ServiceException;
import hu.simplesoft.dualis.library.web.mapper.BookRequestMapper;
import hu.simplesoft.dualis.library.web.request.book.CreateBookRequest;
import hu.simplesoft.dualis.library.web.request.book.UpdateBookRequest;

@RequestMapping("book")
@RestController
public class BookController {

    public BookController(){
    }
    
    @Autowired
    private BookService bookService;
    
    @PostMapping("createBook")
    public void createBook(@Valid @RequestBody CreateBookRequest createBookRequest) throws ServiceException {
        BookDto bookDto = BookRequestMapper.CreateBookRequestToBookDto(createBookRequest);
        this.bookService.createBook(bookDto);
    }
    
    @PostMapping("updateBook")
    public void updateBook(@Valid @RequestBody UpdateBookRequest updateBookRequest) throws ServiceException {
        BookDto bookDto = BookRequestMapper.UpdateBookRequestToBookDto(updateBookRequest);    
        this.bookService.updateBook(bookDto);
    }
    
    @PostMapping("deleteBook/{id}")
    public void deleteBook(@NotNull
        @Min(value = 1) @PathVariable("id") long idRequest) throws ServiceException {
        this.bookService.deleteBook(idRequest);
    }
    
    @GetMapping("getBookById/{id}")
    public BookDto getBookById(@NotNull
        @Min(value = 1) @PathVariable("id") long idRequest) throws ServiceException {
        return this.bookService.getBookById(idRequest);
    }
    
    @GetMapping("getAllBooks")
    public List<BookDto> getAllBooks() throws ServiceException  {
        return this.bookService.getAllBooks();
    }
}
