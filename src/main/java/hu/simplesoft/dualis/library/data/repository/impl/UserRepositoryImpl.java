package hu.simplesoft.dualis.library.data.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import hu.simplesoft.dualis.library.data.entity.UserEntity;
import hu.simplesoft.dualis.library.data.repository.UserRepository;
import hu.simplesoft.dualis.library.exception.NoElementException;
import hu.simplesoft.dualis.library.exception.PersistEcxeption;

public class UserRepositoryImpl implements UserRepository {
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void createUser(UserEntity newUserEntity) throws PersistEcxeption {
        try {
            this.entityManager.persist(newUserEntity);
        } catch (RuntimeException e) {
            throw new PersistEcxeption("Couldn't create the user", e);
        }
    }

    @Override
    public void updateUser(UserEntity userEntityForUpdate, UserEntity newUserEntity) throws PersistEcxeption {
        try {
            userEntityForUpdate.setAddress(newUserEntity.getAddress());
            userEntityForUpdate.setEmail(newUserEntity.getEmail());
            userEntityForUpdate.setLibrary(newUserEntity.getLibrary());
            userEntityForUpdate.setName(newUserEntity.getName());
            userEntityForUpdate.setPassword(newUserEntity.getPassword());
            userEntityForUpdate.setPhoneNumber(newUserEntity.getPhoneNumber());
            userEntityForUpdate.setRole(newUserEntity.getRole());
            userEntityForUpdate.setUserName(newUserEntity.getUserName());

            this.entityManager.merge(userEntityForUpdate);
        } catch (RuntimeException e) {
            throw new PersistEcxeption("Couldn't update the user!", e);
        }
    }

    @Override
    public void deleteUser(UserEntity userEntityForDelete) throws PersistEcxeption {
        try {
            this.entityManager.remove(userEntityForDelete);
        } catch (RuntimeException e) {
            throw new PersistEcxeption("Couldn't delete the user!", e);
        }
    }

    @Override
    public UserEntity getUserById(long userId) throws PersistEcxeption {
        UserEntity foundEntity;

        try {
            foundEntity = this.entityManager.find(UserEntity.class, userId);
        } catch (RuntimeException e) {
            throw new PersistEcxeption("Couldn't find the user!", e);
        }
        return foundEntity;
    }

    @Override
    public List<UserEntity> getAllUsers() throws NoElementException {
        TypedQuery<UserEntity> queryForAllUsers;
        List<UserEntity> allUserEntities;
        try {
            queryForAllUsers = this.entityManager.createQuery("SELECT  h FROM users h", UserEntity.class);
            allUserEntities = queryForAllUsers.getResultList();
        } catch (RuntimeException e) {
            throw new NoElementException("Couldn't get all users!", e);
        }

        return allUserEntities;
    }
}
