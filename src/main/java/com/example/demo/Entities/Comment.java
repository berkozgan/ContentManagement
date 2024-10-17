package com.example.demo.Entities;

import com.example.demo.DTOs.requests.CreateCommentRequest;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "comments")
public class Comment extends BaseEntity<CreateCommentRequest, Comment> {

    @Column(nullable = true)
    private String content;

    @Column(nullable = false)
    private LocalDateTime createdDateTime;

    @Min(1)
    @Max(5)
    @Column(nullable = false)
    private int rating;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "conference_id", nullable = true)
    private Conference conference;

    @ManyToOne
    @JoinColumn(name = "tutorial_id", nullable = true)
    private Tutorial tutorial;

    @ManyToOne
    @JoinColumn(name = "patent_id", nullable = true)
    private Patent patent;




}
