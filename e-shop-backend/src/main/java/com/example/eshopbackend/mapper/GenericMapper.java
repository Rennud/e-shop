package com.example.eshopbackend.mapper;

import org.mapstruct.Mapper;

import java.util.List;


public interface GenericMapper<E, D> {

    E toEntity(D dto);
    List<E> toEntity (List<D> dtoList);

    D toDto(E entity);
    List<D> toDto(List<E> entityList);
}
