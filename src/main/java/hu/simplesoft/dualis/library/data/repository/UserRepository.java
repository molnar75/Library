package hu.simplesoft.dualis.library.data.repository;

import java.util.List;

import hu.simplesoft.dualis.library.data.entity.UserEntity;
import hu.simplesoft.dualis.library.exception.NoElementException;
import hu.simplesoft.dualis.library.exception.PersistException;

public interface UserRepository {
    void createUser(UserEntity newUserEntity) throws PersistException;

    void updateUser(UserEntity userEntityForUpdate) throws PersistException;

    void deleteUser(UserEntity userEntityForDelete) throws PersistException;

    UserEntity getUserById(long userId) throws PersistException;

    List<UserEntity> getAllUsers() throws NoElementException;
}
