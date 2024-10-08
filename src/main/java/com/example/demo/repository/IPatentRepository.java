package com.example.demo.repository;

import com.example.demo.Entities.Patent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPatentRepository extends JpaRepository<Patent, Long> {
}
