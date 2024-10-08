package com.example.demo.DTOs.requests;

import com.example.demo.DTOs.BaseDTO;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddTutorialRequest extends BaseDTO {
    private String title;
    private String url;
    private String instructor;
    private String createdBy;
    private LocalDateTime createdDateTime;


}
