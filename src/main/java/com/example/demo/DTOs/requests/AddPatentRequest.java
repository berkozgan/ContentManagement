package com.example.demo.DTOs.requests;

import com.example.demo.DTOs.BaseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddPatentRequest extends BaseDTO {
    private String owner;
    private String title;
    private String description;
    private String createdBy;
    private LocalDateTime createdDateTime;

}
