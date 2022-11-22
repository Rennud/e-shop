package com.example.eshopbackend.dto;


import com.example.eshopbackend.entity.Item;
import com.example.eshopbackend.entity.User;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record OrderDto(
        @JsonProperty
        long id,

        @JsonProperty
        long userId,

        @JsonProperty
        int quantity,

        @JsonProperty
        double totalPrice,

        @JsonProperty
        User user,

        @JsonProperty
        List<Item>itemList
) {

}
