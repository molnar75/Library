package hu.simplesoft.dualis.library.web.request.user;

import javax.validation.constraints.NotBlank;

import hu.simplesoft.dualis.library.service.dto.AddressDto;
import hu.simplesoft.dualis.library.service.dto.LibraryDto;
import hu.simplesoft.dualis.library.service.dto.RoleDto;

public class CreateUserRequest {

    @NotBlank
    private String userName;

    @NotBlank
    private String password;

    @NotBlank
    private String email;

    @NotBlank
    private String name;

    @NotBlank
    private String phoneNumber;

    @NotBlank
    private RoleDto role;

    @NotBlank
    private AddressDto address;

    @NotBlank
    private LibraryDto library;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
