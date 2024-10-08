package com.example.demo.services;

import com.example.demo.DTOs.requests.AddPatentRequest;
import com.example.demo.DTOs.requests.AddTutorialRequest;
import com.example.demo.DTOs.responses.GetAllPatentsResponse;
import com.example.demo.Entities.Patent;

import java.util.List;

public interface IPatentService {
    void addPatent(AddPatentRequest addPatentRequest);
    void removeById(Long id);
    List<GetAllPatentsResponse> getAllPatents();
}
