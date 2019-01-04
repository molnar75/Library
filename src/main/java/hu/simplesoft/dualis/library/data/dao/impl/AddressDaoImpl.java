package hu.simplesoft.dualis.library.data.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import hu.simplesoft.dualis.library.data.dao.AddressDao;
import hu.simplesoft.dualis.library.data.entity.AddressEntity;
import hu.simplesoft.dualis.library.data.mapper.AddressMapper;
import hu.simplesoft.dualis.library.service.dto.AddressDto;

public class AddressDaoImpl implements AddressDao {
        
    private EntityManager entityManager;

    public boolean createAddress(AddressDto addressDto) {
        boolean isSuccess = false;
        
        AddressEntity newAdressEntity = AddressMapper.AddressDtoToEntity(addressDto);
        
        try {
            this.entityManager.persist(newAdressEntity);

            isSuccess = true;
        } catch (RuntimeException e) {
            //LOG
        }
        
        return isSuccess;
    }

    public boolean updateAddress(AddressDto addressDto) {
        boolean isSuccess = false;
        AddressEntity addressEntityForUpdate = this.entityManager.find(AddressEntity.class, addressDto.getId());
        AddressEntity newAddressEntity = AddressMapper.AddressDtoToEntity(addressDto);

        if (addressEntityForUpdate != null) {
            try {
                addressEntityForUpdate.setCountry(newAddressEntity.getCountry());
                addressEntityForUpdate.setHouseNumber(newAddressEntity.getHouseNumber());
                addressEntityForUpdate.setStreet(newAddressEntity.getStreet());
                addressEntityForUpdate.setZipCode(newAddressEntity.getZipCode());
    
                isSuccess = true;
            } catch (RuntimeException e) {
                //LOG
            }
        }
        return isSuccess;
    }

    public boolean deleteAddress(long addressId) {
        boolean isSuccess = false;
        AddressEntity addressEntityForDelete = this.entityManager.find(AddressEntity.class, addressId);
        try {
                this.entityManager.remove(addressEntityForDelete);
                isSuccess = true;
        } catch (RuntimeException e) {
            //LOG
        }
               
        return isSuccess;
    }

    public AddressDto getAddressById(long addressId) {
        AddressEntity foundEntity = this.entityManager.find(AddressEntity.class, addressId);

        return AddressMapper.AddressEntityToDto(foundEntity);
    }

    public List<AddressDto> getAllAddresses() {
        TypedQuery<AddressEntity> queryForAllAddresses = this.entityManager.createQuery("SELECT  h FROM address h", AddressEntity.class);
        List<AddressEntity> allAddressEntities = queryForAllAddresses.getResultList();
        List<AddressDto> allAddressDto = AddressMapper.getAllAdressesToDto(allAddressEntities);

        return allAddressDto;
    }

}
