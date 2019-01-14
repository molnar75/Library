package hu.simplesoft.dualis.library.service.component;

import java.util.List;

import hu.simplesoft.dualis.library.service.dto.AddressDto;
import hu.simplesoft.dualis.library.service.exception.ServiceException;

public interface AddressService {
    
    void createAddress(AddressDto addressDto) throws ServiceException;

    void updateAddress(AddressDto addressDto) throws ServiceException;

    void deleteAddress(long addressId) throws ServiceException;
    
    AddressDto getAddressById(long addressId) throws ServiceException;
    
    List<AddressDto> getAllAddresses() throws ServiceException;

}
