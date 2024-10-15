package com.example.demo.controllers;

import com.example.demo.DTOs.requests.CreateCommentRequest;
import com.example.demo.DTOs.responses.GetAllCommentsResponse;
import com.example.demo.repository.ICommentRepository;
import com.example.demo.services.ICommentService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
@Data
public class CommentsController {
    private final ICommentService commentService;

    @PostMapping("/addCommentToConference/{conferenceId}")
    public ResponseEntity<String> addCommentToConference(@PathVariable Long conferenceId, @RequestBody CreateCommentRequest createCommentrRequest) {
        commentService.addCommentToConference(conferenceId, createCommentrRequest);
        return ResponseEntity.ok("Comment added to conference");
    }

    @PostMapping("/addCommentToPatent/{patentId}")
    public ResponseEntity<String> addCommentToPatent(@PathVariable Long patentId, @RequestBody CreateCommentRequest createCommentRequest) {
        commentService.addCommentToPatent(patentId, createCommentRequest);
        return ResponseEntity.ok("Comment added to patent");
    }

    @PostMapping("/addCommentToTutorial/{tutorialId}")
    public ResponseEntity<String> addCommentToTutorial(@PathVariable Long tutorialId, @RequestBody CreateCommentRequest createCommentRequest) {
        commentService.addCommentToTutorial(tutorialId, createCommentRequest);
        return ResponseEntity.ok("Comment added to tutorial");
    }

    @DeleteMapping("/removeCommentById/{commentId}")
    public ResponseEntity<String> deleteComment(@PathVariable Long commentId) {
        try {
            commentService.removeById(commentId);
            return ResponseEntity.ok("Comment deleted successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/getCommentsOfTheConference/{conferenceId}")
    public ResponseEntity<List<GetAllCommentsResponse>> getCommentsForConference(@PathVariable Long conferenceId) {
        List<GetAllCommentsResponse> comments = commentService.getCommentsForConference(conferenceId);
        return ResponseEntity.ok(comments);
    }

    @GetMapping("/getCommentsOfThePatent/{patentId}")
    public ResponseEntity<List<GetAllCommentsResponse>> getCommentsForPatent(@PathVariable Long patentId) {
        List<GetAllCommentsResponse> comments = commentService.getCommentsForPatent(patentId);
        return ResponseEntity.ok(comments);
    }

    @GetMapping("/getCommentsOfTheTutorial/{tutorialId}")
    public ResponseEntity<List<GetAllCommentsResponse>> getCommentsForTutorial(@PathVariable Long tutorialId) {
        List<GetAllCommentsResponse> comments = commentService.getCommentsForTutorial(tutorialId);
        return ResponseEntity.ok(comments);
    }





}
