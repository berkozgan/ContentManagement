package com.example.demo.services;

import com.example.demo.DTOs.requests.CreateUserRequest;
import com.example.demo.DTOs.responses.GetAllUsersResponse;

import java.util.List;

public interface IUserService {
    List<GetAllUsersResponse> getAll();
    void add(CreateUserRequest createUserRequest);
    void removeById(Long id);



}
