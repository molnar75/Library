package hu.simplesoft.dualis.library.web.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

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
import hu.simplesoft.dualis.library.web.mapper.AddressRequestMapper;
import hu.simplesoft.dualis.library.web.request.address.CreateAddressRequest;
import hu.simplesoft.dualis.library.web.request.address.UpdateAddressRequest;

@RequestMapping("address")
@RestController
public class AddressController {

    public AddressController(){
    }
    
    @Autowired
    private AddressService addressService;
    
    @PostMapping("createAddress")
    public void createAddress(@Valid @RequestBody CreateAddressRequest createAddressRequest) throws ServiceException {
        AddressDto addressDto = AddressRequestMapper.CreateAddressRequestToAddressDto(createAddressRequest);
        this.addressService.createAddress(addressDto);
    }
    
    @PostMapping("updateAddress")
    public void updateAddress(@Valid @RequestBody UpdateAddressRequest updateAddressRequest) throws ServiceException {
        AddressDto addressDto = AddressRequestMapper.UpdateAddressRequestToAddressDto(updateAddressRequest);    
        this.addressService.updateAddress(addressDto);
    }
    
    @PostMapping("deleteAddress/{id}")
    public void deleteAddress(@NotNull
        @Min(value = 1) @PathVariable("id") long idRequest) throws ServiceException {
        this.addressService.deleteAddress(idRequest);
    }
    
    @GetMapping("getAddressById/{id}")
    public AddressDto getAddressById(@NotNull
        @Min(value = 1) @PathVariable("id") long idRequest) throws ServiceException {
        return this.addressService.getAddressById(idRequest);
    }
    
    @GetMapping("getAllAddresses")
    public List<AddressDto> getAllAddresses() throws ServiceException  {
        return this.addressService.getAllAddresses();
    }
}
