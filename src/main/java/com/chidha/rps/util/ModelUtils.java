package com.chidha.rps.util;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ModelUtils<E,T> {

    @Autowired
    private ModelMapper modelMapper;

    public E convertToEntity(T dtoObj, Class<E> entityClass) {
        E object =  modelMapper.map(dtoObj, entityClass);
        return object;
    }

    public T convertTDTO(E dtoObj, Class<T> entityClass) {
        T object =  modelMapper.map(dtoObj, entityClass);
        return object;
    }
}
