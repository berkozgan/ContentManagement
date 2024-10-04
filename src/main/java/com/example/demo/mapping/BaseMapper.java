package com.example.demo.mapping;

import com.example.demo.DTOs.BaseDTO;
import com.example.demo.Entities.BaseEntity;

import java.util.List;

public interface BaseMapper <T extends BaseDTO, S extends BaseEntity>
{
    T toDTO(S entity);
    List<T> toDTOList(List<S> dtoList);
    S toEntity(T dto);
}
