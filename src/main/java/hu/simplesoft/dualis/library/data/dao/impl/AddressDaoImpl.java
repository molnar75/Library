package hu.simplesoft.dualis.library.data.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import hu.simplesoft.dualis.library.data.dao.AddressDao;
import hu.simplesoft.dualis.library.data.entity.AddressEntity;
import hu.simplesoft.dualis.library.data.mapper.AddressMapper;
import hu.simplesoft.dualis.library.data.repository.AddressRepository;
import hu.simplesoft.dualis.library.exception.NoElementException;
import hu.simplesoft.dualis.library.exception.PersistEcxeption;
import hu.simplesoft.dualis.library.service.dto.AddressDto;

@Transactional
public class AddressDaoImpl implements AddressDao {
        
    private AddressRepository addressRepository;
    
    @Override
    public void createAddress(AddressDto addressDto) throws PersistEcxeption {      
        AddressEntity newAddressEntity = AddressMapper.AddressDtoToEntity(addressDto);
        this.addressRepository.createAddress(newAddressEntity);
    }

    @Override
    public void updateAddress(AddressDto addressDto) throws PersistEcxeption {
        AddressEntity addressEntityForUpdate = this.addressRepository.getAddressById(addressDto.getId());
        AddressEntity newAddressEntity = AddressMapper.AddressDtoToEntity(addressDto);

        if (addressEntityForUpdate != null) { 
                this.addressRepository.updateAddress(addressEntityForUpdate, newAddressEntity);
            }
    }
    
    @Override
    public void deleteAddress(long addressId) throws PersistEcxeption {
        AddressEntity addressEntityForDelete = this.addressRepository.getAddressById(addressId);
                this.addressRepository.deleteAddress(addressEntityForDelete);
    }

    @Override
    public AddressDto getAddressById(long addressId) throws PersistEcxeption {
        AddressEntity foundEntity = this.addressRepository.getAddressById(addressId);

        return AddressMapper.AddressEntityToDto(foundEntity);
    }

    @Override
    public List<AddressDto> getAllAddresses() throws NoElementException {
        TypedQuery<AddressEntity> queryForAllAddresses = this.addressRepository.getAllAddresses();
        List<AddressEntity> allAddressEntities = queryForAllAddresses.getResultList();
        List<AddressDto> allAddressDto = AddressMapper.getAllAdressesToDto(allAddressEntities);

        return allAddressDto;
    }

}
