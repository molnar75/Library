package hu.simplesoft.dualis.library.data.dao;

import java.util.List;

import hu.simplesoft.dualis.library.service.dto.UserDto;

public interface UserDao {
    boolean createUser(UserDto userDto);

    boolean updateUser(UserDto userDto);

    boolean deleteUser(long userId);
    
    UserDto getUserById(long userId);

    List<UserDto> getAllUsers();
}
