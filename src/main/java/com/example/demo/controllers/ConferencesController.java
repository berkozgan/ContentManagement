package com.example.demo.controllers;

import com.example.demo.DTOs.requests.AddConferenceRequest;
import com.example.demo.DTOs.responses.GetAllConferencesResponse;
import com.example.demo.services.IConferenceService;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/conferences")
@Data
public class ConferencesController {
    private final IConferenceService conferenceService;

    @PostMapping("/addConference")
    public void add(@RequestBody AddConferenceRequest addConferenceRequest) {
        conferenceService.addConference(addConferenceRequest);
    }

    @GetMapping("/getAllConferences")
    public List<GetAllConferencesResponse> getAll() {
        return conferenceService.getAllConferences();
    }

    @DeleteMapping("/removeConference")
    public void remove(Long id) {
        conferenceService.removeById(id);
    }

}
