package hu.simplesoft.dualis.library.web.request.library;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import hu.simplesoft.dualis.library.service.dto.AddressDto;

public class UpdateLibraryRequest {

    @NotNull
    private long id;
    
    @NotBlank
    private String name;
    
    @NotBlank
    private AddressDto address;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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
