package com.example.demo.DTOs.requests;

import com.example.demo.DTOs.BaseDTO;
import com.example.demo.Entities.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest extends BaseDTO {
    //private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String password;
    private String teamCode;
    Role role;
    private LocalDateTime createdDateTime;


}
