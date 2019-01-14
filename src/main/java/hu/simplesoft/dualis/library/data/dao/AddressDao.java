package hu.simplesoft.dualis.library.data.dao;

import java.util.List;

import hu.simplesoft.dualis.library.data.entity.AddressEntity;
import hu.simplesoft.dualis.library.exception.NoElementException;
import hu.simplesoft.dualis.library.exception.PersistEcxeption;
import hu.simplesoft.dualis.library.service.dto.AddressDto;

public interface AddressDao {
    
    void createAddress(AddressDto addressDto)  throws PersistEcxeption;

    void updateAddress(AddressDto addressDto) throws PersistEcxeption;

    void deleteAddress(long addressId) throws PersistEcxeption;
    
    AddressDto getAddressById(long addressId) throws PersistEcxeption;
    
    List<AddressDto> getAllAddresses() throws NoElementException;
    
    AddressEntity setNewEntity(AddressEntity addressEntityForUpdate, AddressEntity newAddressEntity);
    
    boolean entityValidator(AddressEntity addressEntityForUpdate);
}
