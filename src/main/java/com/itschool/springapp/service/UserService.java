package com.itschool.springapp.service;

import com.itschool.springapp.model.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO getUSer(long id);
    List<UserDTO> getAllUsers();
    UserDTO createUser(UserDTO userDTO);
    UserDTO updateUser(long id, UserDTO userDTO);
    void deleteUser(long id);
}
