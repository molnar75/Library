package hu.simplesoft.dualis.library.web.mapper;

import hu.simplesoft.dualis.library.service.dto.LibraryDto;
import hu.simplesoft.dualis.library.web.request.library.CreateLibraryRequest;
import hu.simplesoft.dualis.library.web.request.library.UpdateLibraryRequest;

public class LibraryRequestMapper {

    public static LibraryDto CreateLibraryRequestToLibraryDto(CreateLibraryRequest createLibraryRequest) {
        LibraryDto libraryDto = new LibraryDto();
        libraryDto.setAddress(createLibraryRequest.getAddress());
        libraryDto.setName(createLibraryRequest.getName());
        
        return libraryDto;
    }
    
    public static LibraryDto UpdateLibraryRequestToLibraryDto(UpdateLibraryRequest updateLibraryRequest) {
        LibraryDto libraryDto = new LibraryDto();

        libraryDto.setId(updateLibraryRequest.getId());
        libraryDto.setAddress(updateLibraryRequest.getAddress());
        libraryDto.setName(updateLibraryRequest.getName());
        
        return libraryDto;
    }
}
