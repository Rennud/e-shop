package com.example.eshopbackend.dto;

import com.example.eshopbackend.entity.Order;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record UserDto (

        @JsonProperty
        long id,
        @JsonProperty
        String email,
        @JsonProperty
        String username,
        @JsonProperty
        String firstName,
        @JsonProperty
        String lastName,
        @JsonProperty
        String password,
        @JsonProperty
        List<Order> orderList
){
}
