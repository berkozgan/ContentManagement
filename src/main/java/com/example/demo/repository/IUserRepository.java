package com.example.demo.repository;

import com.example.demo.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IUserRepository extends JpaRepository<User, Long> {

    List<User> getUsersByFirstNameAndLastName(String firstname, String lastname);


}

