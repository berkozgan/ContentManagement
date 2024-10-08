package com.example.demo.Entities;

import com.example.demo.DTOs.requests.AddTutorialRequest;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "tutorials")
public class Tutorial extends BaseEntity<AddTutorialRequest, Tutorial> {

    @Column(nullable = false)
    private String instructor;

    @Column(nullable = false, unique = true)
    private String title;

    @Column(nullable = false, unique = true)
    private  String url;

    @Column(nullable = false)
    private String createdBy;

    @Column(nullable = false)
    private LocalDateTime createdDateTime;


}
