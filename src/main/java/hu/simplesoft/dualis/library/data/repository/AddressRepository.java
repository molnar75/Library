package hu.simplesoft.dualis.library.data.repository;

import javax.persistence.TypedQuery;

import hu.simplesoft.dualis.library.data.entity.AddressEntity;
import hu.simplesoft.dualis.library.exception.NoElementException;
import hu.simplesoft.dualis.library.exception.PersistEcxeption;

public interface AddressRepository {

    void createAddress(AddressEntity newAddressEntity) throws PersistEcxeption;
    
    void updateAddress(AddressEntity addressEntityForUpdate, AddressEntity newAddressEntity) throws PersistEcxeption;
    
    void deleteAddress(AddressEntity addressEntityForDelete) throws PersistEcxeption;
    
    AddressEntity getAddressById(long addressId) throws PersistEcxeption;
    
    TypedQuery<AddressEntity> getAllAddresses() throws NoElementException;
}
