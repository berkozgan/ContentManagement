package com.example.demo.services;

import com.example.demo.DTOs.requests.CreateUserRequest;
import com.example.demo.DTOs.responses.GetAllUsersResponse;
import com.example.demo.Entities.User;
import com.example.demo.repository.IUserRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Data
public class UserManager implements IUserService {

    private final IUserRepository userRepository;


    @Override
    public List<GetAllUsersResponse> getAll() {
        List<User> users = userRepository.findAll();
        List<GetAllUsersResponse> usersResponse = new ArrayList<GetAllUsersResponse>();

        for (User user : users) {
            GetAllUsersResponse ResponseItem = new GetAllUsersResponse();
            ResponseItem.setId(user.getId());
            ResponseItem.setUsername(user.getUsername());
            ResponseItem.setFirstName(user.getFirstName());
            ResponseItem.setLastName(user.getLastName());
            ResponseItem.setEmailAddress(user.getEmailAddress());
            ResponseItem.setTeamCode(user.getTeamCode());
            ResponseItem.setRole(user.getRole());

            usersResponse.add(ResponseItem);


        }

        return usersResponse;
    }

    @Override
    public void add(CreateUserRequest createUserRequest) {
        User user = new User();
        user.setUsername(createUserRequest.getUsername());
        user.setFirstName(createUserRequest.getFirstName());
        user.setLastName(createUserRequest.getLastName());
        user.setEmailAddress(createUserRequest.getEmailAddress());
        user.setTeamCode(createUserRequest.getTeamCode());
        user.setRole(createUserRequest.getRole());
        user.setPassword(createUserRequest.getPassword());

        this.userRepository.save(user);
    }
}
