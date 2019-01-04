package hu.simplesoft.dualis.library.data.mapper;


import java.util.ArrayList;
import java.util.List;

import hu.simplesoft.dualis.library.data.entity.UserEntity;
import hu.simplesoft.dualis.library.service.dto.UserDto;

public class UserMapper {
    
    public static UserEntity UserDtoToEntity(UserDto userDto) {
        UserEntity userEntity = new UserEntity();
        
        userEntity.setId(userDto.getId());
        userEntity.setUserName(userDto.getUserName());
        userEntity.setPassword(userDto.getPassword());
        userEntity.setEmail(userDto.getEmail());
        userEntity.setName(userDto.getName());
        userEntity.setPhoneNumber(userDto.getPhoneNumber());
        userEntity.setRole(RoleMapper.RoleDtoToEntity(userDto.getRole()));
        userEntity.setAddress(AddressMapper.AddressDtoToEntity(userDto.getAddress()));
        userEntity.setLibrary(LibraryMapper.LibraryDtoToEntity(userDto.getLibrary()));
        
        return userEntity;
    }
    
    public static UserDto UserEntityToDto(UserEntity userEntity) {
        UserDto userDto = new UserDto();
        
        userDto.setId(userEntity.getId());
        userDto.setUserName(userEntity.getUserName());
        userDto.setPassword(userEntity.getPassword());
        userDto.setEmail(userEntity.getEmail());
        userDto.setPhoneNumber(userEntity.getPhoneNumber());
        userDto.setRole(RoleMapper.RoleEntityToDto(userEntity.getRole()));
        userDto.setAddress(AddressMapper.AddressEntityToDto(userEntity.getAddress()));
        userDto.setLibrary(LibraryMapper.LibraryEntityToDto(userEntity.getLibrary()));
        
        
        return userDto;
    }
    
    public static List<UserDto> getAllUsersToDto(List<UserEntity> allUsersEntities){
        List<UserDto> allUsersDto = new ArrayList<UserDto>();
        
        for (UserEntity userEntity : allUsersEntities) {
            allUsersDto.add(UserEntityToDto(userEntity));
        }
        
        return allUsersDto;
    }

}
