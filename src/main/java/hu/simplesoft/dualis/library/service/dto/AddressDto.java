package hu.simplesoft.dualis.library.service.dto;


public class AddressDto {
    
    private long id;
    private int ZipCode;
    private String country;
    private String street;
    private int houseNumber;
    
    public AddressDto() {
    }

    
    public long getId() {
        return id;
    }

    
    public void setId(long id) {
        this.id = id;
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
