package com.example.demo.Entities;

import com.example.demo.DTOs.requests.AddConferenceRequest;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "conferences")
@Entity
public class Conference extends BaseEntity<AddConferenceRequest, Conference> {
    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String url;

    @Column(nullable = false)
    private String createdBy;

    @Column(nullable = false)
    private LocalDateTime createdDateTime;

    @OneToMany(mappedBy = "conference", cascade = CascadeType.ALL) //null donerse arrayliste çevir
    private List<Comment> comments;
}
