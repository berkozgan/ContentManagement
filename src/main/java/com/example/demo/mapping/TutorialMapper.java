package com.example.demo.mapping;

import com.example.demo.DTOs.requests.AddTutorialRequest;
import com.example.demo.Entities.Tutorial;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TutorialMapper extends BaseMapper<AddTutorialRequest, Tutorial> {
    TutorialMapper INSTANCE= Mappers.getMapper(TutorialMapper.class);
}
