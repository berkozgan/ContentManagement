package com.example.demo.DTOs.requests;

import com.example.demo.Entities.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest {
    //private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String password;
    private String teamCode;
    Role role;
}
