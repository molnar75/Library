package hu.simplesoft.dualis.library.data.mapper;

import hu.simplesoft.dualis.library.data.entity.AuthorEntity;
import hu.simplesoft.dualis.library.service.dto.AuthorDto;

public class AuthorMapper {

    public static AuthorEntity AuthorDtoToEntity(AuthorDto authorDto) {
        AuthorEntity authorEntity = new AuthorEntity();
        
        authorEntity.setId(authorDto.getId());
        authorEntity.setName(authorDto.getName());
        authorEntity.setBirthDate(authorDto.getBirthDate());
        
        return authorEntity;
    }
    
    public static AuthorDto AuthorEntityToDto(AuthorEntity authorEntity) {
        AuthorDto authorDto = new AuthorDto();
 
        authorDto.setId(authorEntity.getId());
        authorDto.setName(authorEntity.getName());
        authorDto.setBirthDate(authorEntity.getBirthDate());
        
        return authorDto;
    }
    
}
