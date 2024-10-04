package com.example.demo.mapping;

import com.example.demo.DTOs.requests.CreateUserRequest;
import com.example.demo.Entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper extends BaseMapper<CreateUserRequest, User>{
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
}
