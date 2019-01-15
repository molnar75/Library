package hu.simplesoft.dualis.library.service.component;

import java.util.List;

import hu.simplesoft.dualis.library.service.dto.UserDto;
import hu.simplesoft.dualis.library.service.exception.ServiceException;

public interface UserService {

    void createUser(UserDto userDto) throws ServiceException;

    void updateUser(UserDto userDto) throws ServiceException;

    void deleteUser(long userId) throws ServiceException;
    
    UserDto getUserById(long userId) throws ServiceException;

    List<UserDto> getAllUsers() throws ServiceException;
}
