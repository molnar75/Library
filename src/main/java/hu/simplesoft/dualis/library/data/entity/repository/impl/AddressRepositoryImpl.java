package hu.simplesoft.dualis.library.data.entity.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import hu.simplesoft.dualis.library.data.entity.AddressEntity;
import hu.simplesoft.dualis.library.data.entity.repository.AddressRepository;
import hu.simplesoft.dualis.library.exception.MyException;

@Repository
public class AddressRepositoryImpl implements AddressRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void createAddress(AddressEntity newAddressEntity) throws MyException {
        this.entityManager.persist(newAddressEntity);       
    }

    @Override
    public void updateAddress(AddressEntity addressEntityForUpdate, AddressEntity newAddressEntity) throws MyException {
        addressEntityForUpdate.setCountry(newAddressEntity.getCountry());
        addressEntityForUpdate.setHouseNumber(newAddressEntity.getHouseNumber());
        addressEntityForUpdate.setStreet(newAddressEntity.getStreet());
        addressEntityForUpdate.setZipCode(newAddressEntity.getZipCode());
    }

    @Override
    public void deleteAddress(AddressEntity addressEntityForDelete) throws MyException {
        this.entityManager.remove(addressEntityForDelete);
        
    }

    @Override
    public AddressEntity getAddressById(long addressId) throws MyException {
        AddressEntity foundEntity = this.entityManager.find(AddressEntity.class, addressId); 
        
        return foundEntity;
    }

    @Override
    public TypedQuery<AddressEntity> getAllAddresses() throws MyException {
        TypedQuery<AddressEntity> queryForAllAddresses = this.entityManager.createQuery("SELECT  h FROM address h", AddressEntity.class);
        
        return queryForAllAddresses;
    }
    
    
    

}
