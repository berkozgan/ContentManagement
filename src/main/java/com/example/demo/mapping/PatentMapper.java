package com.example.demo.mapping;

import com.example.demo.DTOs.requests.AddPatentRequest;
import com.example.demo.Entities.Patent;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PatentMapper extends BaseMapper<AddPatentRequest, Patent> {
    PatentMapper INSTANCE = Mappers.getMapper(PatentMapper.class);
}
