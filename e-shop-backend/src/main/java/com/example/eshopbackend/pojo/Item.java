package com.example.eshopbackend.pojo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Builder
@Getter
@Setter
public class Item {
    private long id;
    private String name;
    private double price;
}
