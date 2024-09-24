package com.example.demo.mapping;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service//vid
@AllArgsConstructor//vid
@NoArgsConstructor//bu olmayınca hata
public class ModelMapperManager implements ModelMapperService{

   private ModelMapper modelMapper;


    @Override
    public ModelMapper forResponse() {
        this.modelMapper.getConfiguration()
                .setAmbiguityIgnored(true)
                .setMatchingStrategy(MatchingStrategies.LOOSE);//response nesnemde her sey donmeyebilir(password)

        return this.modelMapper;
    }

    @Override
    public ModelMapper forRequest() {
        this.modelMapper.getConfiguration()
                .setAmbiguityIgnored(true)
                .setMatchingStrategy(MatchingStrategies.STANDARD);// request alığımda da id yok loose?

        return this.modelMapper;
    }
}
