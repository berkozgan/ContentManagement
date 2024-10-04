package com.example.demo.services;

import com.example.demo.DTOs.requests.CreateUserRequest;
import com.example.demo.DTOs.responses.GetAllUsersResponse;
import com.example.demo.Entities.User;
import com.example.demo.mapping.ModelMapperService;
import com.example.demo.mapping.UserMapper;
import com.example.demo.repository.IUserRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Data
public class UserManager implements IUserService {


    private final IUserRepository userRepository;
    private  final ModelMapperService modelMapperService;



    @Override
    public List<GetAllUsersResponse> getAll() {

        List<User> users = userRepository.findAll();

        List<GetAllUsersResponse> usersResponse = users.stream()
                .map(user -> {
                    GetAllUsersResponse response = new GetAllUsersResponse();
                    response.setId(user.getId());
                    response.setFirstName(user.getFirstName());
                    response.setLastName(user.getLastName());
                    response.setUsername(user.getUsername());
                    response.setEmailAddress(user.getEmailAddress());
                    response.setTeamCode(user.getTeamCode());
                    response.setRole(user.getRole());
                    return response;
                }).collect(Collectors.toList());


        return usersResponse;
    }


    @Override
    public void add(CreateUserRequest createUserRequest) {
        User userEntity = new User().fromDTO(createUserRequest, UserMapper.class);
        this.userRepository.save(userEntity);

    }

    @Override
    public void removeById(Long id) {
        User user = this.userRepository.findById(id).orElse(null);
        this.userRepository.deleteById(id);

    }




}
