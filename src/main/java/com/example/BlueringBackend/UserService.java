package com.example.BlueringBackend;

import com.example.BlueringBackend.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO createUser(UserDTO userDTO);
    UserDTO updateUser(Integer id, UserDTO userDTO);
    UserDTO getUser(Integer id);
    List<UserDTO> getAllUsers();
    void deleteUser(Integer id);
}