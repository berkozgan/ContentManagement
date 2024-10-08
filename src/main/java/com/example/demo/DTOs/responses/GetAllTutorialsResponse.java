package com.example.demo.DTOs.responses;

import com.example.demo.DTOs.BaseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllTutorialsResponse extends BaseDTO {
    private Long id;
    private String title;
    private String url;
    private String instructor;
    private String createdBy;
    private LocalDateTime createdDateTime;
}
