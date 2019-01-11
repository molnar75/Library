package hu.simplesoft.dualis.library.data.repository;

import java.util.List;

import hu.simplesoft.dualis.library.data.entity.UserEntity;
import hu.simplesoft.dualis.library.exception.NoElementException;
import hu.simplesoft.dualis.library.exception.PersistEcxeption;

public interface UserRepository {
    void createUser(UserEntity newUserEntity) throws PersistEcxeption;

    void updateUser(UserEntity userEntityForUpdate, UserEntity newUserEntity) throws PersistEcxeption;

    void deleteUser(UserEntity userEntityForDelete) throws PersistEcxeption;

    UserEntity getUserById(long userId) throws PersistEcxeption;

    List<UserEntity> getAllUsers() throws NoElementException;
}
