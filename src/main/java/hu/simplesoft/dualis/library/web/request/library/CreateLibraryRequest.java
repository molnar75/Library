package hu.simplesoft.dualis.library.web.request.library;

import javax.validation.constraints.NotBlank;

import hu.simplesoft.dualis.library.service.dto.AddressDto;

public class CreateLibraryRequest {

    @NotBlank
    private String name;
    
    @NotBlank
    private AddressDto address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AddressDto getAddress() {
        return address;
    }

    public void setAddress(AddressDto address) {
        this.address = address;
    }
}
