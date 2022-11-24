package com.example.eshopbackend.mapper;

import com.example.eshopbackend.dto.ItemDto;
import com.example.eshopbackend.entity.Item;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ItemMapper extends GenericMapper<Item, ItemDto> {
}
