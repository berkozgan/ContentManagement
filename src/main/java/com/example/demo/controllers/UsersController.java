package com.example.demo.controllers;

import com.example.demo.DTOs.requests.CreateUserRequest;
import com.example.demo.DTOs.responses.GetAllUsersResponse;
import com.example.demo.services.IUserService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
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
    public void add(@RequestBody CreateUserRequest createUserRequest) {
        userService.add(createUserRequest);
    }
    @GetMapping("/index")
    public String index(){
        return "index sayfası, hoşgeldiniz";
    }

    @GetMapping("/dashboard")
    public String dashboard(){
        return "login başarılı, dashboard sayfası";
    }




}
