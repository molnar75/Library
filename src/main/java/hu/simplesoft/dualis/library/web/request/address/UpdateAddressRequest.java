package hu.simplesoft.dualis.library.web.request.address;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UpdateAddressRequest {
    
    @NotNull
    private int ZipCode;
    
    @NotBlank
    private String country;
    
    @NotBlank
    private String street;
    
    @NotNull
    private int houseNumber;
    
    public UpdateAddressRequest() {
    }
   
    public int getZipCode() {
        return ZipCode;
    }
    
    public void setZipCode(int zipCode) {
        ZipCode = zipCode;
    }
  
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
   
    public String getStreet() {
        return street;
    }
  
    public void setStreet(String street) {
        this.street = street;
    }
  
    public int getHouseNumber() {
        return houseNumber;
    }
  
    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }  
}
