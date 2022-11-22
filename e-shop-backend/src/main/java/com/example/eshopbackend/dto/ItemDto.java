package com.example.eshopbackend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;


public record ItemDto (
        @JsonProperty
        long id,

        @JsonProperty
        String name,

        @JsonProperty
        double price)
{

}
