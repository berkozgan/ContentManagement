package com.example.demo.DTOs.requests;

import com.example.demo.DTOs.BaseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddConferenceRequest extends BaseDTO {
    private String title;
    private String url;
    private String author;
    private String createdBy;
    private LocalDateTime createdDateTime;
}
