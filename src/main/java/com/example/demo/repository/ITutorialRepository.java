package com.example.demo.repository;

import com.example.demo.Entities.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITutorialRepository extends JpaRepository<Tutorial, Long> {
}
