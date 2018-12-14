package hu.simplesoft.dualis.library.data.mapper;

import hu.simplesoft.dualis.library.data.entity.AddressEntity;
import hu.simplesoft.dualis.library.service.dto.AddressDto;

public class AddressMapper {
    
    public static AddressEntity AddressDtoToEntity(AddressDto addressDto) {
        AddressEntity addressEntity = new AddressEntity();
        
        addressEntity.setId(addressDto.getId());
        addressEntity.setZipCode(addressDto.getZipCode());
        addressEntity.setCountry(addressDto.getCountry());
        addressEntity.setStreet(addressDto.getStreet());
        addressEntity.setHouseNumber(addressDto.getHouseNumber());
        
        return addressEntity;
    }
    
    public static AddressDto AddressEntityToDto(AddressEntity addressEntity) {
        AddressDto addressDto = new AddressDto();
        
        addressDto.setId(addressEntity.getId());
        addressDto.setZipCode(addressEntity.getZipCode());
        addressDto.setCountry(addressEntity.getCountry());
        addressDto.setStreet(addressEntity.getStreet());
        addressDto.setHouseNumber(addressEntity.getHouseNumber());
        
        return addressDto;
    }

}
