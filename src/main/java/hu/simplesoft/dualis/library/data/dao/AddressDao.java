package hu.simplesoft.dualis.library.data.dao;

import java.util.List;

import hu.simplesoft.dualis.library.exception.MyException;
import hu.simplesoft.dualis.library.service.dto.AddressDto;

public interface AddressDao {
    
    boolean createAddress(AddressDto addressDto)  throws MyException;

    boolean updateAddress(AddressDto addressDto) throws MyException;

    boolean deleteAddress(long addressId) throws MyException;
    
    AddressDto getAddressById(long addressId) throws MyException;
    
    List<AddressDto> getAllAddresses() throws MyException;
}
