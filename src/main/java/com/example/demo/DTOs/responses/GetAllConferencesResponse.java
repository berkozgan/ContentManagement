package com.example.demo.DTOs.responses;

import com.example.demo.DTOs.BaseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllConferencesResponse extends BaseDTO {
    private Long id;
    private String title;
    private String url;
    private String author;
    private String createdBy;
}