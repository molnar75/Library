package hu.simplesoft.dualis.library.data.dao;

import java.util.List;

import hu.simplesoft.dualis.library.exception.IsNullException;
import hu.simplesoft.dualis.library.exception.NoElementException;
import hu.simplesoft.dualis.library.exception.PersistEcxeption;
import hu.simplesoft.dualis.library.service.dto.UserDto;

public interface UserDao {
    void createUser(UserDto userDto) throws PersistEcxeption;

    void updateUser(UserDto userDto) throws PersistEcxeption, IsNullException;

    void deleteUser(long userId) throws PersistEcxeption, IsNullException;
    
    UserDto getUserById(long userId) throws PersistEcxeption;

    List<UserDto> getAllUsers() throws NoElementException;
}
