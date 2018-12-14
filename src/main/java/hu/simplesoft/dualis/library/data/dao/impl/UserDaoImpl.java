package hu.simplesoft.dualis.library.data.dao.impl;

import java.util.List;

import hu.simplesoft.dualis.library.data.dao.UserDao;
import hu.simplesoft.dualis.library.service.dto.UserDto;

public class UserDaoImpl implements UserDao {

    public boolean createUser(UserDto userDto) {
        boolean isSuccess = false;
        try {
            //try to create

            isSuccess = true;
        } catch (RuntimeException e) {
            
        }
             
        return isSuccess;
    }

    public boolean updateUser(UserDto userDto) {
        boolean isSuccess = false;
        try {
            //try to update

            isSuccess = true;
        } catch (RuntimeException e) {
            
        }
       
        return isSuccess;
    }

    public boolean deleteUser(long userId) {
        boolean isSuccess = false;
        try {
            //try to delete

            isSuccess = true;
        } catch (RuntimeException e) {
            
        }
        
        return isSuccess;
    }

    public List<UserDto> getAllUsers() {
        // TODO Auto-generated method stub
        return null;
    }

    public boolean getUserById(long userId) {
        boolean isSuccess = false;
        try {
            //try to get user by id

            isSuccess = true;
        } catch (RuntimeException e) {
            
        }
        
        return isSuccess;
    }

}
