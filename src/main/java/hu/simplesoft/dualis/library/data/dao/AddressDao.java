package hu.simplesoft.dualis.library.data.dao;

import java.util.List;

import hu.simplesoft.dualis.library.exception.PersistException;
import hu.simplesoft.dualis.library.service.dto.AddressDto;

public interface AddressDao {
    
    void createAddress(AddressDto addressDto)  throws PersistException;

    void updateAddress(AddressDto addressDto) throws PersistException;

    void deleteAddress(long addressId) throws PersistException;
    
    AddressDto getAddressById(long addressId) throws PersistException;
    
    List<AddressDto> getAllAddresses() throws PersistException;
}
