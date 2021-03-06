package hu.simplesoft.dualis.library.data.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.simplesoft.dualis.library.data.dao.UserDao;
import hu.simplesoft.dualis.library.data.entity.UserEntity;
import hu.simplesoft.dualis.library.data.mapper.UserMapper;
import hu.simplesoft.dualis.library.data.repository.UserRepository;
import hu.simplesoft.dualis.library.data.validator.ObjectValidator;
import hu.simplesoft.dualis.library.exception.PersistException;
import hu.simplesoft.dualis.library.service.dto.UserDto;

@Service
public class UserDaoImpl implements UserDao {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    @Override
    public void createUser(UserDto userDto) throws PersistException {
        UserEntity newUserEntity = UserMapper.UserDtoToEntity(userDto);
        this.userRepository.createUser(newUserEntity);
    }

    @Transactional
    @Override
    public void updateUser(UserDto userDto) throws PersistException {
        UserEntity userEntityForUpdate = this.userRepository.getUserById(userDto.getId());
        ObjectValidator.entityIsNull(userEntityForUpdate, userDto.getId());
        UserEntity newUserEntity = UserMapper.UserDtoToEntity(userDto);

        userEntityForUpdate = updateNewEntity(userEntityForUpdate, newUserEntity);

        this.userRepository.updateUser(userEntityForUpdate);
    }

    @Transactional
    @Override
    public void deleteUser(long userId) throws PersistException {
        UserEntity userEntityForDelete = this.userRepository.getUserById(userId);
        ObjectValidator.entityIsNull(userEntityForDelete, userId);
        this.userRepository.deleteUser(userEntityForDelete);
    }

    @Override
    public List<UserDto> getAllUsers() throws PersistException {
        List<UserEntity> allUserEntities = this.userRepository.getAllUsers();
        List<UserDto> allUsersDto = UserMapper.getAllUsersToDto(allUserEntities);

        return allUsersDto;
    }

    @Override
    public UserDto getUserById(long userId) throws PersistException {
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
