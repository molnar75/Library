package hu.simplesoft.dualis.library.data.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import hu.simplesoft.dualis.library.data.dao.UserDao;
import hu.simplesoft.dualis.library.data.entity.UserEntity;
import hu.simplesoft.dualis.library.data.mapper.UserMapper;
import hu.simplesoft.dualis.library.service.dto.UserDto;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean createUser(UserDto userDto) {
        boolean isSuccess = false;
        UserEntity newUserEntity = UserMapper.UserDtoToEntity(userDto);
        
        try {
            this.entityManager.persist(newUserEntity);

            isSuccess = true;
        } catch (RuntimeException e) {
            //LOG
        }
            
        return isSuccess;
    }

    @Override
    public boolean updateUser(UserDto userDto) {
        boolean isSuccess = false;
        UserEntity userEntityForUpdate = this.entityManager.find(UserEntity.class, userDto.getId());
        UserEntity newUserEntity = UserMapper.UserDtoToEntity(userDto);

        if (userEntityForUpdate != null) {
            try {
                userEntityForUpdate.setAddress(newUserEntity.getAddress());
                userEntityForUpdate.setEmail(newUserEntity.getEmail());
                userEntityForUpdate.setLibrary(newUserEntity.getLibrary());
                userEntityForUpdate.setName(newUserEntity.getName());
                userEntityForUpdate.setPassword(newUserEntity.getPassword());
                userEntityForUpdate.setPhoneNumber(newUserEntity.getPhoneNumber());
                userEntityForUpdate.setRole(newUserEntity.getRole());
                userEntityForUpdate.setUserName(newUserEntity.getUserName());
    
                isSuccess = true;
            } catch (RuntimeException e) {
                //LOG
            }
        }
       
        return isSuccess;
    }

    @Override
    public boolean deleteUser(long userId) {
        boolean isSuccess = false;
        UserEntity userEntityForDelete = this.entityManager.find(UserEntity.class, userId);
        
        try {
            this.entityManager.remove(userEntityForDelete);

            isSuccess = true;
        } catch (RuntimeException e) {
            //LOG
        }
        
        return isSuccess;
    }

    @Override
    public List<UserDto> getAllUsers() {
        TypedQuery<UserEntity> queryForAllUser = this.entityManager.createQuery("SELECT  h FROM borrowed_books h", UserEntity.class);
        List<UserEntity> allUserEntities = queryForAllUser.getResultList();
        List<UserDto> allUsersDto = UserMapper.getAllUsersToDto(allUserEntities);

        return allUsersDto;
    }

    @Override
    public UserDto getUserById(long userId) {
        UserEntity foundEntity = this.entityManager.find(UserEntity.class, userId);

        return UserMapper.UserEntityToDto(foundEntity);
    }

}
