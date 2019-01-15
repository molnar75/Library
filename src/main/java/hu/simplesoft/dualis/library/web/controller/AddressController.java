package hu.simplesoft.dualis.library.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import hu.simplesoft.dualis.library.service.component.AddressService;
import hu.simplesoft.dualis.library.service.dto.AddressDto;
import hu.simplesoft.dualis.library.service.exception.ServiceException;

@RestController
public class AddressController {

    @Autowired
    private AddressService addressService;
    
    @RequestMapping(value = "/createAddress", method = RequestMethod.POST)
    public void createAddress(HttpServletRequest request,
        HttpServletResponse response) throws ServiceException {
        AddressDto addressDto = null;
        this.addressService.createAddress(addressDto);
    }
    
    @RequestMapping(value = "/updateAddress", method = RequestMethod.POST)
    public void updateAddress(HttpServletRequest request,
        HttpServletResponse response) throws ServiceException {
        AddressDto addressDto = null;
        this.addressService.updateAddress(addressDto);
    }
    
    @RequestMapping(value = "/deleteAddress", method = RequestMethod.POST)
    public void deleteAddress(Long addressId, HttpServletRequest request, 
        HttpServletResponse response) throws ServiceException {
        this.addressService.deleteAddress(addressId);
    }
    
    @RequestMapping(value = "/getAddressById", method = RequestMethod.GET)
    public AddressDto getAddressById(Long addressId, HttpServletRequest request, 
        HttpServletResponse response) throws ServiceException {
        return this.addressService.getAddressById(addressId);
    }
    
    @RequestMapping(value = "/getAllAddresses", method = RequestMethod.GET)
    public List<AddressDto> getAllAddresses()  {
        return this.getAllAddresses();
    }
}
