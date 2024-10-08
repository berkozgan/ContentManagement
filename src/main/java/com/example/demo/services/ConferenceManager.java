package com.example.demo.services;

import com.example.demo.DTOs.requests.AddConferenceRequest;
import com.example.demo.DTOs.responses.GetAllConferencesResponse;
import com.example.demo.Entities.Conference;
import com.example.demo.mapping.ConferenceMapper;
import com.example.demo.repository.IConferenceRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Data
public class ConferenceManager implements IConferenceService{

    private final IConferenceRepository conferenceRepository;
    @Override
    public void addConference(AddConferenceRequest addConferenceRequest) {
        Conference conference = new Conference().fromDTO(addConferenceRequest, ConferenceMapper.class);
        this.conferenceRepository.save(conference);

    }

    @Override
    public void removeById(Long id) {
        Conference conference = conferenceRepository.findById(id).orElse(null);
        conferenceRepository.delete(conference);

    }

    @Override
    public List<GetAllConferencesResponse> getAllConferences() {
        List<Conference> conferences = conferenceRepository.findAll();
        List<GetAllConferencesResponse> conferenceRequests = conferences.stream()
                .map(conference -> {
                    GetAllConferencesResponse request = new GetAllConferencesResponse();
                    request.setId(conference.getId());
                    request.setTitle(conference.getTitle());
                    request.setUrl(conference.getUrl());
                    request.setAuthor(conference.getAuthor());
                    request.setCreatedBy(conference.getCreatedBy());
                    return request;
                }).collect(Collectors.toList());
        return conferenceRequests;
    }
}
