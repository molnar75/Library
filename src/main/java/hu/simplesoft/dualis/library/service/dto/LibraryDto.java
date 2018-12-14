package hu.simplesoft.dualis.library.service.dto;

import hu.simplesoft.dualis.library.data.entity.AddressEntity;

public class LibraryDto {
    
    private String name;
    private AddressEntity address;
    
    public LibraryDto()  {
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public AddressEntity getAddress() {
        return address;
    }
    
    public void setAddress(AddressEntity address) {
        this.address = address;
    }

}
