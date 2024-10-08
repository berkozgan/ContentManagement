package com.example.demo.services;

import com.example.demo.DTOs.requests.AddTutorialRequest;
import com.example.demo.DTOs.responses.GetAllTutorialsResponse;

import java.util.List;

public interface ITutorialService {
    void addTutorial(AddTutorialRequest addTutorialRequest);
    void removeById(Long id);
    List<GetAllTutorialsResponse> getAllTutorials();
}
