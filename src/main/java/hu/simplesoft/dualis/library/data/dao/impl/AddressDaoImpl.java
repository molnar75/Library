package hu.simplesoft.dualis.library.data.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import hu.simplesoft.dualis.library.data.dao.AddressDao;
import hu.simplesoft.dualis.library.data.entity.AddressEntity;
import hu.simplesoft.dualis.library.data.mapper.AddressMapper;
import hu.simplesoft.dualis.library.data.repository.AddressRepository;
import hu.simplesoft.dualis.library.data.validator.ObjectValidator;
import hu.simplesoft.dualis.library.exception.IsNullException;
import hu.simplesoft.dualis.library.exception.NoElementException;
import hu.simplesoft.dualis.library.exception.PersistEcxeption;
import hu.simplesoft.dualis.library.service.dto.AddressDto;

@Transactional
public class AddressDaoImpl implements AddressDao {

    private AddressRepository addressRepository;
    private ObjectValidator objectValidator;

    @Override
    public void createAddress(AddressDto addressDto) throws PersistEcxeption {
        AddressEntity newAddressEntity = AddressMapper.AddressDtoToEntity(addressDto);
        this.addressRepository.createAddress(newAddressEntity);
    }

    @Override
    public void updateAddress(AddressDto addressDto) throws PersistEcxeption, IsNullException {
        AddressEntity addressEntityForUpdate = this.addressRepository.getAddressById(addressDto.getId());
        AddressEntity newAddressEntity = AddressMapper.AddressDtoToEntity(addressDto);

        objectValidator.entityIsNull(addressEntityForUpdate, addressDto.getId());

        addressEntityForUpdate = updateNewEntity(addressEntityForUpdate, newAddressEntity);

        this.addressRepository.updateAddress(addressEntityForUpdate);
    }

    @Override
    public void deleteAddress(long addressId) throws PersistEcxeption, IsNullException {
        AddressEntity addressEntityForDelete = this.addressRepository.getAddressById(addressId);

        objectValidator.entityIsNull(addressEntityForDelete, addressId);

        this.addressRepository.deleteAddress(addressEntityForDelete);
    }

    @Override
    public AddressDto getAddressById(long addressId) throws PersistEcxeption {
        AddressEntity foundEntity = this.addressRepository.getAddressById(addressId);

        return AddressMapper.AddressEntityToDto(foundEntity);
    }

    @Override
    public List<AddressDto> getAllAddresses() throws NoElementException {
        List<AddressEntity> allAddressEntities = this.addressRepository.getAllAddresses();
        List<AddressDto> allAddressDto = AddressMapper.getAllAdressesToDto(allAddressEntities);

        return allAddressDto;
    }

    private AddressEntity updateNewEntity(AddressEntity addressEntityForUpdate, AddressEntity newAddressEntity) {
        addressEntityForUpdate.setCountry(newAddressEntity.getCountry());
        addressEntityForUpdate.setHouseNumber(newAddressEntity.getHouseNumber());
        addressEntityForUpdate.setStreet(newAddressEntity.getStreet());
        addressEntityForUpdate.setZipCode(newAddressEntity.getZipCode());

        return addressEntityForUpdate;
    }

}
