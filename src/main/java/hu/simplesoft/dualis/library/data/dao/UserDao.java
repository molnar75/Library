package hu.simplesoft.dualis.library.data.dao;

import java.util.List;

import hu.simplesoft.dualis.library.exception.PersistException;
import hu.simplesoft.dualis.library.service.dto.UserDto;

public interface UserDao {
    void createUser(UserDto userDto) throws PersistException;

    void updateUser(UserDto userDto) throws PersistException;

    void deleteUser(long userId) throws PersistException;
    
    UserDto getUserById(long userId) throws PersistException;

    List<UserDto> getAllUsers() throws PersistException;
}
