package hu.simplesoft.dualis.library.data.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import hu.simplesoft.dualis.library.data.entity.AddressEntity;
import hu.simplesoft.dualis.library.data.repository.AddressRepository;
import hu.simplesoft.dualis.library.exception.NoElementException;
import hu.simplesoft.dualis.library.exception.PersistException;

@Repository
public class AddressRepositoryImpl implements AddressRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void createAddress(AddressEntity newAddressEntity) throws PersistException {
        try {
            this.entityManager.persist(newAddressEntity);
        } catch (RuntimeException e) {
            throw new PersistException("Couldn't create the address", e);
        }
    }

    @Override
    public void updateAddress(AddressEntity addressEntityForUpdate) throws PersistException {
        try {
            this.entityManager.merge(addressEntityForUpdate);
        } catch (RuntimeException e) {
            throw new PersistException("Couldn't update the address!", e);
        }
    }

    @Override
    public void deleteAddress(AddressEntity addressEntityForDelete) throws PersistException {
        try {
            this.entityManager.remove(addressEntityForDelete);
        } catch (RuntimeException e) {
            throw new PersistException("Couldn't delete the address!", e);
        }
    }

    @Override
    public AddressEntity getAddressById(long addressId) throws PersistException {
        AddressEntity foundEntity;

        try {
            foundEntity = this.entityManager.find(AddressEntity.class, addressId);
        } catch (RuntimeException e) {
            throw new PersistException("Couldn't find the address!", e);
        }

        return foundEntity;
    }

    @Override
    public List<AddressEntity> getAllAddresses() throws NoElementException {
        TypedQuery<AddressEntity> queryForAllAddresses;
        List<AddressEntity> allAddressEntities;
        try {
            queryForAllAddresses = this.entityManager.createQuery("SELECT a FROM Address a", AddressEntity.class);
            allAddressEntities = queryForAllAddresses.getResultList();
        } catch (RuntimeException e) {
            throw new NoElementException("Couldn't get all addresses!", e);
        }

        return allAddressEntities;
    }
}
