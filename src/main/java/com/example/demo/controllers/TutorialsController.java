package com.example.demo.controllers;

import com.example.demo.DTOs.requests.AddTutorialRequest;
import com.example.demo.DTOs.responses.GetAllTutorialsResponse;
import com.example.demo.services.ITutorialService;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tutorials")
@Data
public class TutorialsController {
    private final ITutorialService tutorialService;

    @PostMapping("/addTutorial")
    public void add(@RequestBody AddTutorialRequest addTutorialRequest) {
        tutorialService.addTutorial(addTutorialRequest);
    }

    @GetMapping("/getAllTutorial")
    public List<GetAllTutorialsResponse> getAll() {
        return tutorialService.getAllTutorials();
    }

    @DeleteMapping("/removeTutorial")
    public void remove(Long id) {
        tutorialService.removeById(id);
    }
}
