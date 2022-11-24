package com.example.eshopbackend.mapper;

import com.example.eshopbackend.dto.OrderDto;
import com.example.eshopbackend.entity.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper extends GenericMapper<Order, OrderDto> {
}
