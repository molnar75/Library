package hu.simplesoft.dualis.library.data.entity.repository;

import javax.persistence.TypedQuery;

import hu.simplesoft.dualis.library.data.entity.AddressEntity;
import hu.simplesoft.dualis.library.exception.MyException;

public interface AddressRepository {

    void createAddress(AddressEntity newAddressEntity) throws MyException;
    void updateAddress(AddressEntity addressEntityForUpdate, AddressEntity newAddressEntity) throws MyException;
    void deleteAddress(AddressEntity addressEntityForDelete) throws MyException;
    AddressEntity getAddressById(long addressId) throws MyException;
    TypedQuery<AddressEntity> getAllAddresses() throws MyException;

}
