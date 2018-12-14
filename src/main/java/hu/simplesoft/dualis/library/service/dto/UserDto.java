package hu.simplesoft.dualis.library.service.dto;

public class UserDto {
    
    private String username;
    private String password;
    private String email;
    private String name;
    private String phoneNumber;
    private RoleDto role;
    private AddressDto address;
    private LibraryDto library;
    
    public UserDto()  {
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public RoleDto getRole() {
        return role;
    }
    
    public void setRole(RoleDto role) {
        this.role = role;
    }
    
    public AddressDto getAddress() {
        return address;
    }
    
    public void setAddress(AddressDto address) {
        this.address = address;
    }
    
    public LibraryDto getLibrary() {
        return library;
    }
    
    public void setLibrary(LibraryDto library) {
        this.library = library;
    }

}
