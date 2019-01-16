package hu.simplesoft.dualis.library.web.mapper;

import hu.simplesoft.dualis.library.service.dto.AddressDto;
import hu.simplesoft.dualis.library.web.request.address.CreateAddressRequest;
import hu.simplesoft.dualis.library.web.request.address.UpdateAddressRequest;

public class AddressRequestMapper {
    
    public static AddressDto CreateAddressRequestToAddressDto(CreateAddressRequest createAddressRequest) {
        AddressDto addressDto = new AddressDto();
        
        addressDto.setCountry(createAddressRequest.getCountry());
        addressDto.setHouseNumber(createAddressRequest.getHouseNumber());
        addressDto.setStreet(createAddressRequest.getStreet());
        addressDto.setZipCode(createAddressRequest.getZipCode());
        
        return addressDto;
    }
    
    public static AddressDto UpdateAddressRequestToAddressDto(UpdateAddressRequest updateAddressRequest) {
        AddressDto addressDto = new AddressDto();
        
        addressDto.setCountry(updateAddressRequest.getCountry());
        addressDto.setHouseNumber(updateAddressRequest.getHouseNumber());
        addressDto.setStreet(updateAddressRequest.getStreet());
        addressDto.setZipCode(updateAddressRequest.getZipCode());
        
        return addressDto;
    }
}
