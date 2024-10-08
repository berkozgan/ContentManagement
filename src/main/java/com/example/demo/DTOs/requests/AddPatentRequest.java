package com.example.demo.DTOs.requests;

import com.example.demo.DTOs.BaseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddPatentRequest  {
    private String owner;
    private String title;
    private String description;
    private String createdBy;

}
