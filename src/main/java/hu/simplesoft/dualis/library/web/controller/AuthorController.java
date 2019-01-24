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

import hu.simplesoft.dualis.library.service.component.AuthorService;
import hu.simplesoft.dualis.library.service.dto.AuthorDto;
import hu.simplesoft.dualis.library.service.exception.ServiceException;
import hu.simplesoft.dualis.library.web.mapper.AuthorRequestMapper;
import hu.simplesoft.dualis.library.web.request.author.CreateAuthorRequest;
import hu.simplesoft.dualis.library.web.request.author.UpdateAuthorRequest;

@RequestMapping("author")
@RestController
public class AuthorController {

    public AuthorController(){
    }
    
    @Autowired
    private AuthorService authorService;
    
    @PostMapping("createAuthor")
    public void createAuthor(@Valid @RequestBody CreateAuthorRequest createAuthorRequest) throws ServiceException {
        AuthorDto authorDto = AuthorRequestMapper.CreateAuthorRequestToAuthorDto(createAuthorRequest);
        this.authorService.createAuthor(authorDto);
    }
    
    @PostMapping("updateAuthor")
    public void updateAuthor(@Valid @RequestBody UpdateAuthorRequest updateAuthorRequest) throws ServiceException {
        AuthorDto authorDto = AuthorRequestMapper.UpdateAuthorRequestToAuthorDto(updateAuthorRequest);    
        this.authorService.updateAuthor(authorDto);
    }
    
    @PostMapping("deleteAuthor/{id}")
    public void deleteAddress(@NotNull
        @Min(value = 1) @PathVariable("id") long idRequest) throws ServiceException {
        this.authorService.deleteAuthor(idRequest);
    }
    
    @GetMapping("getAuthorById/{id}")
    public AuthorDto getAuthorById(@NotNull
        @Min(value = 1) @PathVariable("id") long idRequest) throws ServiceException {
        return this.authorService.getAuthorById(idRequest);
    }
    
    @GetMapping("getAllAuthors")
    public List<AuthorDto> getAllAuthors() throws ServiceException  {
        return this.authorService.getAllAuthors();
    }
}
