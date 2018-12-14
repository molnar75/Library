package hu.simplesoft.dualis.library.data.mapper;

import hu.simplesoft.dualis.library.data.entity.LibraryEntity;
import hu.simplesoft.dualis.library.service.dto.LibraryDto;

public class LibraryMapper {
    
    public static LibraryEntity LibraryDtoToEntity(LibraryDto libraryDto) {
        LibraryEntity libraryEntity = new LibraryEntity();
        
        libraryEntity.setId(libraryDto.getId());
        libraryEntity.setName(libraryDto.getName());
        libraryEntity.setAddress(AddressMapper.AddressDtoToEntity(libraryDto.getAddress()));
        
        return libraryEntity;
    }
    
    public static LibraryDto LibraryEntityToDto(LibraryEntity libraryEntity) {
        LibraryDto libraryDto = new LibraryDto();
        
        libraryDto.setId(libraryEntity.getId());
        libraryDto.setName(libraryDto.getName());
        libraryDto.setAddress(AddressMapper.AddressEntityToDto(libraryEntity.getAddress()));
        
        return libraryDto;
    }

}
