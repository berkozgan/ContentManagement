package com.example.demo.services;

import com.example.demo.DTOs.requests.CreateUserRequest;
import com.example.demo.DTOs.responses.GetAllUsersResponse;
import com.example.demo.Entities.User;
import com.example.demo.mapping.ModelMapperService;
import com.example.demo.repository.IUserRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        /*List<GetAllUsersResponse> usersResponse = new ArrayList<GetAllUsersResponse>();
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
        }*/
        List<GetAllUsersResponse> usersResponse = users.stream()
                .map(user -> this.modelMapperService.forResponse()
                        .map(user, GetAllUsersResponse.class)).collect(Collectors.toList());

        return usersResponse;
    }

    @Override
    public void add(CreateUserRequest createUserRequest) {
        /*User user = new User();
        user.setUsername(createUserRequest.getUsername());
        user.setFirstName(createUserRequest.getFirstName());
        user.setLastName(createUserRequest.getLastName());
        user.setEmailAddress(createUserRequest.getEmailAddress());
        user.setTeamCode(createUserRequest.getTeamCode());
        user.setRole(createUserRequest.getRole());
        user.setPassword(createUserRequest.getPassword());
*/
        User user = this.modelMapperService.forRequest().map(createUserRequest, User.class);
        this.userRepository.save(user);
    }



}
