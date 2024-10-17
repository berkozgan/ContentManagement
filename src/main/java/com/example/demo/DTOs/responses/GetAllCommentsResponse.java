package com.example.demo.DTOs.responses;

import com.example.demo.DTOs.BaseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCommentsResponse extends BaseDTO {
    private Long id;
    private String content;
    private String username;
    private LocalDateTime createdDateTime;
    private int rating;
}
