package hu.simplesoft.dualis.library.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.simplesoft.dualis.library.service.component.UserService;
import hu.simplesoft.dualis.library.service.dto.UserDto;
import hu.simplesoft.dualis.library.service.exception.ServiceException;
import hu.simplesoft.dualis.library.web.mapper.UserRequestMapper;
import hu.simplesoft.dualis.library.web.request.IdRequest;
import hu.simplesoft.dualis.library.web.request.user.CreateUserRequest;
import hu.simplesoft.dualis.library.web.request.user.UpdateUserRequest;

@RequestMapping("/user")
@RestController
public class UserController {

    public UserController(){
    }
    
    @Autowired
    private UserService userService;
    
    @PostMapping("/createUser")
    public void createUser(@Valid @RequestBody CreateUserRequest createUserRequest) throws ServiceException {
        UserDto userDto = UserRequestMapper.CreateUserRequestToUserDto(createUserRequest);
        this.userService.createUser(userDto);
    }
    
    @PostMapping("/updateUser")
    public void updateUser(@Valid @RequestBody UpdateUserRequest updateUserRequest) throws ServiceException {
        UserDto userDto = UserRequestMapper.UpdateUserRequestToUserDto(updateUserRequest);    
        this.userService.updateUser(userDto);
    }
    
    @PostMapping("/deleteUser/{id}")
    public void deleteUser(@Valid @PathVariable("id") IdRequest idRequest) throws ServiceException {
        this.userService.deleteUser(idRequest.getId());
    }
    
    @GetMapping("/getUserById/{id}")
    public UserDto getUserById(@Valid @PathVariable("id") IdRequest idRequest) throws ServiceException {
        return this.userService.getUserById(idRequest.getId());
    }
    
    @GetMapping("/getAllUsers")
    public List<UserDto> getAllUsers()  {
        return this.getAllUsers();
    }
}
