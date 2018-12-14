package hu.simplesoft.dualis.library.data.mapper;

import hu.simplesoft.dualis.library.data.entity.BookEntity;
import hu.simplesoft.dualis.library.service.dto.BookDto;

public class BookMapper {
    
    public static BookEntity BookDtoToEntity(BookDto bookDto) {
        BookEntity bookEntity = new BookEntity();
        
        bookEntity.setId(bookDto.getId());
        bookEntity.setTitle(bookDto.getTitle());
        bookEntity.setPublishDate(bookDto.getPublishDate());
        bookEntity.setAuthor(AuthorMapper.AuthorDtoToEntity(bookDto.getAuthor()));
        bookEntity.setLibrary(LibraryMapper.LibraryDtoToEntity(bookDto.getLibrary()));
        
        return bookEntity;
    }
    
    public static BookDto BookEntityToDto(BookEntity bookEntity) {
        BookDto bookDto = new BookDto();
        
        bookDto.setId(bookEntity.getId());
        bookDto.setTitle(bookEntity.getTitle());
        bookDto.setPublishDate(bookEntity.getPublishDate());
        bookDto.setAuthor(AuthorMapper.AuthorEntityToDto(bookEntity.getAuthor()));
        bookDto.setLibrary(LibraryMapper.LibraryEntityToDto(bookEntity.getLibrary()));
 
        return bookDto;
    }

}
