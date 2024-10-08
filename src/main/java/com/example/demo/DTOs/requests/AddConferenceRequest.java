package com.example.demo.DTOs.requests;

import com.example.demo.DTOs.BaseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddConferenceRequest extends BaseDTO {
    private String title;
    private String url;
    private String author;
    private String createdBy;
}
