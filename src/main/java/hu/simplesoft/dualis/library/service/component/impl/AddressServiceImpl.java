package hu.simplesoft.dualis.library.service.component.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.simplesoft.dualis.library.data.dao.AddressDao;
import hu.simplesoft.dualis.library.exception.PersistException;
import hu.simplesoft.dualis.library.service.component.AddressService;
import hu.simplesoft.dualis.library.service.dto.AddressDto;
import hu.simplesoft.dualis.library.service.exception.ServiceException;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressDao addressDao;
    
    @Override
    public void createAddress(AddressDto addressDto) throws ServiceException {
        try {
            this.addressDao.createAddress(addressDto);
        } catch (PersistException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void updateAddress(AddressDto addressDto) throws ServiceException {
        try {
            this.addressDao.updateAddress(addressDto);
        } catch (PersistException e) {
            throw new ServiceException(e);
        }      
    }

    @Override
    public void deleteAddress(long addressId) throws ServiceException {
        try {
            this.addressDao.deleteAddress(addressId);
        } catch (PersistException e) {
            throw new ServiceException(e);
        } 
    }

    @Override
    public AddressDto getAddressById(long addressId) throws ServiceException {
        AddressDto foundAddressDto;
        try {
            foundAddressDto = this.addressDao.getAddressById(addressId);
        } catch (PersistException e) {
            throw new ServiceException(e);
        }
        return foundAddressDto;
    }

    @Override
    public List<AddressDto> getAllAddresses() throws ServiceException {
        List<AddressDto> allAddressesDto;
        try {
            allAddressesDto = this.addressDao.getAllAddresses();
        } catch (PersistException e) {
            throw new ServiceException(e);
        }
        return allAddressesDto;
    }
}
