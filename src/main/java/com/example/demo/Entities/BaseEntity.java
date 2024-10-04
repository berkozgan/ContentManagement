package com.example.demo.Entities;

import com.example.demo.DTOs.BaseDTO;
import com.example.demo.mapping.BaseMapper;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Data
@MappedSuperclass
public abstract class BaseEntity <T extends BaseDTO, S extends BaseEntity<T,S>> {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    public static <T extends BaseDTO, S extends BaseEntity>
    List<T> toDTOList(List<S> entityList,
                          Class<? extends BaseMapper<T, S>> clazz) {
        return Mappers.getMapper(clazz).toDTOList(entityList);    }

    public T toDTO(Class<? extends BaseMapper<T, S>> clazz) {
        return Mappers.getMapper(clazz).toDTO((S) this);    }

    public S fromDTO(T dto, Class<? extends BaseMapper<T, S>> clazz) {
        return Mappers.getMapper(clazz).toEntity(dto);    }
}
