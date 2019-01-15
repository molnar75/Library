package hu.simplesoft.dualis.library.service.component.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.simplesoft.dualis.library.data.dao.UserDao;
import hu.simplesoft.dualis.library.exception.PersistException;
import hu.simplesoft.dualis.library.service.component.UserService;
import hu.simplesoft.dualis.library.service.dto.UserDto;
import hu.simplesoft.dualis.library.service.exception.ServiceException;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    
    @Override
    public void createUser(UserDto userDto) throws ServiceException {
        try {
            this.userDao.createUser(userDto);
        } catch (PersistException e) {
            throw new ServiceException(e);
        }         
    }

    @Override
    public void updateUser(UserDto userDto) throws ServiceException {
        try {
            this.userDao.updateUser(userDto);
        } catch (PersistException e) {
            throw new ServiceException(e);
        }        
    }

    @Override
    public void deleteUser(long userId) throws ServiceException {
        try {
            this.userDao.deleteUser(userId);
        } catch (PersistException e) {
            throw new ServiceException(e);
        }     
    }

    @Override
    public UserDto getUserById(long userId) throws ServiceException {
        UserDto foundUserDto;
        try {
            foundUserDto = this.userDao.getUserById(userId);
        } catch (PersistException e) {
            throw new ServiceException(e);
        }  
        return foundUserDto;
    }

    @Override
    public List<UserDto> getAllUsers() throws ServiceException {
        List<UserDto> allUsersDto;
        try {
            allUsersDto = this.userDao.getAllUsers();
        } catch (PersistException e) {
            throw new ServiceException(e);
        }  
        return allUsersDto;
    }
}
