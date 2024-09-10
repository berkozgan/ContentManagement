package com.example.demo.controllers;

import com.example.demo.DTOs.requests.CreateUserRequest;
import com.example.demo.DTOs.responses.GetAllUsersResponse;
import com.example.demo.Entities.User;
import com.example.demo.services.IUserService;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@Data
public class UsersController {

    private final IUserService userService;


    @GetMapping("/getAll")
    public List<GetAllUsersResponse> getAll() {
        return userService.getAll();
    }

    @PostMapping("/add")
    public void add(CreateUserRequest createUserRequest) {
        userService.add(createUserRequest);
    }
}
