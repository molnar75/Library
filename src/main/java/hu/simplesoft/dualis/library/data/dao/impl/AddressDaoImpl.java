package hu.simplesoft.dualis.library.data.dao.impl;

import java.util.List;

import hu.simplesoft.dualis.library.data.dao.AddressDao;
import hu.simplesoft.dualis.library.service.dto.AddressDto;

public class AddressDaoImpl implements AddressDao {

    public boolean createAddress(AddressDto addressDto) {
        boolean isSuccess = false;
        try {
            //try to create

            isSuccess = true;
        } catch (RuntimeException e) {
            
        }
        
        return isSuccess;
    }

    public boolean updateAddress(AddressDto addressDto) {
        boolean isSuccess = false;
        try {
            //try to update

            isSuccess = true;
        } catch (RuntimeException e) {
            
        }
        
        return isSuccess;
    }

    public boolean deleteAddress(long addressId) {
        boolean isSuccess = false;
        try {
            //try to delete

            isSuccess = true;
        } catch (RuntimeException e) {
            
        }
               
        return isSuccess;
    }

    public boolean getAddressById(long addressId) {
        boolean isSuccess = false;
        try {
            //try to get address by id 

            isSuccess = true;
        } catch (RuntimeException e) {
            
        }
                
        return isSuccess;
    }

    public List<AddressDto> getAllAddresses() {
        // TODO Auto-generated method stub
        return null;
    }

}
