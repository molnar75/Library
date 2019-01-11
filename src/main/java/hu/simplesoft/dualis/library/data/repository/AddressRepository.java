package hu.simplesoft.dualis.library.data.repository;

import java.util.List;

import hu.simplesoft.dualis.library.data.entity.AddressEntity;
import hu.simplesoft.dualis.library.exception.NoElementException;
import hu.simplesoft.dualis.library.exception.PersistEcxeption;

public interface AddressRepository {

    void createAddress(AddressEntity newAddressEntity) throws PersistEcxeption;

    void updateAddress(AddressEntity addressEntityForUpdate) throws PersistEcxeption;

    void deleteAddress(AddressEntity addressEntityForDelete) throws PersistEcxeption;

    AddressEntity getAddressById(long addressId) throws PersistEcxeption;

    List<AddressEntity> getAllAddresses() throws NoElementException;
}
