package com.example.demo.mapping;

import com.example.demo.DTOs.requests.AddConferenceRequest;
import com.example.demo.Entities.Conference;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ConferenceMapper extends BaseMapper<AddConferenceRequest,Conference> {
    ConferenceMapper INSTANCE= Mappers.getMapper(ConferenceMapper.class);
}
