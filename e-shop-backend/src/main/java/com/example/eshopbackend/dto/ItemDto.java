package com.example.eshopbackend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;


public record ItemDto(
        @JsonProperty
        long id,

        @JsonProperty
        String name,

        @JsonProperty
        double price) {

}
