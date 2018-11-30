package hu.simplesoft.dualis.library.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

@Entity(name = "Address")
@Table(name = "address")
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @NonNull
    @Column(name = "Zip_code")
    private int ZipCode;
    
    @NonNull
    @Column(name = "Country")
    private String country;
    
    @NonNull
    @Column(name = "Street")
    private String street;
    
    @NonNull
    @Column(name = "House_number")
    private int houseNumber;

    
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
