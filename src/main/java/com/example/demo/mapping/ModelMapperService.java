package com.example.demo.mapping;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

public interface ModelMapperService {

    ModelMapper forResponse();
    ModelMapper forRequest();
}
