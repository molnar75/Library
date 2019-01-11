package hu.simplesoft.dualis.library.data.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import hu.simplesoft.dualis.library.data.dao.AddressDao;
import hu.simplesoft.dualis.library.data.entity.AddressEntity;
import hu.simplesoft.dualis.library.data.entity.repository.AddressRepository;
import hu.simplesoft.dualis.library.data.mapper.AddressMapper;
import hu.simplesoft.dualis.library.exception.MyException;
import hu.simplesoft.dualis.library.service.dto.AddressDto;

@Transactional
public class AddressDaoImpl implements AddressDao {
        
    private AddressRepository addressRepository;
    
    @Override
    public boolean createAddress(AddressDto addressDto) throws MyException {
        boolean isSuccess = false;
        
        AddressEntity newAddressEntity = AddressMapper.AddressDtoToEntity(addressDto);
        
        try {
            this.addressRepository.createAddress(newAddressEntity);

            isSuccess = true;
        } catch (RuntimeException e) {
            throw new MyException("Creation failed.");
        }
        
        return isSuccess;
    }

    @Override
    public boolean updateAddress(AddressDto addressDto) throws MyException {
        boolean isSuccess = false;
        AddressEntity addressEntityForUpdate = this.addressRepository.getAddressById(addressDto.getId());
        AddressEntity newAddressEntity = AddressMapper.AddressDtoToEntity(addressDto);

        if (addressEntityForUpdate != null) {
            try {         
                this.addressRepository.updateAddress(addressEntityForUpdate, newAddressEntity);
    
                isSuccess = true;
            } catch (RuntimeException e) {
                throw new MyException("Update failed.");
            }
        }
        return isSuccess;
    }
    
    @Override
    public boolean deleteAddress(long addressId) throws MyException {
        boolean isSuccess = false;
        AddressEntity addressEntityForDelete = this.addressRepository.getAddressById(addressId);
        try {
                this.addressRepository.deleteAddress(addressEntityForDelete);
                isSuccess = true;
        } catch (RuntimeException e) {
            throw new MyException("Deletation failed.");
        }
               
        return isSuccess;
    }

    @Override
    public AddressDto getAddressById(long addressId) throws MyException {
        AddressEntity foundEntity = this.addressRepository.getAddressById(addressId);

        return AddressMapper.AddressEntityToDto(foundEntity);
    }

    @Override
    public List<AddressDto> getAllAddresses() throws MyException {
        TypedQuery<AddressEntity> queryForAllAddresses = this.addressRepository.getAllAddresses();
        List<AddressEntity> allAddressEntities = queryForAllAddresses.getResultList();
        List<AddressDto> allAddressDto = AddressMapper.getAllAdressesToDto(allAddressEntities);

        return allAddressDto;
    }

}
