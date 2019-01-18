package hu.simplesoft.dualis.library.web.mapper;

import hu.simplesoft.dualis.library.service.dto.AuthorDto;
import hu.simplesoft.dualis.library.web.request.author.CreateAuthorRequest;
import hu.simplesoft.dualis.library.web.request.author.UpdateAuthorRequest;

public class AuthorRequestMapper {

    public static AuthorDto CreateAuthorRequestToAuthorDto(CreateAuthorRequest createAuthorRequest) {
        AuthorDto authorDto = new AuthorDto();
        authorDto.setBirthDate(createAuthorRequest.getBirthDate());
        authorDto.setName(createAuthorRequest.getName());
        
        return authorDto;
    }
    
    public static AuthorDto UpdateAuthorRequestToAuthorDto(UpdateAuthorRequest updateAuthorRequest) {
        AuthorDto authorDto = new AuthorDto();
        authorDto.setId(updateAuthorRequest.getId());
        authorDto.setBirthDate(updateAuthorRequest.getBirthDate());
        authorDto.setName(updateAuthorRequest.getName());
        
        return authorDto;
    }
}
