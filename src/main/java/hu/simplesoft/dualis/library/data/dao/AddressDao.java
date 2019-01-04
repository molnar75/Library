package hu.simplesoft.dualis.library.data.dao;

import java.util.List;

import hu.simplesoft.dualis.library.service.dto.AddressDto;

public interface AddressDao {
    
    boolean createAddress(AddressDto addressDto);

    boolean updateAddress(AddressDto addressDto);

    boolean deleteAddress(long addressId);
    
    AddressDto getAddressById(long addressId);
    
    List<AddressDto> getAllAddresses();
}
