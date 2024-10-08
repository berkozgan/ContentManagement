package com.example.demo.controllers;

import com.example.demo.DTOs.requests.AddConferenceRequest;
import com.example.demo.DTOs.requests.AddPatentRequest;
import com.example.demo.DTOs.responses.GetAllConferencesResponse;
import com.example.demo.DTOs.responses.GetAllPatentsResponse;
import com.example.demo.services.IPatentService;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patents")
@Data
public class PatentsController {
    private final IPatentService patentService;

    @PostMapping("/addPatent")
    public void add(@RequestBody AddPatentRequest addPatentRequest) {
        patentService.addPatent(addPatentRequest);
    }

    @GetMapping("/getAllPatents")
    public List<GetAllPatentsResponse> getAll() {
        return patentService.getAllPatents();
    }

    @DeleteMapping("/removePatent")
    public void remove(Long id) {
        patentService.removeById(id);
    }
}
