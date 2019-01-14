package hu.simplesoft.dualis.library.data.dao;

import java.util.List;

import hu.simplesoft.dualis.library.exception.PersistEcxeption;
import hu.simplesoft.dualis.library.service.dto.UserDto;

public interface UserDao {
    void createUser(UserDto userDto) throws PersistEcxeption;

    void updateUser(UserDto userDto) throws PersistEcxeption;

    void deleteUser(long userId) throws PersistEcxeption;
    
    UserDto getUserById(long userId) throws PersistEcxeption;

    List<UserDto> getAllUsers() throws PersistEcxeption;
}
