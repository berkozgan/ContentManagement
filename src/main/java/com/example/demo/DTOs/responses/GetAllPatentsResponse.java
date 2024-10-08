package com.example.demo.DTOs.responses;

import com.example.demo.DTOs.BaseDTO;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllPatentsResponse extends BaseDTO {
    private Long id;
    private String owner;
    private String title;
    private String description;
    private String createdBy;
}
