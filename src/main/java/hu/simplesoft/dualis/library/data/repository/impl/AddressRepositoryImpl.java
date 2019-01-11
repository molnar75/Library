package hu.simplesoft.dualis.library.data.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import hu.simplesoft.dualis.library.data.entity.AddressEntity;
import hu.simplesoft.dualis.library.data.repository.AddressRepository;
import hu.simplesoft.dualis.library.exception.NoElementException;
import hu.simplesoft.dualis.library.exception.PersistEcxeption;

@Repository
public class AddressRepositoryImpl implements AddressRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void createAddress(AddressEntity newAddressEntity) throws PersistEcxeption {
        try {
            this.entityManager.persist(newAddressEntity);
        } catch (RuntimeException e) {
            throw new PersistEcxeption("Couldn't create the address", e);
        }
    }

    @Override
    public void updateAddress(AddressEntity addressEntityForUpdate, AddressEntity newAddressEntity) throws PersistEcxeption {
        try {
            addressEntityForUpdate.setCountry(newAddressEntity.getCountry());
            addressEntityForUpdate.setHouseNumber(newAddressEntity.getHouseNumber());
            addressEntityForUpdate.setStreet(newAddressEntity.getStreet());
            addressEntityForUpdate.setZipCode(newAddressEntity.getZipCode());

            this.entityManager.merge(addressEntityForUpdate);
        } catch (RuntimeException e) {
            throw new PersistEcxeption("Couldn't update the address!", e);
        }
    }

    @Override
    public void deleteAddress(AddressEntity addressEntityForDelete) throws PersistEcxeption {
        try {
            this.entityManager.remove(addressEntityForDelete);
        } catch (RuntimeException e) {
            throw new PersistEcxeption("Couldn't delete the address!", e);
        }
    }

    @Override
    public AddressEntity getAddressById(long addressId) throws PersistEcxeption {
        AddressEntity foundEntity;

        try {
            foundEntity = this.entityManager.find(AddressEntity.class, addressId);
        } catch (RuntimeException e) {
            throw new PersistEcxeption("Couldn't find the address!", e);
        }

        return foundEntity;
    }

    @Override
    public List<AddressEntity> getAllAddresses() throws NoElementException {
        TypedQuery<AddressEntity> queryForAllAddresses;
        List<AddressEntity> allAddressEntities;
        try {
            queryForAllAddresses = this.entityManager.createQuery("SELECT  h FROM address h", AddressEntity.class);
            allAddressEntities = queryForAllAddresses.getResultList();
        } catch (RuntimeException e) {
            throw new NoElementException("Couldn't get all addresses!", e);
        }

        return allAddressEntities;
    }
}
