package com.springrest.springrest.controller;

import com.springrest.springrest.services.UserDetailServiceImpl;
import org.springframework.security.authentication.AuthenticationManager;
import com.springrest.springrest.dto.UserDTO;
import com.springrest.springrest.entities.User;
import com.springrest.springrest.services.IUserService;
import com.springrest.springrest.utility.JwtUtil;
import com.springrest.springrest.utility.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private IUserService userService;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailServiceImpl userDetailsService;

    @PostMapping(path = "/signup")
    public ResponseEntity<?> register(@RequestBody UserDTO auth) {
        try {
            if (userService.getUserByUsername(auth.getUsername()).isPresent()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User already exist");
            }
            auth.setPassword(PasswordUtil.encodePassword(auth.getPassword()));
            User savedAuth = userService.saveUser(auth);
            return ResponseEntity.status(HttpStatus.OK).body(savedAuth);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }

    @PostMapping("/userlogin")
    public ResponseEntity<String>  userlogin(@RequestBody UserDTO authenticationRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
        );

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        return ResponseEntity.status(HttpStatus.OK).body(jwtUtil.generateToken(userDetails));
    }
}
