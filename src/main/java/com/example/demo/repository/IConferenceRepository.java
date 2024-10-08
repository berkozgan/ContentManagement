package com.example.demo.repository;

import com.example.demo.Entities.Conference;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IConferenceRepository extends JpaRepository<Conference, Long> {
}
