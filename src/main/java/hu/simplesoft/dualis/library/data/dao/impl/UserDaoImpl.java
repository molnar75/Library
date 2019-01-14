package hu.simplesoft.dualis.library.data.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import hu.simplesoft.dualis.library.data.dao.UserDao;
import hu.simplesoft.dualis.library.data.entity.UserEntity;
import hu.simplesoft.dualis.library.data.mapper.UserMapper;
import hu.simplesoft.dualis.library.data.repository.UserRepository;
import hu.simplesoft.dualis.library.data.validator.ObjectValidator;
import hu.simplesoft.dualis.library.exception.IsNullException;
import hu.simplesoft.dualis.library.exception.NoElementException;
import hu.simplesoft.dualis.library.exception.PersistEcxeption;
import hu.simplesoft.dualis.library.service.dto.UserDto;

@Transactional
public class UserDaoImpl implements UserDao {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void createUser(UserDto userDto) throws PersistEcxeption {
        UserEntity newUserEntity = UserMapper.UserDtoToEntity(userDto);
        this.userRepository.createUser(newUserEntity);
    }

    @Override
    public void updateUser(UserDto userDto) throws PersistEcxeption, IsNullException {
        UserEntity userEntityForUpdate = this.userRepository.getUserById(userDto.getId());
        ObjectValidator.entityIsNull(userEntityForUpdate, userDto.getId());
        UserEntity newUserEntity = UserMapper.UserDtoToEntity(userDto);

        userEntityForUpdate = updateNewEntity(userEntityForUpdate, newUserEntity);

        this.userRepository.updateUser(userEntityForUpdate);
    }

    @Override
    public void deleteUser(long userId) throws PersistEcxeption, IsNullException {
        UserEntity userEntityForDelete = this.userRepository.getUserById(userId);
        ObjectValidator.entityIsNull(userEntityForDelete, userId);
        this.userRepository.deleteUser(userEntityForDelete);
    }

    @Override
    public List<UserDto> getAllUsers() throws NoElementException {
        List<UserEntity> allUserEntities = this.userRepository.getAllUsers();
        List<UserDto> allUsersDto = UserMapper.getAllUsersToDto(allUserEntities);

        return allUsersDto;
    }

    @Override
    public UserDto getUserById(long userId) throws PersistEcxeption {
        UserEntity foundEntity = this.userRepository.getUserById(userId);

        return UserMapper.UserEntityToDto(foundEntity);
    }

    private UserEntity updateNewEntity(UserEntity userEntityForUpdate, UserEntity newUserEntity) {
        userEntityForUpdate.setAddress(newUserEntity.getAddress());
        userEntityForUpdate.setEmail(newUserEntity.getEmail());
        userEntityForUpdate.setLibrary(newUserEntity.getLibrary());
        userEntityForUpdate.setName(newUserEntity.getName());
        userEntityForUpdate.setPassword(newUserEntity.getPassword());
        userEntityForUpdate.setPhoneNumber(newUserEntity.getPhoneNumber());
        userEntityForUpdate.setRole(newUserEntity.getRole());
        userEntityForUpdate.setUserName(newUserEntity.getUserName());

        return userEntityForUpdate;
    }
}
