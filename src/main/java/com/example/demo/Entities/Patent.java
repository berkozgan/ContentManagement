package com.example.demo.Entities;

import com.example.demo.DTOs.requests.AddPatentRequest;
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
@Table(name = "patents")
@Entity
public class Patent extends BaseEntity<AddPatentRequest, Patent>{

    @Column(nullable = false)
    private String owner;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String createdBy;

    @Column(nullable = false)
    private LocalDateTime createdDateTime;

    @OneToMany(mappedBy = "patent", cascade = CascadeType.ALL)
    private List<Comment> comments;

}
