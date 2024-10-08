package com.example.demo.services;

import com.example.demo.DTOs.requests.AddTutorialRequest;
import com.example.demo.DTOs.responses.GetAllTutorialsResponse;
import com.example.demo.Entities.Tutorial;
import com.example.demo.mapping.TutorialMapper;
import com.example.demo.repository.ITutorialRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Data
public class TutorialManager implements ITutorialService{

    private final ITutorialRepository tutorialRepository;

    @Override
    public void addTutorial(AddTutorialRequest addTutorialRequest) {
        Tutorial tutorial = new Tutorial().fromDTO(addTutorialRequest, TutorialMapper.class);
        tutorial.setCreatedDateTime(LocalDateTime.now());
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

        List<GetAllTutorialsResponse> tutorialsResponses = tutorials.stream()
                .map(tutorial -> {
                    GetAllTutorialsResponse response = new GetAllTutorialsResponse();
                    response.setTitle(tutorial.getTitle());
                    response.setUrl(tutorial.getUrl());
                    response.setInstructor(tutorial.getInstructor());
                    response.setCreatedBy(tutorial.getCreatedBy());
                    response.setId(tutorial.getId());
                    response.setCreatedDateTime(tutorial.getCreatedDateTime());
                    return response;
                }).collect(Collectors.toList());
        return tutorialsResponses;
    }
}
