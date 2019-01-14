package hu.simplesoft.dualis.library.service.component.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.simplesoft.dualis.library.data.dao.AddressDao;
import hu.simplesoft.dualis.library.exception.PersistEcxeption;
import hu.simplesoft.dualis.library.service.component.AddressService;
import hu.simplesoft.dualis.library.service.dto.AddressDto;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressDao addressDao;
    
    @Override
    public void createAddress(AddressDto addressDto) throws PersistEcxeption {
        this.addressDao.createAddress(addressDto);
    }

    @Override
    public void updateAddress(AddressDto addressDto) throws PersistEcxeption {
        this.addressDao.updateAddress(addressDto);      
    }

    @Override
    public void deleteAddress(long addressId) throws PersistEcxeption {
        this.addressDao.deleteAddress(addressId); 
    }

    @Override
    public AddressDto getAddressById(long addressId) throws PersistEcxeption {
        AddressDto foundAddressDto = this.addressDao.getAddressById(addressId);
        return foundAddressDto;
    }

    @Override
    public List<AddressDto> getAllAddresses() throws PersistEcxeption {
        List<AddressDto> allAddressesDto = this.addressDao.getAllAddresses();
        return allAddressesDto;
    }
}
