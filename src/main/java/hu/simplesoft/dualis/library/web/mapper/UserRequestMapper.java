package hu.simplesoft.dualis.library.web.mapper;

import hu.simplesoft.dualis.library.service.dto.UserDto;
import hu.simplesoft.dualis.library.web.request.user.CreateUserRequest;
import hu.simplesoft.dualis.library.web.request.user.UpdateUserRequest;

public class UserRequestMapper {

    public static UserDto CreateUserRequestToUserDto(CreateUserRequest createUserRequest) {
        UserDto userDto = new UserDto();
        
        userDto.setAddress(createUserRequest.getAddress());
        userDto.setEmail(createUserRequest.getEmail());
        userDto.setLibrary(createUserRequest.getLibrary());
        userDto.setName(createUserRequest.getName());
        userDto.setPassword(createUserRequest.getPassword());
        userDto.setPhoneNumber(createUserRequest.getPhoneNumber());
        userDto.setRole(createUserRequest.getRole());
        userDto.setUserName(createUserRequest.getUserName());
        
        return userDto;
    }
    
    public static UserDto UpdateUserRequestToUserDto(UpdateUserRequest updateUserRequest) {
        UserDto userDto = new UserDto();

        userDto.setId(updateUserRequest.getId());
        userDto.setAddress(updateUserRequest.getAddress());
        userDto.setEmail(updateUserRequest.getEmail());
        userDto.setLibrary(updateUserRequest.getLibrary());
        userDto.setName(updateUserRequest.getName());
        userDto.setPassword(updateUserRequest.getPassword());
        userDto.setPhoneNumber(updateUserRequest.getPhoneNumber());
        userDto.setRole(updateUserRequest.getRole());
        userDto.setUserName(updateUserRequest.getUserName());
        
        return userDto;
    }
}
