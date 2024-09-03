package com.springrest.springrest.services;

import com.springrest.springrest.dto.UserDTO;
import com.springrest.springrest.entities.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<User> getAllUsers();
    Optional<User> getUserById(Long id);
    User saveUser(UserDTO userDTO);
    User updateUser(Long id, UserDTO userDTO);
    void deleteUser(Long id);
    Optional<User> getUserByUsername(String username);
}
