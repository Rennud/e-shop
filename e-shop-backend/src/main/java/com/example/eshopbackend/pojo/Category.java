package com.example.eshopbackend.pojo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class Category {
    private long id;
    private String name;
    private List<Item> itemList;
}
