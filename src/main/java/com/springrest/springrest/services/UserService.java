package com.springrest.springrest.services;

import com.springrest.springrest.dto.ContactDTO;
import com.springrest.springrest.dto.UserDTO;
import com.springrest.springrest.entities.Contact;
import com.springrest.springrest.entities.ContactDetail;
import com.springrest.springrest.entities.User;
import com.springrest.springrest.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User saveUser(UserDTO userDTO) {
        User user = new User(0,userDTO.getUsername(),userDTO.getPassword());
        return userRepository.save(user);
    }

    @Transactional
    public User updateUser(Long id, UserDTO userDTO) {
        Optional<User> optionalUser = userRepository.findById(id);

        if (!optionalUser.isPresent()) {
            throw new RuntimeException("User not found with id: " + id);
        }

        User existingUser = optionalUser.get();
        existingUser.setPassword(userDTO.getPassword());

        return userRepository.save(existingUser);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Optional<User> getUserByUsername(String username) {
        return Optional.ofNullable(userRepository.findByUsername(username));
    }
}
