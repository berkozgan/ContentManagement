package com.example.demo.services;

import com.example.demo.DTOs.requests.AddPatentRequest;
import com.example.demo.DTOs.requests.AddTutorialRequest;
import com.example.demo.DTOs.responses.GetAllPatentsResponse;
import com.example.demo.Entities.Patent;
import com.example.demo.mapping.PatentMapper;
import com.example.demo.repository.IPatentRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Data
public class PatentManager implements IPatentService {

    private final IPatentRepository patentRepository;

    @Override
    public void addPatent(AddPatentRequest addPatentRequest) {
        Patent patent = new Patent().fromDTO(addPatentRequest, PatentMapper.class);
        this.patentRepository.save(patent);
    }

    @Override
    public void removeById(Long id) {
        Patent patent = patentRepository.findById(id).orElse(null);
        patentRepository.delete(patent);

    }

    @Override
    public List<GetAllPatentsResponse> getAllPatents() {
        List<Patent> patents = patentRepository.findAll();
        List<GetAllPatentsResponse> patentsResponses = patents.stream()
                .map(patent -> {
                    GetAllPatentsResponse response = new GetAllPatentsResponse();
                    response.setId(patent.getId());
                    response.setTitle(patent.getTitle());
                    response.setDescription(patent.getDescription());
                    response.setOwner(patent.getOwner());
                    response.setCreatedBy(patent.getCreatedBy());
                    return response;
                }).collect(Collectors.toList());
        return patentsResponses;
    }
}
