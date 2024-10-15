package com.example.demo.services;

import com.example.demo.DTOs.requests.CreateCommentRequest;
import com.example.demo.DTOs.responses.GetAllCommentsResponse;
import com.example.demo.Entities.*;
import com.example.demo.repository.*;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Data
public class CommentManager implements ICommentService{

    private final IUserRepository userRepository;
    private final IPatentRepository patentRepository;
    private final ITutorialRepository tutorialRepository;
    private final IConferenceRepository conferenceRepository;
    private final ICommentRepository commentRepository;

    @Override
    public void addCommentToConference(Long conferenceId, CreateCommentRequest createCommentRequest) {
        User user = userRepository.findById(createCommentRequest.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Conference conference = conferenceRepository.findById(conferenceId)
                .orElseThrow(() -> new RuntimeException("Conference not found"));

        Comment comment = new Comment();
        comment.setContent(createCommentRequest.getContent());
        comment.setUser(user);
        comment.setConference(conference);
        comment.setCreatedDateTime(LocalDateTime.now());

        commentRepository.save(comment);

    }

    @Override
    public void addCommentToPatent(Long patentId, CreateCommentRequest createCommentRequest) {
        User user = userRepository.findById(createCommentRequest.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Patent patent = patentRepository.findById(patentId)
                .orElseThrow(() -> new RuntimeException("Patent not found"));

        Comment comment = new Comment();
        comment.setContent(createCommentRequest.getContent());
        comment.setUser(user);
        comment.setPatent(patent);
        comment.setCreatedDateTime(LocalDateTime.now());

        commentRepository.save(comment);

    }

    @Override
    public void addCommentToTutorial(Long tutorialId, CreateCommentRequest createCommentRequest) {
        User user = userRepository.findById(createCommentRequest.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Tutorial tutorial = tutorialRepository.findById(tutorialId)
                .orElseThrow(() -> new RuntimeException("Tutorial not found"));

        Comment comment = new Comment();
        comment.setContent(createCommentRequest.getContent());
        comment.setUser(user);
        comment.setTutorial(tutorial);
        comment.setCreatedDateTime(LocalDateTime.now());

        commentRepository.save(comment);

    }

    @Override
    public void removeById(Long commentId) {
        if (!commentRepository.existsById(commentId)) {
            throw new RuntimeException("Comment not found");
        }
        commentRepository.deleteById(commentId);
    }

    @Override
    public List<GetAllCommentsResponse> getCommentsForConference(Long conferenceId) {
        Conference conference = conferenceRepository.findById(conferenceId)
                .orElseThrow(() -> new RuntimeException("Conference not found"));

        List<Comment> comments = conference.getComments();
        return comments.stream()
                .map(comment -> new GetAllCommentsResponse(comment.getId(), comment.getContent(), comment.getUser().getUsername(), comment.getCreatedDateTime()))
                .collect(Collectors.toList());


    }

    @Override
    public List<GetAllCommentsResponse> getCommentsForPatent(Long patentId) {
        Patent patent = patentRepository.findById(patentId)
                .orElseThrow(() -> new RuntimeException("Patent not found"));

        List<Comment> comments = patent.getComments();
        return comments.stream()
                .map(comment -> new GetAllCommentsResponse(comment.getId(), comment.getContent(), comment.getUser().getUsername(), comment.getCreatedDateTime()))
                .collect(Collectors.toList());
    }



    @Override
    public List<GetAllCommentsResponse> getCommentsForTutorial(Long tutorialId) {
        Tutorial tutorial = tutorialRepository.findById(tutorialId)
                .orElseThrow(() -> new RuntimeException("Tutorial not found"));

        List<Comment> comments = tutorial.getComments();
        return comments.stream()
                .map(comment -> new GetAllCommentsResponse(comment.getId(), comment.getContent(), comment.getUser().getUsername(), comment.getCreatedDateTime()))
                .collect(Collectors.toList());
    }



}

