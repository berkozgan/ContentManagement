package com.example.demo.services;

import com.example.demo.DTOs.requests.AddConferenceRequest;
import com.example.demo.DTOs.responses.GetAllConferencesResponse;

import java.util.List;

public interface IConferenceService {
    void addConference(AddConferenceRequest conferenceRequest);
    void removeById(Long id);
    List<GetAllConferencesResponse> getAllConferences();

}
