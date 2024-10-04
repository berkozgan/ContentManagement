package com.example.demo.services;

import com.example.demo.DTOs.requests.AddTutorialRequest;
import com.example.demo.DTOs.responses.GetAllTutorials;

import java.util.List;

public interface ITutorialService {
    void addTutorial(AddTutorialRequest addTutorialRequest);
    void removeById(Long id);
    List<GetAllTutorials> getAllTutorials();
}
