package com.springrest.springrest.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO{

    @NotEmpty(message = "Username cannot be empty")
    @Size(max = 100, message = "Username cannot be longer than 100 characters")
    public String username;

    @NotEmpty(message = "Username cannot be empty")
    @Size(max = 100, message = "Username cannot be longer than 100 characters")
    public String password;
}
