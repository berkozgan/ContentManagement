package com.example.demo.services;

import com.example.demo.DTOs.requests.AddTutorialRequest;
import com.example.demo.DTOs.responses.GetAllTutorialsResponse;
import com.example.demo.Entities.Tutorial;
import com.example.demo.mapping.TutorialMapper;
import com.example.demo.repository.ITutorialRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Data
public class TutorialManager implements ITutorialService{

    private final ITutorialRepository tutorialRepository;

    @Override
    public void addTutorial(AddTutorialRequest addTutorialRequest) {
        Tutorial tutorial = new Tutorial().fromDTO(addTutorialRequest, TutorialMapper.class);
        this.tutorialRepository.save(tutorial);

    }

    @Override
    public void removeById(Long id) {
        Tutorial tutorial = tutorialRepository.findById(id).orElse(null);
        tutorialRepository.delete(tutorial);

    }

    @Override
    public List<GetAllTutorialsResponse> getAllTutorials() {
        List<Tutorial> tutorials = tutorialRepository.findAll();

        List<GetAllTutorialsResponse> tutorialRequests = tutorials.stream()
                .map(tutorial -> {
                    GetAllTutorialsResponse request = new GetAllTutorialsResponse();
                    request.setTitle(tutorial.getTitle());
                    request.setUrl(tutorial.getUrl());
                    request.setInstructor(tutorial.getInstructor());
                    request.setCreatedBy(tutorial.getCreatedBy());
                    request.setId(tutorial.getId());
                    return request;
                }).collect(Collectors.toList());
        return tutorialRequests;
    }
}
