package com.example.BlueringBackend;

import com.example.BlueringBackend.UserDTO;
import com.example.BlueringBackend.UserEntity;
import com.example.BlueringBackend.UserMapper;
import com.example.BlueringBackend.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements com.example.BlueringBackend.UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserDTO createUser(UserDTO userDTO) {
        UserEntity userEntity = userMapper.userDtoToUserEntity(userDTO);
        UserEntity savedUser = userRepository.save(userEntity);
        return userMapper.userEntityToUserDto(savedUser);
    }

    public UserDTO updateUser(Integer id, UserDTO userDTO) {
        Optional<UserEntity> optionalUserEntity = userRepository.findById(id);
        if (optionalUserEntity.isPresent()) {
            UserEntity existingUser = optionalUserEntity.get();
            existingUser.setName(userDTO.getName());
            existingUser.setFName(userDTO.getFName());
            existingUser.setPhoneNb(userDTO.getPhoneNb());
            UserEntity updatedUser = userRepository.save(existingUser);
            return userMapper.userEntityToUserDto(updatedUser);
        }
        return null; // Handle error or throw exception
    }

    public UserDTO getUser(Integer id) {
        Optional<UserEntity> optionalUserEntity = userRepository.findById(id);
        return optionalUserEntity.map(userMapper::userEntityToUserDto).orElse(null);
    }

    public List<UserDTO> getAllUsers() {
        List<UserEntity> users = userRepository.findAll();
        return users.stream()
                .map(userMapper::userEntityToUserDto)
                .collect(Collectors.toList());
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}