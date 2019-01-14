package hu.simplesoft.dualis.library.data.repository;

import java.util.List;

import hu.simplesoft.dualis.library.data.entity.AddressEntity;
import hu.simplesoft.dualis.library.exception.NoElementException;
import hu.simplesoft.dualis.library.exception.PersistException;

public interface AddressRepository {

    void createAddress(AddressEntity newAddressEntity) throws PersistException;

    void updateAddress(AddressEntity addressEntityForUpdate) throws PersistException;

    void deleteAddress(AddressEntity addressEntityForDelete) throws PersistException;

    AddressEntity getAddressById(long addressId) throws PersistException;

    List<AddressEntity> getAllAddresses() throws NoElementException;
}
