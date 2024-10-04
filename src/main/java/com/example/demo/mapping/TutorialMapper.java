package com.example.demo.mapping;

import com.example.demo.DTOs.requests.AddTutorialRequest;
import com.example.demo.Entities.Tutorial;
import org.mapstruct.factory.Mappers;

public interface TutorialMapper extends BaseMapper<AddTutorialRequest, Tutorial> {
    TutorialMapper INSTANCE= Mappers.getMapper(TutorialMapper.class);
}
