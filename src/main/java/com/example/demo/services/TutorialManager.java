package com.example.demo.services;

import com.example.demo.DTOs.requests.AddTutorialRequest;
import com.example.demo.DTOs.responses.GetAllTutorials;
import com.example.demo.DTOs.responses.GetAllUsersResponse;
import com.example.demo.Entities.Tutorial;
import com.example.demo.Entities.User;
import com.example.demo.mapping.ModelMapperService;
import com.example.demo.mapping.TutorialMapper;
import com.example.demo.repository.ITutorialRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Data
public class TutorialManager implements ITutorialService{

    private final ITutorialRepository tutorialRepository;

    @Override
    public void addTutorial(AddTutorialRequest addTutorialRequest) {
        Tutorial tutorial = new Tutorial().fromDTO(addTutorialRequest, TutorialMapper.class);

    }

    @Override
    public void removeById(Long id) {
        Tutorial tutorial = tutorialRepository.findById(id).orElse(null);
        tutorialRepository.delete(tutorial);

    }

    @Override
    public List<GetAllTutorials> getAllTutorials() {
        List<Tutorial> tutorials = tutorialRepository.findAll();

        List<GetAllTutorials> tutorialRequests = tutorials.stream()
                .map(tutorial -> {
                    GetAllTutorials request = new GetAllTutorials();
                    request.setTitle(tutorial.getTitle());
                    request.setUrl(tutorial.getUrl());
                    return request;
                }).collect(Collectors.toList());
        return tutorialRequests;
    }
}
