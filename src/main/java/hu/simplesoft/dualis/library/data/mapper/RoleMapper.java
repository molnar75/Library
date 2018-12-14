package hu.simplesoft.dualis.library.data.mapper;

import hu.simplesoft.dualis.library.data.entity.RoleEntity;
import hu.simplesoft.dualis.library.service.dto.RoleDto;

public class RoleMapper {

    public static RoleEntity RoleDtoToEntity(RoleDto roleDto) {
        RoleEntity roleEntity = new RoleEntity();
        
        roleEntity.setId(roleDto.getId());
        roleEntity.setRole(roleDto.getRole());
        
        return roleEntity;
    }
    
    public static RoleDto RoleEntityToDto(RoleEntity roleEntity) {
        RoleDto roleDto = new RoleDto();
        
        roleDto.setId(roleEntity.getId());
        roleDto.setRole(roleEntity.getRole());
        
        return roleDto;
    }
}
