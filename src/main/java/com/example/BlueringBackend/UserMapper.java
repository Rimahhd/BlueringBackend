package com.example.BlueringBackend;

import com.example.BlueringBackend.UserDTO;
import com.example.BlueringBackend.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    // MapStruct will automatically map fields with the same name
    UserEntity userDtoToUserEntity(UserDTO userDTO);

    // MapStruct will automatically map fields with the same name
    UserDTO userEntityToUserDto(UserEntity userEntity);
}
