package hu.simplesoft.dualis.library.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.simplesoft.dualis.library.service.component.AddressService;
import hu.simplesoft.dualis.library.service.dto.AddressDto;
import hu.simplesoft.dualis.library.service.exception.ServiceException;

@RequestMapping("/")
@RestController
public class AddressController {

    AddressController(){
    }
    
    @Autowired
    private AddressService addressService;
    
    @PostMapping("/createAddress")
    public void createAddress(@RequestBody AddressDto addressDto) throws ServiceException {
        this.addressService.createAddress(addressDto);
    }
    
    @PostMapping("/updateAddress")
    public void updateAddress(@RequestBody AddressDto addressDto) throws ServiceException {
        this.addressService.updateAddress(addressDto);
    }
    
    @PostMapping("/deleteAddress/{id}")
    public void deleteAddress(@PathVariable("id") Long addressId) throws ServiceException {
        this.addressService.deleteAddress(addressId);
    }
    
    @GetMapping("/getAddressById/{id}")
    public AddressDto getAddressById(@PathVariable("id") Long addressId) throws ServiceException {
        return this.addressService.getAddressById(addressId);
    }
    
    @GetMapping("/getAllAddresses")
    public List<AddressDto> getAllAddresses()  {
        return this.getAllAddresses();
    }
}
