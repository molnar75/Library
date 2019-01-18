package hu.simplesoft.dualis.library.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.simplesoft.dualis.library.service.component.LibraryService;
import hu.simplesoft.dualis.library.service.dto.LibraryDto;
import hu.simplesoft.dualis.library.service.exception.ServiceException;
import hu.simplesoft.dualis.library.web.mapper.LibraryRequestMapper;
import hu.simplesoft.dualis.library.web.request.IdRequest;
import hu.simplesoft.dualis.library.web.request.library.CreateLibraryRequest;
import hu.simplesoft.dualis.library.web.request.library.UpdateLibraryRequest;

@RequestMapping("/library")
@RestController
public class LibraryController {

    public LibraryController(){
    }
    
    @Autowired
    private LibraryService libraryService;
    
    @PostMapping("/createLibrary")
    public void createLibrary(@Valid @RequestBody CreateLibraryRequest createLibraryRequest) throws ServiceException {
        LibraryDto libraryDto = LibraryRequestMapper.CreateLibraryRequestToLibraryDto(createLibraryRequest);
        this.libraryService.createLibrary(libraryDto);
    }
    
    @PostMapping("/updateLibrary")
    public void updateLibrary(@Valid @RequestBody UpdateLibraryRequest updateLibraryRequest) throws ServiceException {
        LibraryDto libraryDto = LibraryRequestMapper.UpdateLibraryRequestToLibraryDto(updateLibraryRequest);    
        this.libraryService.updateLibrary(libraryDto);
    }
    
    @PostMapping("/deleteLibrary/{id}")
    public void deleteLibrary(@Valid @PathVariable("id") IdRequest idRequest) throws ServiceException {
        this.libraryService.deleteLibrary(idRequest.getId());
    }
    
    @GetMapping("/getLibraryById/{id}")
    public LibraryDto getLibraryById(@Valid @PathVariable("id") IdRequest idRequest) throws ServiceException {
        return this.libraryService.getLibraryById(idRequest.getId());
    }
    
    @GetMapping("/getAllLibraries")
    public List<LibraryDto> getAllLibraries()  {
        return this.getAllLibraries();
    }
}
