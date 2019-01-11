package hu.simplesoft.dualis.library.data.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import hu.simplesoft.dualis.library.data.dao.UserDao;
import hu.simplesoft.dualis.library.data.entity.UserEntity;
import hu.simplesoft.dualis.library.data.mapper.UserMapper;
import hu.simplesoft.dualis.library.data.repository.UserRepository;
import hu.simplesoft.dualis.library.exception.NoElementException;
import hu.simplesoft.dualis.library.exception.PersistEcxeption;
import hu.simplesoft.dualis.library.service.dto.UserDto;

@Transactional
public class UserDaoImpl implements UserDao {

    private UserRepository userRepository;

    @Override
    public void createUser(UserDto userDto) throws PersistEcxeption {
        UserEntity newUserEntity = UserMapper.UserDtoToEntity(userDto);
        this.userRepository.createUser(newUserEntity);
    }

    @Override
    public void updateUser(UserDto userDto) throws PersistEcxeption {
        UserEntity userEntityForUpdate = this.userRepository.getUserById(userDto.getId());
        UserEntity newUserEntity = UserMapper.UserDtoToEntity(userDto);

        if (userEntityForUpdate != null) {
            
            userEntityForUpdate.setAddress(newUserEntity.getAddress());
            userEntityForUpdate.setEmail(newUserEntity.getEmail());
            userEntityForUpdate.setLibrary(newUserEntity.getLibrary());
            userEntityForUpdate.setName(newUserEntity.getName());
            userEntityForUpdate.setPassword(newUserEntity.getPassword());
            userEntityForUpdate.setPhoneNumber(newUserEntity.getPhoneNumber());
            userEntityForUpdate.setRole(newUserEntity.getRole());
            userEntityForUpdate.setUserName(newUserEntity.getUserName()); 
            
            this.userRepository.updateUser(userEntityForUpdate);
        }
    }

    @Override
    public void deleteUser(long userId) throws PersistEcxeption {
        UserEntity userEntityForDelete = this.userRepository.getUserById(userId);
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
}
