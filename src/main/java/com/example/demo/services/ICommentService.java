package com.example.demo.services;

import com.example.demo.DTOs.requests.CreateCommentRequest;
import com.example.demo.DTOs.responses.GetAllCommentsResponse;
import com.example.demo.DTOs.responses.GetAllConferencesResponse;

import java.util.List;

public interface ICommentService {
    void addCommentToConference(Long conferenceId, CreateCommentRequest createCommentRequest);
    void addCommentToPatent(Long patentId, CreateCommentRequest createCommentRequest);
    void addCommentToTutorial(Long tutorialId, CreateCommentRequest createCommentRequest);
    void removeById(Long commentId);
    List<GetAllCommentsResponse> getCommentsForConference(Long conferenceId);
    List<GetAllCommentsResponse> getCommentsForPatent(Long patentId);
    List<GetAllCommentsResponse> getCommentsForTutorial(Long tutorialId);



}
