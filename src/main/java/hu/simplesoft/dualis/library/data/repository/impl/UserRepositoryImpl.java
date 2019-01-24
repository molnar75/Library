package hu.simplesoft.dualis.library.data.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import hu.simplesoft.dualis.library.data.entity.UserEntity;
import hu.simplesoft.dualis.library.data.repository.UserRepository;
import hu.simplesoft.dualis.library.exception.NoElementException;
import hu.simplesoft.dualis.library.exception.PersistException;

@Repository
public class UserRepositoryImpl implements UserRepository {
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void createUser(UserEntity newUserEntity) throws PersistException {
        try {
            this.entityManager.persist(newUserEntity);
        } catch (RuntimeException e) {
            throw new PersistException("Couldn't create the user", e);
        }
    }

    @Override
    public void updateUser(UserEntity userEntityForUpdate) throws PersistException {
        try {
            this.entityManager.merge(userEntityForUpdate);
        } catch (RuntimeException e) {
            throw new PersistException("Couldn't update the user!", e);
        }
    }

    @Override
    public void deleteUser(UserEntity userEntityForDelete) throws PersistException {
        try {
            this.entityManager.remove(userEntityForDelete);
        } catch (RuntimeException e) {
            throw new PersistException("Couldn't delete the user!", e);
        }
    }

    @Override
    public UserEntity getUserById(long userId) throws PersistException {
        UserEntity foundEntity;

        try {
            foundEntity = this.entityManager.find(UserEntity.class, userId);
        } catch (RuntimeException e) {
            throw new PersistException("Couldn't find the user!", e);
        }
        return foundEntity;
    }

    @Override
    public List<UserEntity> getAllUsers() throws NoElementException {
        TypedQuery<UserEntity> queryForAllUsers;
        List<UserEntity> allUserEntities;
        try {
            queryForAllUsers = this.entityManager.createQuery("SELECT  a FROM User a", UserEntity.class);
            allUserEntities = queryForAllUsers.getResultList();
        } catch (RuntimeException e) {
            throw new NoElementException("Couldn't get all users!", e);
        }

        return allUserEntities;
    }
}
